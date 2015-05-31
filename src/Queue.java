/**
 * Created by Sasanka on 5/31/2015.
 */
// Implement a basic queue
public class Queue {

    private int[] array;
    private int tail=0;
    private int front=0;
    public Queue(int size) {
        array = new int[size];
    }

    public void push(int element) {
        if (tail > array.length - 1) {
            System.out.println("Can't push any further");
            return;
        }
        array[tail++] = element;
    }

    public int get() throws Exception {
        if (front == tail) {
            throw new Exception("Reached the end of queue");
        }
        return array[front++];
    }

    public static void main(String args[]) {
        Queue queue = new Queue(1);
        queue.push(1);
        queue.push(2);

        try {
            System.out.println("queue.get() = " + queue.get());
            System.out.println("queue.get() = " + queue.get());
        } catch (Exception e) {
            //
        }


    }
}
