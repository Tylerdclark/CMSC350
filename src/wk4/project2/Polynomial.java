package wk4.project2;

import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Iterator;

public class Polynomial implements Iterable, Comparable {

    //todo: constructor - accepts a string that defines one polynomial in the same format as provided in the input file.
    public Polynomial(String fromfile){
        //taking the String and splitting it into terms
        StreamTokenizer tokenizeExpression = new StreamTokenizer(new StringReader(fromfile));
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

    class Node { double coefficient; int exponent; Node next;

        Node( double c, int e ) { coefficient = c; exponent = e; next = null;}
    }



}
//todo: create static nested singly linked list class


