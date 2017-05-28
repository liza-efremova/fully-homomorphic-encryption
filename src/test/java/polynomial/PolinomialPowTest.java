package polynomial;

import beans.Polynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 09.04.17.
 */
public class PolinomialPowTest {
    @Test
    public void polynomPowWithTwoElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .pow(BigInteger.valueOf(2))
                        .toString(),
                equalTo("x^4+2x^2+1"));
    }

    @Test
    public void polynomPowWithZeroDegreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .pow(BigInteger.ZERO)
                        .toString(),
                equalTo("1"));
    }

    @Test
    public void polynomONEPowWithSevenDegreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)
                        .pow(BigInteger.valueOf(7))
                        .toString(),
                equalTo("1"));
    }

    @Test
    public void polynomNULLPowWithNonZeroDegreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ZERO, BigInteger.ONE)
                        .withCoefficientAndDegree(BigInteger.ZERO, BigInteger.ZERO)
                        .pow(BigInteger.valueOf(3))
                        .toString(),
                equalTo("0"));
    }
}
