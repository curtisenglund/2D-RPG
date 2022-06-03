

public class test2 {

   public static void main(String[] args) {
      Stack<Integer> stack = new Stack<Integer>(10);
      System.out.print("Elements pushed in the Stack: ");
        for (int i = 0; i < 10; i++) {
            stack.push(i); //pushes 5 elements (0-4 inclusive) to the stack
            System.out.print(i + " ");
        }
        System.out.println("\nIs Stack full? \n" + stack.isFull());
        stack.push(300);
        stack.print();
        for (int i = 0; i < 20; i++) {
            System.out.print(stack.pop()+" "); //pops all 5 elements from the stack and prints them
        }
        System.out.println("\nIs Stack empty? \n" + stack.isEmpty());
   }   
}