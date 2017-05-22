package beans;

/**
 * Created by efreme on 5/14/2017.
 */
public class SecretKey {
    private Polynomial mappingPolynomial;
    private int a;
    private int b;

    public Polynomial getMappingPolynomial() {
        return mappingPolynomial;
    }

    public void setMappingPolynomial(Polynomial mappingPolynomial) {
        this.mappingPolynomial = mappingPolynomial;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
