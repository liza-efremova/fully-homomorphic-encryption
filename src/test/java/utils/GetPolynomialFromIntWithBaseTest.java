package utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static utils.HomomorphicEncryptionUtils.getPolynomialFromIntWithBase;

/**
 * Created by zajic on 09.04.17.
 */
public class GetPolynomialFromIntWithBaseTest {

    @Test
    public void getPolynomialFromIntWith9BaseTest(){
        assertThat(getPolynomialFromIntWithBase(10, 9).toString(),
                equalTo("x+1"));
    }

    @Test
    public void getPolynomialFromIntWith2BaseTest(){
        assertThat(getPolynomialFromIntWithBase(10, 2).toString(),
                equalTo("x^3+x"));
    }

    @Test
    public void getPolynomialFromIntWith7BaseTest(){
        assertThat(getPolynomialFromIntWithBase(21, 7).toString(),
                equalTo("3x"));
    }

    @Test
    public void getPolynomialFromIntWith6BaseTest(){
        assertThat(getPolynomialFromIntWithBase(51, 6).toString(),
                equalTo("x^2+2x+3"));
    }


    @Test
    public void getPolynomialFromIntWith2StressTest(){
        assertThat(getPolynomialFromIntWithBase(2014, 2).toString(),
                equalTo("x^10+x^9+x^8+x^7+x^6+x^4+x^3+x^2+x"));
    }


    @Test
    public void getPolynomialFromIntWith9StressTest(){
        assertThat(getPolynomialFromIntWithBase(5000, 9).toString(),
                equalTo("6x^3+7x^2+6x+5"));
    }


    @Test
    public void getPolynomialFromIntWith10BaseTest(){
        assertThat(getPolynomialFromIntWithBase(201, 10).toString(),
                equalTo("2x^2+1"));
    }


    @Test
    public void getPolynomialFromIntWith7NullTest(){
        assertThat(getPolynomialFromIntWithBase(0, 7).toString(),
                equalTo("0"));
    }

}
