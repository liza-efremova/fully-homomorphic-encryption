package polynomial;

import beans.Polynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 03.04.17.
 */
public class PolynomialStringRepresentationTest {
    @Test
    public void stringRepresentationAllNegativeBaseTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(3).negate(), BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(2).negate(), BigInteger.valueOf(3))
                        .toString(),
                equalTo("-2x^3-3x^2"));
    }

    @Test
    public void stringRepresentationAllPositiveBaseTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.valueOf(3))
                        .toString(),
                equalTo("2x^3+3x^2"));
    }

    @Test
    public void stringRepresentationWithOneTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(2).negate(), BigInteger.valueOf(3))
                        .toString(),
                equalTo("-2x^3-x^2"));
    }

    @Test
    public void stringRepresentationWithZeroTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ZERO, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(2).negate(), BigInteger.valueOf(3))
                        .toString(),
                equalTo("-2x^3"));
    }
}
