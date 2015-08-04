package Coding.DS;

/**
 * Created by aliHitawala on 7/28/15.
 */
public class Stack implements DataStructure {
    private int size;
    private Node top;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    @Override
    public int delete() {
        if (top == null) {
            throw new RuntimeException("Stack empty!");
        }
        size--;
        Node temp = top;
        top = top.getPrev();
        if (top != null) {
            temp.setPrev(null);
            top.setNext(null);
        }
        return temp.getData();
    }

    @Override
    public void insert(int data) {
        Node n = new Node(data);
        if (top != null) {
            top.setNext(n);
            n.setPrev(top);
        }
        top = n;
        size++;
    }

    @Override
    public int peek() {
        if (top == null)
            throw new RuntimeException("Stack empty!");
        return top.getData();
    }

    @Override
    public int size() {
        return size;
    }
}
