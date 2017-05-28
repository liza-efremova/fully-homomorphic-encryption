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
