package Coding.DS;

/**
 * Created by aliHitawala on 8/6/15.
 */
public class CircularLinkList {
    private int data;
    private CircularLinkList next;

    public CircularLinkList(int data) {
        this.data = data;
        next = this;
    }

    public void printList() {
        CircularLinkList cur = this;
        do {
            System.out.print(cur.data + "-->");
            cur = cur.next;
        } while (cur != this);
        System.out.print("NULL");
        System.out.println();
    }

    private static CircularLinkList insert(CircularLinkList head, int value) {
        if (head == null)
            return new CircularLinkList(value);
        if (head.next == head) //single element
        {
            head.next = new CircularLinkList(value);
            head.next.next = head;
            return head.data < value ? head : head.next;
        }
        if (value < head.data) {
            CircularLinkList cur = head;
            while (cur.next != head) {
                cur = cur.next;
            }
            cur.next = new CircularLinkList(value);
            cur.next.next = head;
            return cur.next;
        }
        CircularLinkList temp = head;
        while (temp.next != head && temp.next.data <= value) {
            temp = temp.next;
        }
        CircularLinkList tempNext = temp.next;
        temp.next = new CircularLinkList(value);
        temp.next.next = tempNext;
        return head;
    }

    public static void main(String[] args) {
        CircularLinkList t1 = insert(insert(insert(null, 9), 8), 10);
        t1.printList();
        t1 = insert(t1, 11);
        t1.printList();
        t1 = insert(t1, 1);
        t1.printList();
        t1 = insert(t1, 2);
        t1.printList();
        t1 = insert(t1, 5);
        t1.printList();
    }
}
