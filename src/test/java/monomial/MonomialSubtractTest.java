package monomial;

import beans.Monomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 4/9/2017.
 */
public class MonomialSubtractTest {
    @Test
    public void monomialSubtractSameElement() {
        assertThat(Monomial.ONE
                        .subtract(Monomial.ONE)
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void monomialSubtractSameElement2() {
        assertThat(new Monomial().withCoefficient(BigInteger.ONE).withDegree(BigInteger.ZERO)
                        .subtract(new Monomial().withCoefficient(BigInteger.ZERO).withDegree(BigInteger.ZERO))
                        .toString(),
                equalTo("1"));
    }
}
