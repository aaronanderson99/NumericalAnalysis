package function.terms;

/**
 *  Class Log, extends Term
 *
 *  This class is used to symbolically represent functions of the form a*ln(bx).
 *  Contains implementations of evaluate() and derivative() methods.
 *
 * @author Aaron Anderson
 *         9/17/18
 */
public class Log extends Term {

    /**
     * Constructor for Log that initializes to ln(x)
     */
    public Log() {
        this.a = 1;
        this.b = 1;
        this.trig = false;
    }

    /**
     * Constructor for Log that initializes to a*ln(bx)
     */
    public Log(double a, double b) {
        this.a = a;
        this.b = b;
        this.trig = false;
    }

    /**
     * Returns a*ln(bx)
     * @param x value of x
     */
    public double evaluate(double x) {
        return (a) * (Math.log(b * x));
    }

    /**
     * Returns derivative of a*ln(bx) = ab*x^(-1)
     * @return Power ab*x^(-1)
     */
    public Term derivative() {
        return new Power(this.getA()*this.getB(), -1);
    }

    /**
     * Returns String representation of this function
     * @return String representation of "a*ln(bx)"
     */
    public String toString() {
        if (a > 0)
            return "+" + a + "ln(" + b + "x)";
        else
            return a + "ln(" + b + "x)";
    }
}