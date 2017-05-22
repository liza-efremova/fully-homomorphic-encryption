package polynomial;

import beans.Polynomial;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by zajic on 09.04.17.
 */
public class PolinomialPowTest {
    @Test
    public void polynomPowWithTwoElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 2)
                        .withCoefficientAndDegree(1, 0)
                        .pow(2)
                        .toString(),
                equalTo("x^4+2x^2+1"));
    }

    @Test
    public void polynomPowWithZeroDegreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 1)
                        .withCoefficientAndDegree(1, 0)
                        .pow(0)
                        .toString(),
                equalTo("1"));
    }

    @Test
    public void polynomONEPowWithSevenDegreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(1, 0)
                        .pow(7)
                        .toString(),
                equalTo("1"));
    }

//Хихик :D
  //  @Test
  //  public void polynomNULLPowWithZERODegreeElement() {
  //      assertThat(new Polynomial()
  //                      .withCoefficientAndDegree(0, 0)
  //                      .pow(0)
  //                      .toString(),
  //              equalTo("0"));
  //  }

    @Test
    public void polynomNULLPowWithNonZeroDegreeElement() {
        assertThat(new Polynomial()
                        .withCoefficientAndDegree(0, 1)
                        .withCoefficientAndDegree(0, 0)
                        .pow(3)
                        .toString(),
                equalTo("0"));
    }
}
