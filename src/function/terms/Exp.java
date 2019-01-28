package function.terms;

/**
 *  Class Exp, extends Term
 *
 *  This class is used to symbolically represent functions of the form a*e^(bx).
 *  Contains implementations of evaluate() and derivative() methods.
 *
 * @author Aaron Anderson
 *         9/17/18
 */
public class Exp extends Term {

    /**
     * Constructor for Log that initializes to e^x
     */
    public Exp() {
        this.a = 1;
        this.b = 1;
        this.trig = false;
    }

    /**
     * Constructor for Log that initializes to a*e^(bx)
     */
    public Exp(double a, double b) {
        this.a = a;
        this.b = b;
        this.trig = false;
    }

    /**
     * Returns a*e^(bx)
     * @param x value of x
     */
    public double evaluate(double x) {
        return (a) * (Math.pow(Math.E, (b * x)));
    }

    /**
     * Returns derivative of a*e^(bx) = ab*e^(bx)
     * @return Exp ab*e^(bx)
     */
    public Term derivative() {
        return new Exp(this.getA() * this.getB(), this.getB());
    }

    /**
     * Returns String representation of this function
     * @return String representation of "ab*e^(bx)"
     */
    public String toString() {
        if (a > 0)
            return "+" + a + "e^(" + b + "x)";
        else
            return a + "e^(" + b + "x)";
    }
}
