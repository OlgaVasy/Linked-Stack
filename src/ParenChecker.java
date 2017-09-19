/** ParenChecker.java
 */
import java.util.EmptyStackException;

public class ParenChecker {

   private static final String OPEN = "([{";
   /** Set of closing parenthesis characters, matches OPEN. */
   private static final String CLOSE = ")]}";

   public static boolean isBalanced(String expression) {
      // Create an empty stack.
      LinkedStack s = new LinkedStack();
      boolean balanced = true;
      try {
         int index = 0;
         while (balanced && index < expression.length()) {
            char nextCh = expression.charAt(index);
            if (isOpen(nextCh)) {
               s.push(nextCh);
            } else if (isClose(nextCh)) {
               char topCh = (char) s.pop();
               balanced =
                  OPEN.indexOf(topCh) == CLOSE.indexOf(nextCh);
            }
            index++;
         }
      } catch (EmptyStackException ex) {
         balanced = false;
      }
      return (balanced && s.empty());
   }

   private static boolean isOpen(char ch) {
      return OPEN.indexOf(ch) > -1;
   }

   private static boolean isClose(char ch) {
      return CLOSE.indexOf(ch) > -1;
   }
}
