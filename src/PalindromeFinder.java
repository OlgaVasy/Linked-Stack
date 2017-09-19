/** PalindromeFinder. java
 */
import java.util.*;

public class PalindromeFinder {

   private String inputString;

   LinkedStack charStack = new LinkedStack();

   public PalindromeFinder(String str){
      inputString = str;
      fillStack();
   }
   private void fillStack(){
      for(int i = 0; i < inputString.length(); i++){
         charStack.push(inputString.charAt(i));
      }
   }
   private String buildReverse(){
      StringBuilder result = new StringBuilder();
      while(!charStack.empty()){
         result.append(charStack.pop());
      }
      return result.toString();
   }

   public boolean isPalindrome(){
      return inputString.equalsIgnoreCase(buildReverse());
   }


}