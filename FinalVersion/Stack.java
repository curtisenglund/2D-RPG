import java.util.*;

public class Stack <Integer> {
    private int maxSize;
    private int top;
    private int array[];
    private int current;
    
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1; //initially when stack is empty
        array = new int[max_size];//type casting Object[] to V[]
        push(10);
        push(20);
        push(50);
    }
    
    // adds to array size
    public void StackHelper(int maxSize2) {
      int[] temp = new int[array.length];
      for(int i =0; i < array.length; i++) {
          temp[i] = array[i];
      }
      array = new int[maxSize2];
      for(int i =0; i < temp.length; i++) {
          array[i] = temp[i];
      }   
    }

    //returns the maximum size capacity
    public int getMaxSize() {
        return maxSize;
    }
   //returns true if Stack is empty
    public boolean isEmpty(){
        return top == -1;
    }

    //returns true if Stack is full
    public boolean isFull(){
        return top == maxSize -1;
    }

    //returns the value at top of Stack
    public int top(){
        if(isEmpty())
            return 0;
        return array[top];
    }

    //inserts a value to the top of Stack
    public void push(int value){
        if(isFull()) {
            StackHelper(maxSize+10);
            //System.out.print("changed the size");
            array[++top] = value;
            
        } else {
        	top++;
         array[top] = value; //increments the top and adds value to updated top
         }
    }

    //removes a value from top of Stack and returns
    public int pop(){
        if(isEmpty())
            return 0;
        return array[top--]; //returns value and top and decrements the top
    }
    public void print() {
      System.out.print(Arrays.toString(array));
    }
    
    public int peek() {
      return array[top];
    }

}
