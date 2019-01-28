package interpolation;

/**
 *  Class LagrangePolynomial, extends InterpolatingPolynomial
 *
 *  Represents a Lagrange interpolating polynomial.
 *
 * @author Aaron Anderson
 *         9/19/18
 */
public class LagrangePolynomial extends InterpolatingPolynomial {

    /**
     * Constructor for LagrangePolynomial given the number of nodes.
     * @param n number of nodes
     */
    public LagrangePolynomial(int n) {
        this.nodes = new double[2][n];
        this.coefficients = new double[n];
    }

    /**
     * Constructor for LagrangePolynomial given the nodes as an array.
     * @param nodes array for nodes
     */
    public LagrangePolynomial(double[][] nodes) {
        this.nodes = nodes;
    }

    /**
     * Populates the coefficients[] array, with the
     * nth coefficient = y_n / PRODUCT(x_n - x_j) for j != n.
     */
    public void computeCoefficients() {
        for(int i = 0; i < coefficients.length; i++) {
            double d = 1;
            for(int j = 0; j < nodes[0].length; j++) {
                if(i != j)
                    d *= nodes[0][i] - nodes[0][j];
            }
            coefficients[i] = nodes[1][i] / d;
        }
    }

    /**
     * Evaluates the interpolating polynomial at a given x.
     * @param x value of x.
     * @return P(x)
     */
    public double evaluate(double x) {
        double result = 0;
        for(int i = 0; i < nodes[0].length; i++) {
            double term = 1;
            for(int j = 0; j < nodes[0].length; i++) {
                if(i != j)
                    term *= x - nodes[0][j];
            }
            result += term * coefficients[i];
        }
        return result;
    }
}
