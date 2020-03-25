/* File: Convert.java
 * Date: 20 March 2020
 * Author: Tyler D Clark
 * Description: Method for converting postfix expressions to prefix and prefix expressions to postfix. Additionally,
 * there are two utility methods: 1. to tokenize the input string 2. check if operator or not */

package wk2;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Convert {

    public static String fromPostfixToPrefix(String expression) throws IOException, SyntaxError {
        if (!expression.equals("")){
            //tokenize the string and create stack
            List<String> expressionToArray = tokenizeExpression(expression);
            Stack<String> operandStack = new Stack<>();
            //loop through the expression array and place on reversal stack
            for (String token:expressionToArray) {// had to remove reversal stack to make work correctly
                if (!isOperator(token)){
                    System.out.println(token);
                    operandStack.push(token + " ");
                }else {
                    try {//replaced many if/else statements with a try/catch which simply throws the custom exception
                        //for proper order, the second operand is the first from the stack
                        String operandTwo = operandStack.pop();
                        String operandOne = operandStack.pop();
                        String innerExpression = token + " " + operandOne + operandTwo;
                        operandStack.push(innerExpression);
                    }catch (EmptyStackException ex){
                        throw new SyntaxError("Expression is not balanced correctly!");
                    }
                }
            }
            String result = operandStack.pop();
            //check if stack is empty. If it is, return result
            if (operandStack.empty()){
                return result;
            }else { // else throw new exception
                throw new SyntaxError("Expression is not balanced correctly!");
            }
        } else {
            throw new SyntaxError("Please enter something!");
        }
    }

public static String fromPrefixToPostfix(String expression){
        return expression;
}
    private static List<String> tokenizeExpression(String expression) throws IOException {
        StreamTokenizer tokenizeExpression = new StreamTokenizer(new StringReader(expression));
        //treat the following as normal chars
        tokenizeExpression.ordinaryChar('-');
        tokenizeExpression.ordinaryChar('/');
        List<String> tokenList = new ArrayList<>();
        // match tokens until end of stream
        while (tokenizeExpression.nextToken() != StreamTokenizer.TT_EOF){
            //number
            if (tokenizeExpression.ttype == StreamTokenizer.TT_NUMBER){
                //if using String is too hard, might use object instead
                tokenList.add(String.valueOf((int)tokenizeExpression.nval));
            }else if(tokenizeExpression.ttype == StreamTokenizer.TT_WORD){
                tokenList.add(tokenizeExpression.sval);
                //operator
            }else{
                tokenList.add(String.valueOf((char) tokenizeExpression.ttype));
            }
        }
        return tokenList;
    }

    //only way I can find to eval chars from string,
    private static boolean isOperator(String term){
         switch (term.charAt(0)){ //also looks at the first operand in inner expressions
             case '+':
             case '-':
             case '/':
             case '*':
                 return true;
         } return false;
    }
}
