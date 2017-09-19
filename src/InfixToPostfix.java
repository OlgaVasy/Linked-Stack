/** InfixToPostfix.java
 */
import java.util.*;
import java.util.regex.*;

public class InfixToPostfix {

   public static class SyntaxErrorException extends Exception {

      SyntaxErrorException(String message) {
         super(message);
      }
   }

   LinkedStack operatorStack;

   private static final String OPERATORS = "-+*/";

   private static final int[] PRECEDENCE = {1, 1, 2, 2};

   private static final Pattern tokens =
      Pattern.compile("\\d+\\.\\d*|\\d+|"
         + "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*"
         + "|[" + OPERATORS + "]");
   /** The postfix string */
   private StringBuilder postfix;

   public String convert(String infix) throws SyntaxErrorException {
      operatorStack = new LinkedStack();
      postfix = new StringBuilder();
      Scanner s = new Scanner(infix);
      try {
         // Process each token in the infix string.
         String nextToken = null;
         while ((nextToken = s.findInLine(tokens)) != null) {
            char firstChar = nextToken.charAt(0);
            // Is it an operand?
            if (Character.isJavaIdentifierStart(firstChar)
               || Character.isDigit(firstChar)) {
               postfix.append(nextToken);
               postfix.append(' ');
            } // Is it an operator?
            else if (isOperator(firstChar)) {
               processOperator(firstChar);
            } else {
               throw new SyntaxErrorException
                  ("Unexpected Character Encountered: " + firstChar);
            }
         } // End while.

         // Pop any remaining operators and
         // append them to postfix.
         while (!operatorStack.empty()) {
            char op = (char) operatorStack.pop();
            postfix.append(op);
            postfix.append(' ');
         }
         // assert: Stack is empty, return result.
         return postfix.toString();
      } catch (EmptyStackException ex) {
         throw new SyntaxErrorException("Syntax Error: The stack is empty");
      }
   }

   private void processOperator(char op) {
      if (operatorStack.empty()) {
         operatorStack.push(op);
      } else {
         // Peek the operator stack and
         // let topOp be top operator.
         char topOp = (char) operatorStack.peek();
         if (precedence(op) > precedence(topOp)) {
            operatorStack.push(op);
         } else {
            // Pop all stacked operators with equal
            // or higher precedence than op.
            while (!operatorStack.empty()
               && precedence(op) <= precedence(topOp)) {
               operatorStack.pop();
               postfix.append(topOp);
               postfix.append(' ');
               if (!operatorStack.empty()) {
                  // Reset topOp.
                  topOp = (char) operatorStack.peek();
               }
            }
            operatorStack.push(op);
         }
      }
   }

   private boolean isOperator(char ch) {
      return OPERATORS.indexOf(ch) != -1;
   }

   private int precedence(char op) {
      return PRECEDENCE[OPERATORS.indexOf(op)];
   }
}