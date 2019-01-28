package function.terms;

/**
 *  Class Sin, extends Term
 *
 *  This class is used to symbolically represent functions of the form a*sin(bx).
 *  Contains implementations of evaluate() and derivative() methods.
 *
 * @author Aaron Anderson
 *         9/17/18
 */
public class Sin extends Term {

    /**
     * Constructor for Sin that initializes to sin(x)
     */
    public Sin() {
        this.a = 1;
        this.b = 1;
        this.trig = true;
    }

    /**
     * Constructor for Sin that initializes to a*sin(bx)
     */
    public Sin(double a, double b) {
        this.a = a;
        this.b = b;
        this.trig = true;
    }

    /**
     * Returns a*sin(bx)
     * @param x value of x
     */
    public double evaluate(double x) {
        return (a) * (Math.sin(b * x));
    }

    /**
     * Returns derivative of a*sin(bx) = ab*cos(bx)
     * @return Cos ab*cos(bx)
     */
    public Term derivative() {
        return new Cos(this.getA() * this.getB(), this.getB());
    }

    /**
     * Returns String representation of this function
     * @return String representation of "a*sin(bx)"
     */
    public String toString() {
        if (a > 0)
            return "+" + a + "sin(" + b + "x)";
        else
            return a + "sin(" + b + "x)";
    }
}