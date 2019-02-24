package main;

import java.util.Random;
import java.util.Stack;

public class Ques7 {
    /*
       Design a Data Structure SpecialStack that supports all the stack operations like push(),
       pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum
       element from the SpecialStack. (Expected complexity ­ O(1))
   */
    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();     //used a stack of max-size of 10 elements

        //checking for stack status-----------------------
        check(specialStack);

        //entering 10 random integers into the stack
        System.out.println("Pushing random numbers into the stack");
        while (!specialStack.isFull()) specialStack.push(new Random().nextInt(100));


        //checking for stack status------------------------
        check(specialStack);

        //finding out min value in the stack
        System.out.println("Current min is: " + specialStack.getMin());

        //applying pop operation
        System.out.println("Popping out elements from the stack");
        while (!specialStack.isEmpty()) specialStack.pop();

        //checking for stack status--------------------------
        check(specialStack);
    }

    static void check(SpecialStack specialStack) {
        if (specialStack.isEmpty()) System.out.println("Stack is Empty");
        else if (specialStack.isFull()) System.out.println("Stack is Full");
        else System.out.println("Stack is neither Empty nor Full");
    }
}

class SpecialStack {
    private Stack<Integer> stack;
    private Stack<Integer> minVal;
    //maximum capacity of stack is considered 10 elements

    public SpecialStack() {
        stack = new Stack<>();
        minVal = new Stack<>();
    }

    void push(Integer integer) {
        if (stack.size() == 10) {
            System.out.println("Stack is full");
        } else if (stack.isEmpty()) {
            stack.push(integer);
            minVal.push(integer);
            System.out.println(stack.peek() + " entered successfully in the stack");
        } else {
            stack.push(integer);
            System.out.println(stack.peek() + " entered successfully in the stack");
            if (integer < minVal.peek())
                minVal.push(integer);
            else
                minVal.push(minVal.peek());
        }
    }

    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack has no more elements");
        } else {
            System.out.println("Element " + stack.pop() + " removed from the stack and current min is: " + minVal.pop());
        }
    }

    boolean isFull() {
        return stack.size() == 10;      //returns true when stack has 10 element in it.
    }

    boolean isEmpty() {
        return stack.isEmpty();     //returns true when stack doesnot have any element in it.
    }

    int getMin() {
        return minVal.peek();
    }
}
