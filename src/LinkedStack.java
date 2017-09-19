/** Project 2 P 191: LinkedStack.java
 */
import java.util.EmptyStackException;

interface StackInt<E>
{
   boolean empty();
   boolean full(int size);
   E toEmpty();
   E push(E obj);
   E pop();
   E peek();
}

public class LinkedStack<E> implements StackInt<E>{

   private int top = -1;

   private static class Node<E> {

      private E data;
      private Node<E> next;

      private Node(E dataItem) {
         data = dataItem;
         next = null;
      }

      private Node(E dataItem, Node<E> nodeRef) {
         data = dataItem;
         next = nodeRef;
      }
   }
   private Node<E> topOfStackRef = null;

   @Override
   public E push(E obj) {
         topOfStackRef = new Node<E>(obj, topOfStackRef);
         top++;
         return obj;
      }

   @Override
   public E pop() {
      if (empty()) {
         throw new EmptyStackException();
      } else {
         E result = topOfStackRef.data;
         topOfStackRef = topOfStackRef.next;
         top --;
         return result;
      }
   }
   @Override
   public E peek() {
      if (empty()) {
         throw new EmptyStackException();
      } else {
         return topOfStackRef.data;
      }}

   @Override
   public boolean empty() {
      return topOfStackRef == null;
   }

   @Override
   public boolean full(int size){
      return top == size - 1; }

   @Override
   public E toEmpty(){
      while (!empty()){
         pop();        }
     return null;
   }
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      Node p = topOfStackRef;
      if (p != null) {
         while (p.next != null) {
            sb.append(p.data.toString());
            sb.append("  ");
            p = p.next;
         }
         sb.append(p.data.toString());
      }
      return sb.toString();
   }
}
