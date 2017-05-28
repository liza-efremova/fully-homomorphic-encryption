package beans;

/**
 * Created by efreme on 06.04.17.
 * Класс для представления рационального полинома.
 * Состоит из целой части и остатка.
 * Создавать так : new RationalPolynomial().withWholePart(Polynomial.ZERO).withReminder(Polynomial.ONE)
 */
public class RationalPolynomial {
    private PolynomialFraction reminder;
    private Polynomial wholePart;

    public RationalPolynomial(){
    }

    /**
     * инициализируем остаток
     */
    public RationalPolynomial withReminder(PolynomialFraction reminder){
        this.reminder = reminder;
        return this;
    }

    /**
     * инициализируем целую часть
     */
    public RationalPolynomial withWholePart(Polynomial wholePart){
        this.wholePart = wholePart;
        return this;
    }

    public RationalPolynomial add(RationalPolynomial term) {
        PolynomialFraction currentFractionWithWholePart = new PolynomialFraction()
                .withNumerator(getWholePart()
                        .multiply(getReminder().getDenominator())
                        .add(getReminder().getNumerator()))
                .withDenominator(getReminder().getDenominator());

        PolynomialFraction termFractionWithWholePart = new PolynomialFraction()
                .withNumerator(term.getWholePart()
                        .multiply(term.getReminder().getDenominator())
                        .add(term.getReminder().getNumerator()))
                .withDenominator(term.getReminder().getDenominator());

        PolynomialFraction resultedFraction = currentFractionWithWholePart.add(termFractionWithWholePart);

        return resultedFraction.getNumerator().divide(resultedFraction.getDenominator());
    }

    public RationalPolynomial subtract(RationalPolynomial subtrahend) {
        PolynomialFraction currentFractionWithWholePart = new PolynomialFraction()
                .withNumerator(getWholePart()
                        .multiply(getReminder().getDenominator())
                        .add(getReminder().getNumerator()))
                .withDenominator(getReminder().getDenominator());

        PolynomialFraction subtrahendFractionWithWholePart = new PolynomialFraction()
                .withNumerator(subtrahend.getWholePart()
                        .multiply(subtrahend.getReminder().getDenominator())
                        .add(subtrahend.getReminder().getNumerator()))
                .withDenominator(subtrahend.getReminder().getDenominator());

        PolynomialFraction resultedFraction = currentFractionWithWholePart.subtract(subtrahendFractionWithWholePart);

        return resultedFraction.getNumerator().divide(resultedFraction.getDenominator());
    }

    public RationalPolynomial multiply(RationalPolynomial multiplier) {
        PolynomialFraction currentFractionWithWholePart = new PolynomialFraction()
                .withNumerator(getWholePart()
                        .multiply(getReminder().getDenominator())
                        .add(getReminder().getNumerator()))
                .withDenominator(getReminder().getDenominator());

        PolynomialFraction multiplierFractionWithWholePart = new PolynomialFraction()
                .withNumerator(multiplier.getWholePart()
                        .multiply(multiplier.getReminder().getDenominator())
                        .add(multiplier.getReminder().getNumerator()))
                .withDenominator(multiplier.getReminder().getDenominator());

        PolynomialFraction resultedFraction = currentFractionWithWholePart.multiply(multiplierFractionWithWholePart);

        return resultedFraction.getNumerator().divide(resultedFraction.getDenominator());
    }

    public RationalPolynomial divide(RationalPolynomial divisor) {
        PolynomialFraction currentFractionWithWholePart = new PolynomialFraction()
                .withNumerator(getWholePart()
                        .multiply(getReminder().getDenominator())
                        .add(getReminder().getNumerator()))
                .withDenominator(getReminder().getDenominator());

        PolynomialFraction divisorFractionWithWholePart = new PolynomialFraction()
                .withNumerator(divisor.getWholePart()
                        .multiply(divisor.getReminder().getDenominator())
                        .add(divisor.getReminder().getNumerator()))
                .withDenominator(divisor.getReminder().getDenominator());

        PolynomialFraction resultedFraction = currentFractionWithWholePart.divide(divisorFractionWithWholePart);

        return resultedFraction.getNumerator().divide(resultedFraction.getDenominator());
    }

    public PolynomialFraction getReminder() {
        return reminder;
    }

    public Polynomial getWholePart() {
        return wholePart;
    }

    @Override
    public String toString(){
        if (reminder.toString().equalsIgnoreCase(""))
            return wholePart.toString();
        else
            return wholePart + " + " + reminder.toString();
    }
}
