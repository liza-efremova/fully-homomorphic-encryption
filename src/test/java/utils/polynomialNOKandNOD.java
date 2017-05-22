package utils;

import beans.Polynomial;
import org.junit.Test;

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
                        .withCoefficientAndDegree(1,2)
                        .withCoefficientAndDegree(2,1)
                        .withCoefficientAndDegree(1,0), new Polynomial()
                                .withCoefficientAndDegree(1,1)
                                .withCoefficientAndDegree(1,0)).toString(),
                equalTo("x+1"));
    }
    @Test
    public void getNODtest1 (){
        assertThat(polynomialNOD(new Polynomial()
                        .withCoefficientAndDegree(1,2)
                        .withCoefficientAndDegree(2,1)
                        .withCoefficientAndDegree(1,0), new Polynomial()
                        .withCoefficientAndDegree(1,1)
                        .withCoefficientAndDegree(1,0)).toString(),
                equalTo("x^2+2x+1"));
    }
}
