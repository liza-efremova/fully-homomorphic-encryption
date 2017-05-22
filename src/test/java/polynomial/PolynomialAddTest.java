package polynomial;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zajic on 04.04.17.
 */
public class PolynomialAddTest {
    @Test
    public void polynomAdditionWithOneElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .add(new Polynomial()
                                .withCoefficientAndDegree(5, 2))
                        .toString(),
                equalTo("10x^2"));
    }

    @Test
    public void polynomAdditionWithTwoElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .withCoefficientAndDegree(3, 3)
                        .add(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("6x^3+10x^2"));
    }

    @Test
    public void polynomAdditionWithDifferentNumberOfElements() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(5, 2)
                        .add(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("3x^3+10x^2"));
    }

    @Test
    public void polynomAdditionWithEmptyTerm() {
        assertThat(new Polynomial().add(new Polynomial()
                                .withCoefficientAndDegree(5, 2)
                                .withCoefficientAndDegree(3, 3))
                        .toString(),
                equalTo("3x^3+5x^2"));
    }

    @Test
    public void polynomAdditionShouldNotChangeTerms() {
        Polynomial polynomial1 = new Polynomial()
                .withCoefficientAndDegree(5, 2);

        Polynomial polynomial2 = new Polynomial()
                .withCoefficientAndDegree(5, 2)
                .withCoefficientAndDegree(3, 3);

        assertThat(polynomial1.add(polynomial2).toString(),
                equalTo("3x^3+10x^2"));

        assertThat(polynomial1.toString(),
                equalTo("5x^2"));

        assertThat(polynomial2.toString(),
                equalTo("3x^3+5x^2"));
    }
}
