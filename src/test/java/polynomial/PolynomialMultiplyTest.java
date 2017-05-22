package polynomial;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zajic on 05.04.17.
 */
public class PolynomialMultiplyTest {
    @Test
    public void polynomMultiplyWithOneElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .multiply(new Polynomial()
                                .withCoefficientAndDegree(5, 2))
                        .toString(),
                equalTo("25x^4"));
    }

    @Test
    public void polynomMultiplyWithTwoElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .withCoefficientAndDegree(3, 3)
                        .multiply(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("9x^6+30x^5+25x^4"));
    }

    @Test
    public void polynomMultiplyWithDifferentNumberOfElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .multiply(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("15x^5+25x^4"));
    }

    @Test
    public void polynomMultiplyWithEmptyTerm() {
        assertThat(new Polynomial().multiply(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void polynomMultiplyShouldNotChangeTerms() {
        Polynomial polynomial1 = new Polynomial()
                .withCoefficientAndDegree(5, 2);

        Polynomial polynomial2 = new Polynomial()
                .withCoefficientAndDegree(5, 2)
                .withCoefficientAndDegree(3, 3);

        assertThat(polynomial1.multiply(polynomial2).toString(),
                equalTo("15x^5+25x^4"));

        assertThat(polynomial1.toString(),
                equalTo("5x^2"));

        assertThat(polynomial2.toString(),
                equalTo("3x^3+5x^2"));
    }
}
