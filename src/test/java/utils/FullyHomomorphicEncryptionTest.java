package utils;

import beans.Polynomial;
import beans.SecretKey;
import org.junit.Test;

import static utils.HomomorphicEncryptionUtils.*;

/**
 * Created by efreme on 5/14/2017.
 */
public class FullyHomomorphicEncryptionTest {
    @Test
    public void fullyHomomorphicEncryptionAddTest() {
        int opendata1 = 11111;
        int opendata2 = 22222;

        int base = getRandomBase(opendata1, opendata2);
        SecretKey key = getRandomPolynomial(6, base);

        Polynomial polynomFromOpenData1 = getPolynomialFromIntWithBase(opendata1, base);
        Polynomial encodedOpenData1 = polynomFromOpenData1.mapWith(key.getMappingPolynomial());

        Polynomial polynomFromOpenData2 = getPolynomialFromIntWithBase(opendata2, base);
        Polynomial encodedOpenData2 = polynomFromOpenData2.mapWith(key.getMappingPolynomial());

        encodedOpenData1.add(encodedOpenData2);
    }

    @Test
    public void fullyHomomorphicEncryptionMultiplyTest() {
        int opendata1 = 11111;
        int opendata2 = 22222;

        int base = getRandomBase(opendata1, opendata2);
        SecretKey key = getRandomPolynomial(16, base);

        Polynomial polynomFromOpenData1 = getPolynomialFromIntWithBase(opendata1, base);
        Polynomial encodedOpenData1 = polynomFromOpenData1.mapWith(key.getMappingPolynomial());

        Polynomial polynomFromOpenData2 = getPolynomialFromIntWithBase(opendata2, base);
        Polynomial encodedOpenData2 = polynomFromOpenData2.mapWith(key.getMappingPolynomial());

        encodedOpenData1.multiply(encodedOpenData2);
    }
}
