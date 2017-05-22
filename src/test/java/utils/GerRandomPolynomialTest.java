package utils;

import org.junit.Test;

import static utils.HomomorphicEncryptionUtils.getRandomPolynomial;

/**
 * Created by efreme on 5/9/2017.
 */
public class GerRandomPolynomialTest {
    @Test
    public void getRandomPolinomTestOne(){
       System.out.println(getRandomPolynomial(18, 6).toString());
    }
}
