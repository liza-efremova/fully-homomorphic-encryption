package utils;

import beans.Polynomial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static utils.HomomorphicEncryptionUtils.polynomialNOD;
import static utils.HomomorphicEncryptionUtils.polynomialNOK;

/**
 * Created by efreme on 5/12/2017.
 */
public class polynomialNOKandNOD {
    @Test
    public void getNOKtest1 (){
        assertThat(polynomialNOK(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.ONE)
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO), new Polynomial()
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                                .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)).toString(),
                equalTo("x+1"));
    }
    @Test
    public void getNODtest1 (){
        assertThat(polynomialNOD(new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.valueOf(2))
                        .withCoefficientAndDegree(BigInteger.valueOf(2), BigInteger.ONE)
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO), new Polynomial()
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ONE)
                        .withCoefficientAndDegree(BigInteger.ONE, BigInteger.ZERO)).toString(),
                equalTo("x^2+2x+1"));
    }
}
