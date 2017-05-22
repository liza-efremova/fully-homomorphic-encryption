package polynom;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zajic on 04.04.17.
 */
public class PolynomialSubtractTest {
    @Test
    public void polynomSubtractionWithOneElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(5, 2))
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void polynomSubtractionWithEqualElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 0)
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(1, 0))
                        .toString(),
                equalTo("0"));
    }

    @Test
    public void polynomSubtractionWithTwoElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .withCoefficientAndDegree(7, 3)
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("4x^3"));
    }

    @Test
    public void polynomSubtractionWithDifferentNumberOfElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(6, 2)
                        .subtract(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("-3x^3+x^2"));
    }

    @Test
    public void polynomSubtractionWithEmptyTerm() {
        assertThat(new Polynomial().subtract(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("-3x^3-5x^2"));
    }

    @Test
    public void polynomSubtractionShouldNotChangeTerms() {
        Polynomial polynomial1 = new Polynomial()
                .withCoefficientAndDegree(5, 2);

        Polynomial polynomial2 = new Polynomial()
                .withCoefficientAndDegree(5, 2)
                .withCoefficientAndDegree(3, 3);

        assertThat(polynomial1.subtract(polynomial2).toString(),
                equalTo("-3x^3"));

        assertThat(polynomial1.toString(),
                equalTo("5x^2"));

        assertThat(polynomial2.toString(),
                equalTo("3x^3+5x^2"));
    }
}
