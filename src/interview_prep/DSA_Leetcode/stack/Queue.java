package interview_prep.DSA_Leetcode.stack;

public class Queue {

    private int capacity;
    private int[] queue;
    private int front , rear;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = -1;
    }

    /**
     * Elements to be inserted at rear,
     * elements to be cleared out from front
     * when front is equal to rear, then the queue is empty
     * and when rear has reached capacity the queue is full
     * @return
     */
    //methods
    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public void enqueue(int val) {
        //check whether queue is full
        if (isFull()) {
            System.out.println("Queue is filled to capacity");
            return;
        }
        //since at empty only front will move from -1 to 0
        if (isEmpty()) {
            front = 0;
            rear = 0;

        } else {
            rear++;
        }
        queue[rear] = val;
    }

    public int peek() {
        //check whether queue is empty
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        } else {
            int val = queue[front];
            System.out.println("Peek: "+val);
            return val;
        }
    }

    public int dequeue() {
        //reuse peek
        int val = peek();
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        else  {
            if(front == rear) {
                //last element case
                front = rear = -1;
            } else {
                front++;
            }
        }
        return val;
    }

    public int getSize() {
        return rear == front ? 0 : rear - front + 1;
    }
}
