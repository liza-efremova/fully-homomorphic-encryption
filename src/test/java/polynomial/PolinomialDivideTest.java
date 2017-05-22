package polynomial;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by efreme on 4/9/2017.
 */
public class PolinomialDivideTest {
    @Test
    public void polynomDivideWithTwoElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2).withCoefficientAndDegree(-1, 0)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(1, 1).withCoefficientAndDegree(-1, 0))
                        .toString(),
                equalTo("x+1"));
    }

    @Test
    public void polynomDivideWithThreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 3).withCoefficientAndDegree(-1, 0)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(1, 1).withCoefficientAndDegree(-1, 0))
                        .toString(),
                equalTo("x^2+x+1"));
    }

    @Test
    public void polynomDivideSameElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2).withCoefficientAndDegree(-1, 0)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(1, 2).withCoefficientAndDegree(-1, 0))
                        .toString(),
                equalTo("1"));
    }

    @Test (expected = ArithmeticException.class)
    public void polynomDivideToNull() {
        new Polynomial()
                        .withCoefficientAndDegree(1, 2).withCoefficientAndDegree(-1, 0)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(0, 0));
    }

    @Test
    public void polynomDivideToONE() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 1).withCoefficientAndDegree(1, 0)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(1, 0))
                        .toString(),
                equalTo("x+1"));
    }

    @Test
    public void polynomDivideToEqualElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2).withCoefficientAndDegree(-1, 0)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(1, 2).withCoefficientAndDegree(-1, 0))
                        .toString(),
                equalTo("1"));
    }

    @Test
    public void polynomDivideWithTwoElement2() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(2, 4).withCoefficientAndDegree(-2, 2)
                        .divide(new Polynomial()
                                .withCoefficientAndDegree(2, 3).withCoefficientAndDegree(2, 2))
                        .toString(),
                equalTo("x-1"));
    }
}
