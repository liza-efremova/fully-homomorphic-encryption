package monomial;

import beans.Monomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 4/9/2017.
 */
public class MonomialAddTest {
    @Test
    public void monomialAddSameNullElement() {
        assertThat(Monomial.ZERO
                        .add(Monomial.ZERO)
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void monomialAddSameOneElement() {
        assertThat(Monomial.ONE
                        .add(Monomial.ONE)
                        .toString(),
                equalTo("2"));
    }

    @Test
    public void monomialAddSameElement() {
        assertThat(new Monomial().withCoefficient(BigInteger.ONE.negate()).withDegree(BigInteger.ONE)
                        .add(new Monomial().withCoefficient(BigInteger.ONE).withDegree(BigInteger.ONE))
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void monomialAddSameElement2() {
        assertThat(new Monomial().withCoefficient(BigInteger.ONE.negate()).withDegree(BigInteger.ZERO)
                        .add(new Monomial().withCoefficient(BigInteger.ONE).withDegree(BigInteger.ZERO))
                        .toString(),
                equalTo("0"));
    }
}
