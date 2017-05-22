package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zajic on 03.04.17.
 */
public class Polynomial {
    public static final Polynomial ONE = new Polynomial().withCoefficientAndDegree(1, 0);
    public static final Polynomial ZERO = new Polynomial();

    List<Monomial> monomialList;

    public Polynomial(){
        monomialList = new ArrayList<>();
        monomialList.add(Monomial.ZERO);
    }

    public Polynomial withCoefficientAndDegree(int coefficient, int degree){
        monomialList.add(new Monomial().withCoefficient(coefficient).withDegree(degree));
        compact();
        return this;
    }

    public Polynomial withMonomial(Monomial monomial){
        monomialList.add(monomial);
        compact();
        return this;
    }

    public Polynomial add(Polynomial term){
        Polynomial result = new Polynomial();
        Polynomial copyTerm = term.copy();

        monomialList.forEach(monomial -> {
            int index = copyTerm.getIndexOfMonomialWithDegree(monomial.getDegree());

            if (index != -1) {
                result.withMonomial(monomial.add(copyTerm.getMonomialList().get(index)));
                copyTerm.getMonomialList().remove(index);
            } else
                result.withMonomial(new Monomial()
                        .withCoefficient(monomial.getCoefficient())
                        .withDegree(monomial.getDegree()));
        });

        if (copyTerm.getMonomialList().size() > 0) {
            copyTerm.getMonomialList().forEach(monomial ->
                    result.withMonomial(new Monomial()
                            .withCoefficient(monomial.getCoefficient())
                            .withDegree(monomial.getDegree())));
        }

        return result.compact();
    }

    public Polynomial subtract(Polynomial subtrahend){
        return add(subtrahend.negate());
    }

    public Polynomial multiply(Polynomial multiplier){
        Polynomial result = new Polynomial();

        for (Monomial monomial : monomialList){
            Polynomial innerTempResult = new Polynomial();

            for(Monomial multiplierMonomial : multiplier.getMonomialList()) {
                innerTempResult.withMonomial(monomial.multiply(multiplierMonomial));
            }

            result = result.add(innerTempResult);
        }

        return result.compact();
    }

    //если степень делителя меньше
    public RationalPolynomial divide(Polynomial divisor){
        if (monomialWithMaxDegree().getDegree() < divisor.monomialWithMaxDegree().getDegree())
            throw new IllegalStateException("Степень делителя должна быть выше делимого");

        Polynomial reminder = copy();
        Polynomial wholePart = new Polynomial();

        while(reminder.monomialWithMaxDegree().getDegree() >= divisor.monomialWithMaxDegree().getDegree()) {

            Monomial monoWholePart = reminder.monomialWithMaxDegree().divide(divisor.monomialWithMaxDegree());
            wholePart.withMonomial(monoWholePart);

            Polynomial tempMultiplicationResult = divisor.multiply(new Polynomial().withMonomial(monoWholePart));

            reminder = reminder.subtract(tempMultiplicationResult);

            if (reminder.toString().equalsIgnoreCase("0"))
                break;
        }

        return new RationalPolynomial().withWholePart(wholePart)
                .withReminder(new PolynomialFraction()
                        .withNumerator(reminder)
                        .withDenominator(divisor.copy()));
    }

    public Polynomial pow(int degree){
        if (degree == 0)
            return ONE;

        Polynomial result = copy();
        for (int i = 1; i < degree; i ++){
            result = result.multiply(result);
        }

        return result;
    }

    public Polynomial mapWith(Polynomial randomPolynomial){
        Polynomial result = copy();

        ArrayList<Polynomial> tempPolynomials = result.getMonomialList().stream()
                .map(monomial -> randomPolynomial
                .pow(monomial.getDegree())
                .multiply(new Polynomial().withCoefficientAndDegree(monomial.getCoefficient(), 0))).collect(Collectors.toCollection(ArrayList::new));

        result = tempPolynomials.stream().reduce(Polynomial::add).get();

        return result;
    }

    public Polynomial negate(){
        Polynomial result = new Polynomial();
        monomialList.forEach(monomial ->
                result.withMonomial(monomial.negate()));
        return result;
    }

    public Polynomial copy(){
        Polynomial result = new Polynomial();
        monomialList.forEach(monomial ->
                result.withMonomial(monomial.copy()));
        return result;
    }

    private int getIndexOfMonomialWithDegree(int degree){
        for (int index = 0; index < monomialList.size(); index ++){
            if(monomialList.get(index).getDegree() == degree)
                return index;
        }
        return -1;
    }

    public static final Polynomial valueOf(String polynomialAsString){
        Polynomial result = new Polynomial();

        //todo можно регулярками вроде

        return result;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        monomialList.stream()
                .sorted((Monomial m1, Monomial m2) -> m2.getDegree().compareTo(m1.getDegree()))
                .forEach(monomial -> buildMultiplier(monomial, stringBuilder));
        return stringBuilder.toString();
    }

    private void buildMultiplier(Monomial monomial, StringBuilder builder) {
        if (monomial.getCoefficient() > 0 && !isMaxDegree(monomial.getDegree()))
            builder.append("+");

        builder.append(monomial.toString());
    }

    private boolean isMaxDegree(int degree){
        int currentMaxDegree = monomialList.stream()
                .max((Monomial m1, Monomial m2) ->
                        m1.getDegree().compareTo(m2.getDegree())).get()
                .getDegree();
        return degree == currentMaxDegree;
    }

    private Monomial monomialWithMaxDegree(){
        return monomialList.stream()
                .max((Monomial m1, Monomial m2) ->
                        m1.getDegree().compareTo(m2.getDegree()))
                .orElseThrow(() -> new IllegalStateException("Многочлен равен нулю"));
    }

    private Polynomial compact(){
        if (monomialList.size() > 1){
            ArrayList<Integer> indexesToBeRemovedFromList = new ArrayList<>();
            for (int index = 0; index < monomialList.size(); index ++){
                if(monomialList.get(index).getCoefficient() == 0)
                    indexesToBeRemovedFromList.add(index);
            }

            for(int index : indexesToBeRemovedFromList) {
                if (monomialList.size() > 1)
                    monomialList.remove(index);
            }
        }

        return this;
    }

    public List<Monomial> getMonomialList() {
        return monomialList;
    }
}
