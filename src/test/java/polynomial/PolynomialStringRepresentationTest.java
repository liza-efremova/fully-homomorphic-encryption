package polynomial;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zajic on 03.04.17.
 */
public class PolynomialStringRepresentationTest {
    @Test
    public void stringRepresentationAllNegativeBaseTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(-3, 2)
                        .withCoefficientAndDegree(-2, 3)
                        .toString(),
                equalTo("-2x^3-3x^2"));
    }

    @Test
    public void stringRepresentationAllPositiveBaseTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(3, 2)
                        .withCoefficientAndDegree(2, 3)
                        .toString(),
                equalTo("2x^3+3x^2"));
    }

    @Test
    public void stringRepresentationWithOneTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(-1, 2)
                        .withCoefficientAndDegree(-2, 3)
                        .toString(),
                equalTo("-2x^3-x^2"));
    }

    @Test
    public void stringRepresentationWithZeroTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(0, 2)
                        .withCoefficientAndDegree(-2, 3)
                        .toString(),
                equalTo("-2x^3"));
    }
}
