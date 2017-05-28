package polynomial;

import beans.Polynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 09.04.17.
 */
public class PolynomialMapWithTest {
    @Test
    public void polynomMapWithTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO))
                        .toString(),
                equalTo("x^2+2x+2"));
    }

    @Test
    public void polynomMapWithTest2() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE))
                        .toString(),
                equalTo("x^2+1"));
    }

    @Test
    public void polynomMapWithTest3() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE))
                        .toString(),
                equalTo("x^4+2x^3+2x^2+x"));
    }

    @Test
    public void polynomMapWithTest4() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO))
                        .toString(),
                equalTo("2"));
    }

    @Test
    public void polynomMapWithTest5() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ZERO, BigInteger.ZERO))
                        .toString(),
                equalTo("1"));
    }
}
