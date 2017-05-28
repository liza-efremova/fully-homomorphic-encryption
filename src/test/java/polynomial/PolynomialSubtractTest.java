package polynomial;

import beans.Polynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 04.04.17.
 */
public class PolynomialSubtractTest {
    @Test
    public void polynomSubtractionWithOneElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2))
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2)))
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void polynomSubtractionWithEqualElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO))
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void polynomSubtractionWithTwoElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(7), BigInteger.valueOf(3))
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2))
                                .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.valueOf(3)))
                        .toString(),
                equalTo("4x^3"));
    }

    @Test
    public void polynomSubtractionWithDifferentNumberOfElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(6), BigInteger.valueOf(2))
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2))
                                .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.valueOf(3)))
                        .toString(),
                equalTo("-3x^3+x^2"));
    }

    @Test
    public void polynomSubtractionWithEmptyTerm() {
        assertThat(new Polynomial().subtract(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.valueOf(3)))
                        .toString(),
                equalTo("-3x^3-5x^2"));
    }

    @Test
    public void polynomSubtractionShouldNotChangeTerms() {
        Polynomial polynomial1 = new Polynomial()
                .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2));

        Polynomial polynomial2 = new Polynomial()
                .withCoefficientAndDegree(BigInteger.valueOf(5), BigInteger.valueOf(2))
                .withCoefficientAndDegree(BigInteger.valueOf(3), BigInteger.valueOf(3));

        assertThat(polynomial1.subtract(polynomial2).toString(),
                equalTo("-3x^3"));

        assertThat(polynomial1.toString(),
                equalTo("5x^2"));

        assertThat(polynomial2.toString(),
                equalTo("3x^3+5x^2"));
    }
}
