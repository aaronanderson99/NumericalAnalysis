package function.terms;

/**
 *  Class Power, extends Term
 *
 *  This class is used to symbolically represent functions of the form a*x^b.
 *  Contains implementations of evaluate() and derivative() methods.
 *
 * @author Aaron Anderson
 *         9/17/18
 */
public class Power extends Term {

    /**
     * Constructor for Power that initializes to x
     */
    public Power() {
        this.a = 1;
        this.b = 1;
        this.trig = false;
    }

    /**
     * Constructor for Power that initializes to a*x^b
     */
    public Power(double a, double b) {
        this.a = a;
        this.b = b;
        this.trig = false;
    }

    /**
     * Returns a*x^b
     * @param x value of x
     */
    public double evaluate(double x) {
        return (a) * (Math.pow(x, b));
    }

    /**
     * Returns derivative of a*x^b = ab*x^(b-1)
     * @return Power ab*x^(-1) if b != 0, or 0 otherwise
     */
    public Term derivative() {
        if (b == 0)
            return new Power(this.getA() * this.getB(), this.getB());
        else
            return new Power(this.getA() * this.getB(), this.getB() - 1);
    }

    /**
     * Returns String representation of this function
     * @return String representation of "a*x^b"
     */
    public String toString() {
        if (a > 0)
            return "+" + a + "x^(" + b + ")";
        else
            return a + "x^(" + b + ")";
    }
}