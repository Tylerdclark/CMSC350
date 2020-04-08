/* File: Polynomial.java
 * Date: 07 April 2020
 * Author: Tyler D Clark
 * Description: The description will go here :o) */

package wk4.project2;

import java.util.Iterator;

public class Polynomial implements Iterable, Comparable {

    //todo: constructor - accepts a string that defines one polynomial in the same format as provided in the input file.
    public Polynomial(String fromFile) {
        String termArr[] = fromFile.split(" ");
        for (String s: termArr) {
            double coefficient = Double.parseDouble(s);
            int exponent = Integer.parseInt(s);

        }
    }

    //todo: compareTo - that compares two polynomials.
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    //todo: iterator - iterates across the terms of the polynomial
    @Override
    public Iterator iterator() {
        return null;
    }

    //todo: toString - converts a polynomial to a string.
    @Override
    public String toString() {
        return super.toString();
    }



    static class Term {
        double coefficient;
        int exponent;
        Term next;

        Term(double c, int e, Term next) {
            this.coefficient = c;
            this.exponent = e;
            this.next = next;
        }
    }
}
//todo: create static nested singly linked list class


