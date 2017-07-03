package problems;

import java.util.*;

/**
 * Created by sasanka on 5/19/17.
 */
class Element<T> {
    private T value;
    private Element<T> next;

    public Element(T val) {
        this.value = val;
    }

    public Element<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}

class MyList<T> {
    private Element<T> head;
    private int maxSize;

    public MyList(int size) {
        this.maxSize = size;
    }

    public void add(Element<T> e) {
        if (head == null) {
            this.head = e;
        } else {
            e.setNext(head);
            head = e;
        }
    }

    public void remove(Element<T> e) {
        if (e == head) {
            this.head = e.getNext();
        } else {
            Element<T> c = head;
            while (c != null) {
                if (c.getNext() == e) {
                    c.setNext(e.getNext());
                }
                c = c.getNext();
            }
        }
    }

    public void print() {
        Element<T> c = this.head;
        while (c != null) {
            System.out.print(" " + c.getValue() + " ");
            c = c.getNext();
        }
    }

    public void cutOff() {
        Element<T> c = head;
        for (int i = 1; i < this.maxSize; i++) {
            c = c.getNext();
        }
        c.setNext(null);
    }
}

public class LRUCache {
    private int size;
    private MyList<Integer> list;
    private HashMap<Integer, Element<Integer>> map;

    public LRUCache(int size) {
        this.size = size;
        this.list = new MyList<>(size);
        this.map = new HashMap<>();
    }

    public void add(Integer i) {
        Element<Integer> e = new Element<>(i);
        Element<Integer> existingElement = map.get(i);
        if (existingElement != null) {
            list.remove(existingElement);
            map.remove(i);
        }

        list.add(e);
        map.put(i, e);

        if (map.size() > size) {
            list.cutOff();
        }

    }

    public void retrieve() {
        this.list.print();
    }

    // 1 2 3 4 5 4 6
    // With a size of 4, the LRU cache in the end must contain:
    //      6453
    // Steps:
    // 4 3 2 1
    // 5 4 3 2
    // 4 5 3 2
    // 6 4 5 3
    public static void main(String args[]) {
        LRUCache l = new LRUCache(4);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(4);
        l.add(6);

        l.retrieve();
    }
}
