package utils;

/**
 * Created by Sasanka on 6/1/2015.
 */
public class ListImp {
    private int maxLength =0;
    private Node head;
    public ListImp(int maxLength) {
        this.maxLength = maxLength;
    }

    public void add(int value) throws Exception {
        if (this.getLength() == maxLength) {
            throw new Exception("Cannot add more elements");
        }
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
    }

    public Node getHead(){
        return this.head;
    }

    public Node remove(int position) {
        Node deleted = null;

        if (position == 0) {
            deleted = Node.copyNode(head);
            head = head.getNext();
        }
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            int currentPosition = 0;
            while (temp != null) {
                if (currentPosition == position - 1) {
                    deleted = Node.copyNode(temp.getNext());
                    temp.setNext(temp.getNext().getNext());
                }
                temp = temp.getNext();
                currentPosition++;
            }
        }
        return deleted;
    }

    public int getLength() {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 1;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    public void print(){
        if (head == null) {
            System.out.println("[]");
        }else{
            Node temp = head;
            System.out.print("[ ");
            while (temp!= null) {
                System.out.print(" " + temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println(" ]");
        }

    }

    public void reverse() {
        Node current;
        Node temp;
        Node previous = null;
        current = head;
        while (current!= null) {
            temp = Node.copyNode(current.getNext());
            current.setNext(previous);

            previous = current;
            current = temp;
        }
        head = previous;
    }

}
