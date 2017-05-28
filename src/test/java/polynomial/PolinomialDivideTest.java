package polynomial;

import beans.Polynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 4/9/2017.
 */
public class PolinomialDivideTest {
    @Test
    public void polynomDivideWithTwoElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                                .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO))
                        .toString(),
                equalTo("x+1"));
    }

    @Test
    public void polynomDivideWithThreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(3))
                        .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                                .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO))
                        .toString(),
                equalTo("x^2+x+1"));
    }

    @Test
    public void polynomDivideSameElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                                .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO))
                        .toString(),
                equalTo("1"));
    }

    @Test (expected = ArithmeticException.class)
    public void polynomDivideToNull() {
        new Polynomial()
                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ZERO, BigInteger.ZERO));
    }

    @Test
    public void polynomDivideToONE() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO))
                        .toString(),
                equalTo("x+1"));
    }

    @Test
    public void polynomDivideToEqualElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                                .withCoefficientAndDegree(BigInteger.ONE.negate(), BigInteger.ZERO))
                        .toString(),
                equalTo("1"));
    }

    @Test
    public void polynomDivideWithTwoElement2() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.valueOf(4))
                        .withCoefficientAndDegree(BigInteger.valueOf(2).negate(), BigInteger.valueOf(2))
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.valueOf(3))
                                .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.valueOf(2)))
                        .toString(),
                equalTo("x-1"));
    }
}
