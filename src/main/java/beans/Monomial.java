package beans;


/**
 * Created by zajic on 06.04.17.
 */
public class Monomial {
    public static final Monomial ONE = new Monomial().withCoefficient(1).withDegree(0);
    public static final Monomial ZERO = new Monomial();

    private int degree;
    private int coefficient;

    public Monomial(){
        degree = 0;
        coefficient = 0;
    }

    public Monomial add(Monomial term){
        Monomial result = new Monomial();

        int coefficientSum = coefficient + term.coefficient;
        if(coefficientSum == 0)
            result.withDegree(0);
        else
            result.withDegree(degree);

        return result.withCoefficient(coefficientSum);
    }

    public Monomial subtract(Monomial subtrahend){
        return add(subtrahend.negate());
    }

    public Monomial multiply(Monomial multiplier){
        return new Monomial()
                .withCoefficient(coefficient * multiplier.coefficient)
                .withDegree(degree + multiplier.degree);
    }

    public Monomial divide(Monomial divisor){
        return new Monomial()
                .withCoefficient(coefficient / divisor.coefficient)
                .withDegree(degree - divisor.degree);
    }

    public Monomial negate(){
        return new Monomial()
                .withCoefficient(-coefficient)
                .withDegree(degree);
    }

    public Monomial copy(){
        return new Monomial()
                .withCoefficient(coefficient)
                .withDegree(degree);
    }

    public Integer getDegree() {
        return degree;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public Monomial withDegree(int degree) {
        this.degree = degree;
        return this;
    }

    public Monomial withCoefficient(int coefficient) {
        this.coefficient = coefficient;
        return this;
    }

    @Override
    public String toString() {
        if (isCoefficientSpecial() || isDegreeSpecial())
            return handleSpecialCases();
        else
            return coefficient + "x^" + degree;
    }

    private boolean isDegreeSpecial(){
        return degree == 0 || degree == 1 ;
    }

    private boolean isCoefficientSpecial(){
        return coefficient == 0 || coefficient == 1 || coefficient == -1;
    }

    private String handleSpecialCases(){
        if (coefficient == 0)
            return "0";
        if (degree == 0)
            return "" + coefficient;

        if (coefficient == 1 && !isDegreeSpecial())
            return "x^" + degree;
        if (coefficient == -1 && !isDegreeSpecial())
            return "-x^" + degree;

        if (coefficient == 1 && degree == 1)
            return "x";
        if (coefficient == -1 && degree == 1)
            return "-x";

        if (degree == 1 && !isCoefficientSpecial())
            return coefficient + "x";

        throw new IllegalStateException("Не смогли перевести в строку одночлен, " +
                "коэф-т: " + coefficient + ", степень: " + degree);
    }

    public static final Monomial valueOf(String monomialAsString){
        Monomial result = new Monomial();



        return result;
    }
}
