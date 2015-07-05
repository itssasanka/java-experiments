/**
 * Created by Sasanka on 7/3/2015.
 */
public class QueueImp {
    private final int[] array;
    private int front=-1;
    private int rear=-1;

    public QueueImp(int size) {
        array = new int[size];
    }

    public void enQueue(int element) {
        if (front == array.length-1) {
            throw new IllegalStateException("Size limit reached!");
        }
        array[++front] = element;
    }

    public int deQueue() {
        if(rear==front) {
            throw new IllegalStateException("Empty queue");
        }
        return array[++rear];
    }

    public int size(){
        return rear-front+1;
    }

    public String print() {
        String queueSnapshot="";
        if (front == rear) {
            return queueSnapshot;
        }
        int start=(rear==-1)?0:rear;
        for (int i = start; i <= front; i++) {
            queueSnapshot += String.valueOf(array[i]);
        }
        return queueSnapshot;
    }
}
