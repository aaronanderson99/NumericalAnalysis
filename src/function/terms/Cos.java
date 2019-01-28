package function.terms;

/**
 *  Class Cos, extends Term
 *
 *  This class is used to symbolically represent functions of the form a*cos(bx).
 *  Contains implementations of evaluate() and derivative() methods.
 *
 * @author Aaron Anderson
 *         9/17/18
 */
public class Cos extends Term {

    /**
     * Constructor for Cos that initializes to cos(x)
     */
    public Cos() {
        this.a = 1;
        this.b = 1;
        this.trig = true;
    }

    /**
     * Constructor for Cos that initializes to a*cos(bx)
     */
    public Cos(double a, double b) {
        this.a = a;
        this.b = b;
        this.trig = true;
    }

    /**
     * Returns a*cos(bx)
     * @param x value of x
     */
    public double evaluate(double x) {
        return (a) * (Math.cos(b * x));
    }

    /**
     * Returns derivative of a*cos(bx) = -ab*sin(bx)
     * @return Sin -ab*sin(bx)
     */
    public Term derivative() {
        return new Sin(-this.getA() * this.getB(), this.getB());
    }

    /**
     * Returns String representation of this function
     * @return String representation of "a*cos(bx)"
     */
    public String toString() {
        if (a > 0)
            return "+" + a + "cos(" + b + "x)";
        else
            return a + "cos(" + b + "x)";
    }
}
