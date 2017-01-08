/**
 * Created by Sasanka on 6/1/2015.
 */
public class Node {
    private Integer value;
    private Node next;

    public Node(){
        //
    }

    public Node(Integer value) {
        this.value = value;
    }

    public static Node copyNode(Node sourceNode) {
        if (sourceNode == null) {
            return null;
        }
        Node newNode = new Node();
        newNode.setValue(sourceNode.value);
        newNode.setNext(sourceNode.getNext());

        return newNode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
