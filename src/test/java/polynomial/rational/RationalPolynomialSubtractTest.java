package polynomial.rational;

import beans.Polynomial;
import beans.PolynomialFraction;
import beans.RationalPolynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by efreme on 5/28/2017.
 */
public class RationalPolynomialSubtractTest {

    @Test
    public void subtract() {

        //2 + ((-2x+3)/(x^3+x))
        RationalPolynomial polynomial1 = new RationalPolynomial()
                .withWholePart(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.ZERO))
                .withReminder(new PolynomialFraction()
                        .withNumerator(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.valueOf(2).negate(), BigInteger.ONE)
                                .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.ZERO))
                        .withDenominator(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(3))
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)));

        RationalPolynomial polynomial2 = new RationalPolynomial()
                .withWholePart(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(1), BigInteger.ZERO))
                .withReminder(new PolynomialFraction()
                        .withNumerator(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.valueOf(2).negate(), BigInteger.ONE)
                                .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.ZERO))
                        .withDenominator(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(3))
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)));

        assertThat(polynomial1.subtract(polynomial2).toString(), equalTo("1"));
    }
}
