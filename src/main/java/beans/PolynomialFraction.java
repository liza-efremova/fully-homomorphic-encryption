package beans;

import static utils.HomomorphicEncryptionUtils.polynomialNOK;

/**
 * Created by efreme on 07.04.17.
 */
public class PolynomialFraction {
    private Polynomial numerator;
    private Polynomial denominator;

    public PolynomialFraction() {
    }

    public PolynomialFraction withNumerator(Polynomial numerator) {
        this.numerator = numerator;
        return this;
    }

    public PolynomialFraction withDenominator(Polynomial denominator) {
        this.denominator = denominator;
        return this;
    }

    public PolynomialFraction add(PolynomialFraction term) {
        PolynomialFraction result = new PolynomialFraction();

        Polynomial nok = polynomialNOK(getDenominator(), term.getDenominator());

        Polynomial extraMultiplierForThisDenominator = nok.divide(getDenominator()).getWholePart();
        Polynomial extraMultiplierForTermDenominator = nok.divide(term.getDenominator()).getWholePart();

        Polynomial newNumeratorForThis = getNumerator().multiply(extraMultiplierForThisDenominator);
        Polynomial newNumeratorForTerm = term.getNumerator().multiply(extraMultiplierForTermDenominator);

        result.withNumerator(newNumeratorForThis.add(newNumeratorForTerm));
        result.withDenominator(nok);

        return result;
    }

    public PolynomialFraction subtract(PolynomialFraction subtrahend) {
        PolynomialFraction result = new PolynomialFraction();

        Polynomial nok = polynomialNOK(getDenominator(), subtrahend.getDenominator());

        Polynomial extraMultiplierForThisDenominator = nok.divide(getDenominator()).getWholePart();
        Polynomial extraMultiplierForTermDenominator = nok.divide(subtrahend.getDenominator()).getWholePart();

        Polynomial newNumeratorForThis = getNumerator().multiply(extraMultiplierForThisDenominator);
        Polynomial newNumeratorForTerm = subtrahend.getNumerator().multiply(extraMultiplierForTermDenominator);

        result.withNumerator(newNumeratorForThis.subtract(newNumeratorForTerm));
        result.withDenominator(nok);

        return result;
    }

    //todo выделение целой части

    /**
     * Перемножение дробей - перемножаем отдельно числители(Numerator) и знаменатели(Denominator).
     */
    public PolynomialFraction multiply(PolynomialFraction multiplier) {
        PolynomialFraction result = new PolynomialFraction();
        result.withNumerator(numerator.multiply(multiplier.getNumerator()));
        result.withDenominator(denominator.multiply(multiplier.getDenominator()));
        return result;
    }

    /**
     * Деление дробей - перемножаем крест на крест числитель(Numerator) и знаменатель(Denominator).
     */
    public PolynomialFraction divide(PolynomialFraction divisor) {
        PolynomialFraction result = new PolynomialFraction();
        result.withNumerator(numerator.multiply(divisor.getDenominator()));
        result.withDenominator(denominator.multiply(divisor.getNumerator()));
        return result;
    }

    /**
     * Получаем числитель дроби.
     */
    public Polynomial getNumerator() {
        return numerator;
    }

    /**
     * Получаем знаменатель дроби.
     */
    public Polynomial getDenominator() {
        return denominator;
    }

    @Override
    public String toString(){
        if(numerator.toString().equalsIgnoreCase("0"))
            return "";
        return "(" + numerator.toString() + "/" + denominator.toString() + ")";
    }
}
