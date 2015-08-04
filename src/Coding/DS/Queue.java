package Coding.DS;

/**
 * Created by aliHitawala on 7/28/15.
 */
public class Queue implements DataStructure{
    private int size;
    private Node head;
    private Node tail;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int delete() {
        if (head == null)
            throw new RuntimeException("Queue empty!");
        size--;
        Node temp = head;
        head = head.getNext();
        if (head != null) {
            temp.setNext(null);
            head.setPrev(null);
        }
        else {
            tail = null;
        }
        return temp.getData();
    }

    @Override
    public void insert(int data) {
        Node n = new Node(data);
        if (tail == null) {
            head = tail = n;
        }
        else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        size++;
    }

    @Override
    public int peek() {
        if (head == null)
            throw new RuntimeException("Queue empty!");
        return head.getData();
    }

    @Override
    public int size() {
        return this.size;
    }
}
