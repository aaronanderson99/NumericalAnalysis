package interpolation;

/**
 *  Class NewtonPolynomial, extends InterpolatingPolynomial
 *
 *  Represents a interpolating polynomial based on Newton's divided difference method.
 *
 * @author Aaron Anderson
 *         9/19/18
 */
public class NewtonPolynomial extends InterpolatingPolynomial {

    /**
     * Constructor for NewtonPolynomial given the number of nodes.
     * @param n number of nodes
     */
    public NewtonPolynomial(int n) {
        this.nodes = new double[2][n];
        this.coefficients = new double[n];
    }

    /**
     * Constructor for NewtonPolynomial given the nodes as an array.
     * @param nodes array for nodes
     */
    public NewtonPolynomial(double[][] nodes) {
        this.nodes = nodes;
    }

    /**
     * Helper method for dividedDifference().
     * Takes an array and returns a new array with elements arr[from] to arr[from + size].
     * @param arr   original array.
     * @param from  starting index.
     * @param size  Number of elements.
     * @return  Sub-array of original containing arr[from] to arr[from + size]
     */
    public static double[] partialArray(double[] arr, int from, int size) {
        double[] newArr = new double[size];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[from + i];
        }
        return newArr;
    }

    /**
     * Returns the divided difference from a set of x[] and a set of fx[].
     *      f[x_0...x_n] = (f[x_1...x_n] - f[x_0...x_(n-1)]) / (x_n - x_0)
     * Uses recursion to return lower-order divided differences.
     * @param x     set of x-values
     * @param fx    set of y-values
     * @return  Divided difference from set. 0th order divided differences are the value of the function at that point.
     */
    public double dividedDifference(double[] x, double[] fx) {
        if (fx.length == 1) {
            return fx[0];
        }
        else {
            return (  dividedDifference(partialArray(x, 1, fx.length - 1), partialArray(fx, 1, x.length - 1))
                    - dividedDifference(partialArray(x, 0, fx.length - 1), partialArray(fx, 0, x.length - 1))  )
                    / (  x[x.length - 1] - x[0] );
        }
    }

    /**
     * Populates the coefficients[] array, with the nth coefficient = nth divided difference = f[x_0...x_n].
     */
    public void computeCoefficients() {
        for (int i = 0; i < coefficients.length; i++)
            coefficients[i] = dividedDifference(partialArray(nodes[0], 0, i + 1), partialArray(nodes[1], 0, i + 1));
    }

    /**
     * Evaluates the interpolating polynomial at a given x.
     * @param x value of x.
     * @return P(x)
     */
    public double evaluate(double x) {
        double[] terms = new double[nodes[0].length - 1];
        terms[0] = (x - nodes[0][0]);
        for (int i = 1; i < terms.length; i++)
            terms[i] = (x - nodes[0][i]) * terms[i - 1];

        double sum = coefficients[0];
        for(int i = 0; i < terms.length; i++)
            sum += coefficients[i + 1] * terms[i];

        return sum;
    }
}
