package interpolation;

/**
 *  Abstract Class InterpolatingPolynomial
 *
 *  This class represents an interpolating polynomial, and is extended to concrete classes
 *      LagrangePolynomial, which represents standard Lagrange interpolating polynomials
 *      NewtonPolynomial, which represents interpolating polynomials using Newton's divided difference method.
 *
 *  Contains double[][] array 'nodes' which holds the data to interpolate, with x[] = nodes[0] and y[] = nodes[1].
 *  Contains double[] coefficients, which is the same size as nodes[0] and holds the coefficients for each term of the polynomial.
 *
 *  uniformNodes() automatically populates nodes[0] with x-values that are evenly spaced, and
 *  chebyshevNodes() automatically populates nodes[0] with x-values as optimal Chebyshev nodes.
 *  computeCoefficients() populates coefficients[] array based on values in nodes[].
 *  evaluate() evaluates the interpolating polynomial for a given value of x.
 *
 *  @author Aaron Anderson
 *          9/19/18
 */
public abstract class InterpolatingPolynomial {
    /**
     * Holds the data points for this class, with
     * nodes[0] = x-values, and nodes[1] = y-values.
     */
    public double[][] nodes;
    /**
     * Holds the coefficients for the interpolating polynomial.
     */
    public double[] coefficients;

    /**
     * Automatically populates nodes[0] (x-values) with evenly spaced nodes at (origin + i*distance).
     * @param origin    Starting position.
     * @param distance  Distance between nodes.
     */
    public void uniformNodes(double origin, double distance) {
        for (int i = 0; i < nodes[0].length; i++)
            nodes[0][i] = origin + i*distance;
    }

    /**
     * Automatically populates nodes[0] (x-values) with optimally-spaced Chebyshev nodes.
     */
    public void chebyshevNodes() {
        for (int i = 0; i < nodes[0].length; i++)
            nodes[0][i] = Math.cos( (double) (2*i + 1) / (2*(nodes[0].length)) * Math.PI);
    }
    /**
     * Populates coefficients[] array with values based on nodes[] array.
     */
    public abstract void computeCoefficients();
    /**
     * Evaluates interpolating polynomial at given x.
     * @param x value of x.
     */
    public abstract double evaluate(double x);
}
