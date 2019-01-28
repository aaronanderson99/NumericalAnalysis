package function;

import function.terms.*;
import java.util.LinkedList;

/**
 *  Class Function
 *
 *  This class is used to symbolically represent functions composed of simple terms of the following forms:
 *      a*x^b
 *      a*e^bx
 *      a*ln(bx)
 *      a*sin(bx)
 *      a*cos(bx)
 *
 *  Contains a list of objects of the subclasses of 'Term', each of which represent one of the above forms.
 *  Contains methods to evaluate, and return the nth derivative of the function object.
 *
 *  This class is intended to be used with the approximaton.Approximation methods for Newton's method and Bisection.
 *
 *  @author Aaron Anderson
 *          9/18/18
 */
public class Function {
    /** List of terms */
    private LinkedList<Term> terms = new LinkedList<>();

    /** Default constructor for an empty Function */
    public Function() {
    }
    /** Constructor that initializes a Function with one term */
    public Function(Term term) {
        terms.add(term);
    }

    /**
     * Adds a term to the terms list.
     * @param term  term to be added.
     */
    public void addTerm(Term term) {
        terms.add(term);
    }

    /**
     * Removes a term from the list.
     * @param index  index of the term to be removed.
     */
    public void removeTerm(int index) {
        terms.remove(index);
    }

    /**
     * Returns a term from the list.
     * @param index  index of the term to be returned.
     * @return term at given index
     */
    public Term getTerm(int index) {
        return terms.get(index);
    }

    /**
     * Returns the number of terms
     * @return number of terms
     */
    public int getSize() {
        return this.terms.size();
    }

    /**
     * Returns function evaluated at a given x
     * @param x to be evaluated
     * @return f(x)
     */
    public double evaluate(double x) {
        double sum = 0;
        for (int i = 0; i < terms.size(); i++)
            sum += this.getTerm(i).evaluate(x);
        return sum;
    }

    /**
     * Adds a second function c*f to this function.
     * @param f to be evaluated
     * @param c constant to multiply f by
     */
    public void add(Function f, double c) {
        for (int i = 0; i < f.getSize(); i++) {
            f.getTerm(i).setA(f.getTerm(i).getA() * c);
            this.addTerm(f.getTerm(i));
        }
    }

    /**
     * Removes all terms from this function.
     */
    public void clear() {
        terms.clear();
    }

    /**
     * Returns the nth derivative of this function.
     * @param order Order of derivative to return
     */
    public Function derivative(int order) {
        Function derivative = null;
        Function temp = this;
        if (order == 0)
            return this;
        for (int j = 0; j < order; j++) {
            derivative = new Function();
            for (int i = 0; i < temp.getSize(); i++)
                derivative.addTerm(temp.getTerm(i).derivative());
            temp = derivative;
        }
        return derivative;
    }

    /**
     * Returns a string representation of this function.
     * @return  String representation of this function
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < terms.size(); i++)
            str += this.getTerm(i).toString() + "\t";
        return str;
    }
}