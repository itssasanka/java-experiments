package utils;

/**
 * Created by Sasanka on 7/3/2015.
 */
public class QueueImp {
    private final int[] array;
    private int front=0;
    private int rear=0;

    public QueueImp(int size) {
        array = new int[size];
    }

    public void enQueue(int element) {
        if (front == array.length) {
            throw new IllegalStateException("Size limit reached!");
        }
        array[front++] = element;
    }

    public int deQueue() {
        if(rear==front) {
            throw new IllegalStateException("Empty queue");
        }
        return array[rear++];
    }

    public int size(){
        return rear-front;
    }

    public String print() {
        String queueSnapshot="";
        for (int i = rear; i < front; i++) {
            queueSnapshot += String.valueOf(array[i])+" ";
        }
        return queueSnapshot;
    }
}
