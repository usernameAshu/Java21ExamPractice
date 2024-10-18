package interview_prep.DSA_Leetcode.stack;

public class Driver {
    public static void main(String[] args) {
//    new Driver().testStack();
        new Driver().testQueue();
    }

    void testQueue() {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        System.out.println("Size: "+queue.getSize());
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Size: "+queue.getSize());
        queue.enqueue(50);
        System.out.println("Size: "+queue.getSize());

        queue.peek(); //10

        queue.enqueue(60); //full cap
        System.out.println("Size: "+queue.getSize());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Size: "+queue.getSize());
        queue.dequeue();
        System.out.println("Size: "+queue.getSize());
        queue.dequeue();
        System.out.println("Size: "+queue.getSize());
        queue.dequeue();
        System.out.println("size now: "+ queue.getSize());

    }

    void testStack() {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        viewStack(stack);
        stack.push(60);
        viewStack(stack);
        stack.pop(); //-50
        viewStack(stack);
        stack.pop();//-40
        stack.pop();//-30
        stack.pop();//-20
        viewStack(stack); //10
        System.out.println(stack.isEmpty());
        stack.pop(); //-10, empty

        stack.pop();
        System.out.println(stack.isEmpty());
        stack.peek();

        stack.push(100);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());

    }

    private void viewStack(Stack stack) {
        System.out.println(stack.peek());
    }

}
