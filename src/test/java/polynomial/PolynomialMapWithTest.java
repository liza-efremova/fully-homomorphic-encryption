package polynomial;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zajic on 09.04.17.
 */
public class PolynomialMapWithTest {
    @Test
    public void polynomMapWithTest() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2)
                        .withCoefficientAndDegree(1, 0)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(1, 1)
                                .withCoefficientAndDegree(1, 0))
                        .toString(),
                equalTo("x^2+2x+2"));
    }

    @Test
    public void polynomMapWithTest2() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2)
                        .withCoefficientAndDegree(1, 0)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(1, 1))
                        .toString(),
                equalTo("x^2+1"));
    }

    @Test
    public void polynomMapWithTest3() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2)
                        .withCoefficientAndDegree(1, 1)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(1, 2)
                                .withCoefficientAndDegree(1, 1))
                        .toString(),
                equalTo("x^4+2x^3+2x^2+x"));
    }

    @Test
    public void polynomMapWithTest4() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2)
                        .withCoefficientAndDegree(1, 0)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(1, 0))
                        .toString(),
                equalTo("2"));
    }

    @Test
    public void polynomMapWithTest5() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2)
                        .withCoefficientAndDegree(1, 0)
                        .mapWith(new Polynomial()
                                .withCoefficientAndDegree(0, 0))
                        .toString(),
                equalTo("1"));
    }
}
