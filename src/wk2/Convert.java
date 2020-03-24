package wk2;

import java.util.Stack;
import java.util.StringTokenizer;

public class Convert {

    public static String fromPostfixToPrefix(String expression){
        String[] expressionToArray = tokenizeExpression(expression);
        //String prefixExpression;
        Stack<String> reversalStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();

        //loop through the expression array and place on reversal stack
        for (String s:expressionToArray) {
            reversalStack.push(s);
        }
        while(!reversalStack.empty()){
            String temp = reversalStack.pop();

            if (!isOperator(temp)){
                operandStack.push(temp);
            }else {
                String operator = reversalStack.pop();
                System.out.println(operator);
                String operandOne = operandStack.pop();
                String operandTwo = operandStack.pop();
                String innerExpression = operator + operandOne + operandTwo;
                operandStack.push(innerExpression);
            }
        }
       return operandStack.pop();
    }

    private static String[] tokenizeExpression(String expression){
        //make a array with length of the string
        return expression.split("[ -+*/]");
    }
    private static boolean isOperator(String term){

         switch (term.charAt(0)){
             case '+':
             case '-':
             case '/':
             case '*':
                 return true;
         } return false;
    }
}
