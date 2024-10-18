package interview_prep.DSA_Leetcode.stack;

/**
 * Stack works on the LIFO concept
 * Last In First Out
 */
public class Stack {

    private int top;
    private int size;
    private int[] stack;

    public Stack(int capacity) {
        size = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int val) {
        //check if stack has reached capacity
        if(top == size - 1) {
            System.out.println("Stack is full, cannot push more elements");

        } else {
            //insert element at top
            top++;
            stack[top] = val;
        }

    }

    public int peek() {
        //check whether stack is empty
        if(top == -1) {
            System.out.println("Stack is empty, No element to display");
            return Integer.MIN_VALUE;
        } else {
            return stack[top];
        }
    }


    public void pop() {
        //check whether stack is empty
        int val = peek();
        if(val == Integer.MIN_VALUE) {
            //stack is empty
        } else {
            //decrease the top
            top--;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top > -1 ? top+1: 0;
    }

    public int getCapacity() {
        return size;
    }




}
