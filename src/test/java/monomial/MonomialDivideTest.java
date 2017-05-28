package monomial;

import beans.Monomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 4/9/2017.
 */
public class MonomialDivideTest {
    @Test
    public void monomialDivideToOne() {
        assertThat(new Monomial().withCoefficient(BigInteger.valueOf(5)).withDegree(BigInteger.valueOf(2))
                        .divide(Monomial.ONE)
                        .toString(),
                equalTo("5x^2"));
    }

    @Test
    public void monomialDivideToNegativeOne() {
        assertThat(new Monomial().withCoefficient(BigInteger.valueOf(5)).withDegree(BigInteger.valueOf(2))
                        .divide(new Monomial().withCoefficient(BigInteger.ONE.negate()).withDegree(BigInteger.ZERO))
                        .toString(),
                equalTo("-5x^2"));
    }

    @Test(expected = ArithmeticException.class)
    public void monomialDivideToNull() {
        new Monomial().withCoefficient(BigInteger.valueOf(5)).withDegree(BigInteger.valueOf(2))
                        .divide(Monomial.ZERO);
    }
}
