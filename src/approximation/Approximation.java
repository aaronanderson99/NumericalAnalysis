package approximation;

import function.Function;

/**
 *  Class Approximation:
 *  This class contains methods that implement bisection and Newton's method for root approximation.
 *  Given a function (an object of the 'Function' class in the function package in this directory)
 *  these methods give an approximation to a nearby root, either taking a number of iterations
 *  or a desired accuracy as a parameter.
 *
 *  Newton's method converges quadratically to a nearby root for most initial values for x = k.
 *  The closer the initial approximation is to the root, the better the convergence is.
 *  However, be aware that there are some conditions that cause Newton's method to converge linearly
 *  or not at all. In these conditions, the bisection method serves as an alternative.
 *  The bisection method converges linearly to a root in the given interval if one exists.
 *
 * @author Aaron Anderson
 *         9/18/18
 *
 */
public final class Approximation {

    /**
     *  Implements Newton's method by iterating
     *      x_(n+1) = x_n - (f(x_n) / f'(x_n))
     *  for a given number n times.
     *  This method converges converges quadratically for
     *  most initial x_0 = k unless f'(k) = 0.
     *
     * @param f     Function to approximate
     * @param k     Initial approximation
     * @param n     Number of iterations to perform
     * @return
     */
    public static double newtonMethod(Function f, double k, int n) {
        for(int i = 0; i < n; i++)
            k = k - ( f.evaluate(k) / f.derivative(1).evaluate(k) );
        return k;
    }

    /**
     *  This method implements Newton's method to a specified degree of precision, 10^(-order).
     *  iterates x_(n+1) = x_n - (f(x_n) / f'(x_n)) until the specified degree of precision is reached.
     *  Note that this relies on a special property that approximates the error bound but is not guaranteed.
     *  This method may be unstable for some functions, so it is recommended that it is checked with 'newtonMethod'
     *  or 'bisectMethod'.
     *
     * @param f     Function to approximate
     * @param k     Initial approximation
     * @param order Desired order of precision
     * @return
     */
    public static double newtonMethodBound(Function f, double k, int order) {
        double temp;
        do {
            temp = k;
            k = k - (f.evaluate(k) / f.derivative(1).evaluate(k));
        } while (Math.abs(k - temp) > Math.pow(10, -order));
        return k;
    }


    /**
     *  This method implements the bisection method for solving roots.
     *  The bisection method converges linearly, but can be very useful because it is
     *  guaranteed to converge provided that a root exists in the given interval.
     *
     *  Takes a Function f, and finds converges linearly to a root between p0 and p1 if one exists.
     *
     *  This form of the method iterates a specified number of times n.
     *  because the size of the interval is halved each iteration, the error bound
     *  for this method is (p1 = p0)/2^(n).
     *
     *
     * @param f     Function to approximate
     * @param p0    Lower bound of interval
     * @param p1    Upper bound of interval
     * @param n     Number of iterations to perform
     * @return
     */
    public static double bisectMethod(Function f,  double p0, double p1, int n) {
        if ((f.evaluate(p1) * f.evaluate(p0)) > 0)
            return -1;

        double range = p1 - p0;
        double mid = p0 + (range / 2);

        for(int i = 0; i < n; i++) {
            range = p1 - p0;
            mid = p0 + (range / 2);

            if (f.evaluate(mid) * f.evaluate(p0) > 0)
                p0 = mid;
            else
                p1 = mid;
        }
        return mid;
    }

    /**
     *  This method implements the bisection method for solving roots.
     *  The bisection method converges linearly, but can be very useful because it is
     *  guaranteed to converge provided that a root exists in the given interval.
     *
     *  Takes a Function f, and finds converges linearly to a root between p0 and p1 if one exists.
     *
     *  This form of the method iterates until the size of the interval is less than
     *  10^(-order), which serves as the error bound.
     *
     *
     * @param f     Function to approximate
     * @param p0    Lower bound of interval
     * @param p1    Upper bound of interval
     * @param order Desired order of precision
     * @return
     */
    public static double bisectMethodBound(Function f,  double p0, double p1, int order) {
        if ((f.evaluate(p1) * f.evaluate(p0)) > 0)
            return -1;

        double range = p1 - p0;
        double mid = p0 + (range / 2);

        while ((range) > (Math.pow(10, -order))) {
            range = p1 - p0;
            mid = p0 + (range / 2);

            if (f.evaluate(mid) * f.evaluate(p0) > 0)
                p0 = mid;
            else
                p1 = mid;
        }
        return mid;
    }
}
