package datastructures;

import utils.QueueImp;

/**
 * Created by Sasanka on 7/3/2015.
 */
public class QueueImpExample {
    public static void main(String args[]) {
        QueueImp queueImp = new QueueImp(3);
        queueImp.enQueue(1);
        queueImp.enQueue(2);
        queueImp.enQueue(3);

        System.out.println(queueImp.print());

        queueImp.deQueue();
        queueImp.deQueue();
        queueImp.deQueue();

        System.out.println(queueImp.print());
    }
}
