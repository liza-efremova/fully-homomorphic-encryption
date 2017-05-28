package beans;


import java.math.BigInteger;

/**
 * Created by efreme on 06.04.17.
 */
public class Monomial {
    public static final Monomial ONE = new Monomial()
            .withCoefficient(BigInteger.ONE)
            .withDegree(BigInteger.ZERO);

    public static final Monomial ZERO = new Monomial();

    private BigInteger degree;
    private BigInteger coefficient;

    public Monomial(){
        degree = BigInteger.ZERO;
        coefficient = BigInteger.ZERO;
    }

    public Monomial add(Monomial term){
        Monomial result = new Monomial();

        BigInteger coefficientSum = coefficient.add(term.coefficient);
        if(coefficientSum.compareTo(BigInteger.ZERO) == 0)
            result.withDegree(BigInteger.ZERO);
        else
            result.withDegree(degree);

        return result.withCoefficient(coefficientSum);
    }

    public Monomial subtract(Monomial subtrahend){
        return add(subtrahend.negate());
    }

    public Monomial multiply(Monomial multiplier){
        return new Monomial()
                .withCoefficient(coefficient.multiply(multiplier.coefficient))
                .withDegree(degree.add(multiplier.degree));
    }

    public Monomial divide(Monomial divisor){
        return new Monomial()
                .withCoefficient(coefficient.divide(divisor.coefficient))
                .withDegree(degree.subtract(divisor.degree));
    }

    public Monomial negate(){
        return new Monomial()
                .withCoefficient(coefficient.negate())
                .withDegree(degree);
    }

    public Monomial copy(){
        return new Monomial()
                .withCoefficient(coefficient)
                .withDegree(degree);
    }

    public BigInteger getDegree() {
        return degree;
    }

    public BigInteger getCoefficient() {
        return coefficient;
    }

    public Monomial withDegree(BigInteger degree) {
        this.degree = degree;
        return this;
    }

    public Monomial withCoefficient(BigInteger coefficient) {
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
        return degree.compareTo(BigInteger.ZERO) == 0 || degree.compareTo(BigInteger.ONE) == 0 ;
    }

    private boolean isCoefficientSpecial(){
        return coefficient.compareTo(BigInteger.ZERO) == 0 ||
                coefficient.compareTo(BigInteger.ONE) == 0 ||
                coefficient.compareTo(BigInteger.ONE.negate()) == 0;
    }

    private String handleSpecialCases(){
        if (coefficient.compareTo(BigInteger.ZERO) == 0)
            return "0";
        if (degree.compareTo(BigInteger.ZERO) == 0)
            return "" + coefficient;

        if (coefficient.compareTo(BigInteger.ONE) == 0 && !isDegreeSpecial())
            return "x^" + degree;
        if (coefficient.compareTo(BigInteger.ONE.negate()) == 0 && !isDegreeSpecial())
            return "-x^" + degree;

        if (coefficient.compareTo(BigInteger.ONE) == 0 && degree.compareTo(BigInteger.ONE) == 0)
            return "x";
        if (coefficient.compareTo(BigInteger.ONE.negate()) == 0 && degree.compareTo(BigInteger.ONE.negate()) == 0)
            return "-x";

        if (degree.compareTo(BigInteger.ONE) == 0 && !isCoefficientSpecial())
            return coefficient + "x";

        throw new IllegalStateException("Не смогли перевести в строку одночлен, " +
                "коэф-т: " + coefficient + ", степень: " + degree);
    }

    public static final Monomial valueOf(String monomialAsString){
        Monomial result = new Monomial();
        //todo
        return result;
    }
}
