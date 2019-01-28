package function.terms;

/**
 *  Abstract Class Term
 *
 *  This class is used to symbolically represent terms of the following forms:
 *      a*x^b
 *      a*e^bx
 *      a*ln(bx)
 *      a*sin(bx)
 *      a*cos(bx)
 *
 *  Contains abstract methods to evaluate and differentiate which are implemented by its subclasses.
 *
 * @author Aaron Anderson
 *         9/17/18
 */
public abstract class Term {
    /** Coefficient variable a */
    double a;
    /** Auxiliary variable b (either power or inner coefficient) */
    double b;
    /** Boolean for tracking trig functions */
    boolean trig;

    /**
     * Returns the value of this term at x
     * @param x
     * @return t(x)
     */
    public abstract double evaluate(double x);
    /**
     * Returns derivative of this term
     * @return t'(x)
     */
    public abstract Term derivative();
    /**
     * mutator for coefficient variable a
     * @param a coefficient variable
     */
    public void setA(double a) {
        this.a = a;
    }
    /**
     * mutator for auxiliary variable b
     * @param b auxiliary variable
     */
    public void setB(double b) {
        this.b = b;
    }
    /**
     * Returns whether this term is a trig function
     * @return Whether this term is a trig function
     */
    public boolean isTrig() {
        return this.trig;
    }
    /**
     * Returns coefficient variable a
     * @return coefficient variable a
     */
    public double getA() {
        return this.a;
    }
    /**
     * Returns auxiliary variable b
     * @return auxiliary variable b
     */
    public double getB() {
        return this.b;
    }
}