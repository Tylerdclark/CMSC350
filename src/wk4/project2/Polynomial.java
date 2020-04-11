/* File: Polynomial.java
 * Date: 07 April 2020
 * Author: Tyler D Clark
 * Description: The description will go here :o) */

package wk4.project2;

import java.util.Iterator;
import java.util.Scanner;


public class Polynomial implements Iterable<Polynomial.Term>, Comparable<Polynomial> {

    private Term head;

    //===============================================================================================
    //  method: Polynomial constructor/ arguments: String of space delimited coeffs and exponents
    //  description: splits the String into individual term nodes and creates a linked list of them
    //===============================================================================================

    public Polynomial(String fromFile) {
        head = null; // explicitly stating for clarity
        Scanner termScanner = new Scanner(fromFile);
        try{
            while(termScanner.hasNext()){
                addTerm(termScanner.nextDouble(), termScanner.nextInt());
            }
        } catch (Exception ex){
            throw new InvalidPolynomialSyntax("Incorrect Syntax, please check inputs!");
        }
    }


    public void addTerm(double coefficient, int exponent ){
        if (exponent < 0){
            throw new InvalidPolynomialSyntax("No negative exponents, please check inputs!");
        }
        Term current = head;
        if(current == null){ // then Polynomial is empty
            head = new Term(coefficient, exponent);
            head.next = null;
        } else {
            while(current.next != null){
                current = current.next;
            }
            current.next = new Term(coefficient, exponent);
        }

    }

    @Override
    public int compareTo(Polynomial otherPoly) {
        Term thisCurrent = this.head;
        Term otherCurrent = otherPoly.head;

        while (thisCurrent != null && otherCurrent != null){

            if (thisCurrent.exponent != otherCurrent.exponent){
                return thisCurrent.exponent - otherCurrent.exponent;

            }else if(thisCurrent.coefficient != otherCurrent.coefficient) {
                return (int) (thisCurrent.coefficient - otherCurrent.coefficient);

            }
            thisCurrent = thisCurrent.next;
            otherCurrent = otherCurrent.next;
        }
        if (thisCurrent == null && otherCurrent == null){
            return 0;
        }
        if (thisCurrent == null){
            return -1;
        }else {
            return +1;
        }
    }

    //todo: iterator - iterates across the terms of the polynomial
    @Override
    public Iterator<Term> iterator() {
        return new Iterator<>() {

            private Term current;

            @Override
            public boolean hasNext() {
                if (current == null) {
                    return head != null;
                } else {
                    return current.next != null;
                }
            }

            @Override
            public Term next() {
                if (current == null) {
                    current = head;
                } else {
                    current = current.next;
                }
                return current;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder expressionBuilder = new StringBuilder();
        //first check head to avoid +1x^3 +3x^2
        if (head.coefficient > 0){
            expressionBuilder.append(head.toString());
        }else{
            expressionBuilder.append(" - ").append(head.toString());
        }// then check the other nodes if they are not null
        for(Term tmp = head.next; tmp != null; tmp = tmp.next) {
            if (tmp.coefficient < 0) {
                expressionBuilder.append(" - ").append(tmp.toString());
            } else {
                expressionBuilder.append(" + ").append(tmp.toString());
            }
        }
        return expressionBuilder.toString();

    }


    //===============================================================================================
    //  Nested Class: Term and constructor/ arguments: double coefficient and int exponent
    //  description: nodes of the polynomial objects which cary the reference to the next node
    //===============================================================================================

    static class Term{
        double coefficient;
        int exponent;
        Term next;

        Term(double c, int e) {
            coefficient = c;
            exponent = e;
            next = null; // explicitly setting to null
        }

        public String toString(){
            String termString = String.format("%.1f", Math.abs(coefficient));
            if (exponent == 0) { //no variable
                return termString;
            }else if(exponent == 1){ // do not display exponent
                return termString + "x";
            } else{ // display exponent after variable
                return termString + "x^" + exponent;
            }
        }
    }
}