import java.util.Scanner;

/** Testing application: LinkedStackTest.java
 */
public class LinkedStackTest {

   public static void main(String[] args) throws InfixToPostfix.SyntaxErrorException, PostfixEvaluator.SyntaxErrorException {

      // Test LinkedStack
      LinkedStack newStack = new LinkedStack();

      Scanner input = new Scanner(System.in);

      System.out.print("Enter the size of the stack: ");
      int size = input.nextInt();
      while (size < 0) {
         System.out.print("Please enter the positive number: ");
         size = input.nextInt();
      }

      System.out.print("Do you wish to insert an item on the top of the stack? (Y/N) ");
      char response = input.next().charAt(0);
      while (response != 'Y' && response != 'y' && response != 'N' && response != 'n'){
         System.out.print("Please enter Y for Yes or N for No: ");
         response = input.next().charAt(0);
      }
      input.nextLine();
      while (response == 'Y' || response == 'y'){
         if (!newStack.full(size)){
            System.out.print("Enter the item to insert on the top of the stack: ");
            String item = input.nextLine();
            newStack.push(item);
            System.out.print("Do you wish to insert an item on the top of the stack? (Y/N) ");
            response = input.next().charAt(0);
            while (response != 'Y' && response != 'y' && response != 'N' && response != 'n'){
               System.out.print("Please enter Y for Yes or N for No: ");
               response = input.next().charAt(0);
            }
            input.nextLine();}
         else {
            System.out.println("Cannot be performed. The stack is full");
            System.out.println(newStack.toString());
            break;
         }
  }
      if (response == 'N' || response == 'n'){
         if (!newStack.full(size))
            System.out.println("The stack is not full");
         else System.out.println("The stack is full");
         System.out.println(newStack.toString());}

         if (!newStack.empty()){
            System.out.print("Press R if you wish to return the top item on the stack or any another key to skip: ");
            char newResponse = input.next().charAt(0);
            if (newResponse == 'R' || newResponse == 'r')
               System.out.println(newStack.peek());
            System.out.print("Press D if you wish to remove the top item on the stack or any another key to skip: ");
            char response2 = input.next().charAt(0);
            while (response2 == 'D' || response2 == 'd'){
               if (!newStack.empty()){
                  newStack.pop();
                  System.out.println(newStack.toString());
                  System.out.print("Press D if you wish to remove the top item on the stack or any another key to skip: ");
                  response2 = input.next().charAt(0);
               input.nextLine();}
                else {System.out.print("Nothing to remove. The stack is empty");
                  break;}
            }

      }
      if (!newStack.empty()){
         System.out.print("Press C if you wish to clear the stack or any another key to skip: ");
         char newResponse = input.next().charAt(0);
         if (newResponse == 'C' || newResponse == 'c'){
            newStack.toEmpty();
            System.out.println(newStack.toString());
      }
}
     // test PalindromeFinder
      System.out.print("Enter a string to check if it is a palindrome: ");
      String sentence = input.nextLine();
      while (sentence.length()==0){
         System.out.print("Enter a string to check if it is a palindrome: ");
         sentence = input.nextLine();
      }
      PalindromeFinder newInput = new PalindromeFinder(sentence);
      if (newInput.isPalindrome())
         System.out.println("It is a palindrome");
      else
         System.out.println("It is not a palindrome");


      // test ParenChecker
      System.out.print("Enter an expression to check for balanced parentheses: ");
      String expression = input.nextLine();
      while (expression.length()==0){
         System.out.print("Enter an expression to check for balanced parentheses: ");
         expression = input.nextLine();
      }
      ParenChecker newExpression = new ParenChecker();
      if (newExpression.isBalanced(expression))
         System.out.println("The expression is balanced with respect to parentheses");
      else
         System.out.println("The expression is not balanced");


      // test InfixtoPostfix
      System.out.print("Enter an infix expression to convert to postfix expression: ");
      String infixExpression = input.nextLine();
      while (infixExpression.length()==0){
         System.out.print("Enter an infix expression to convert to postfix expression: ");
         infixExpression = input.nextLine();
      }
      InfixToPostfix newInfix = new InfixToPostfix();
      String postfixExpression = newInfix.convert(infixExpression);
      System.out.println(postfixExpression);

      //test PostfixEvaluator
      PostfixEvaluator newPostfix = new PostfixEvaluator();
      System.out.println(newPostfix.eval(postfixExpression));

   }}