package Coding.DS.LL;

/**
 * Created by aliHitawala on 7/24/15.
 */
public class LinkedList {
    private LinkedList next;
    private int data;

    public LinkedList(int data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
