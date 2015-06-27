package MiscTopic;

import java.util.Date;
import java.util.Random;

/**
 * Created by aliHitawala on 4/4/14.
 */
public class SortLinkList {
    public static void main(String[] args) {
        LinkListController controller = new LinkListController();
        Node node = controller.getRandomList(40);
        controller.sort(node);
        controller.printList(node);
    }
}

//controller
class LinkListController
{
    public void printList(Node n)
    {
        while (n != null)
        {
            System.out.println(n.getData());
            n = n.getNext();
        }
    }

    public Node getRandomList(int length)
    {
        if (length > 0)
        {
            Date d = new Date();
            Random r = new Random(d.getTime() % 51);
            Node head = new Node(r.nextInt() % 1000);
            while (--length != 0)
            {
                this.insert(head, r.nextInt() % 1000);
            }
            return head;
        }
        return null;
    }

    int insert(Node head, int data)
    {
        if (head == null)
            return 1;
        else
        {
            Node temp = head;
            while (temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            Node newNode = new Node(data);
            temp.setNext(newNode);
            return 0;
        }
    }

    Node sort(Node head)
    {
        if (head == null || head.getNext() == null)
            return head;
        Node left = head;
        Node right = this.getMid(head);
        this.sort(left);
        this.sort(right);
        head = this.merge(left, right);
        return head;
    }

    private Node merge(Node left, Node right) {
        Node result;
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.getData() <= right.getData())
        {
            result = left;
            result.setNext(merge(left.getNext(), right));
        }
        else
        {
            result = right;
            result.setNext(merge(left, right.getNext()));
        }
        return result;
    }

    private Node getMid(Node head) {
        if (head == null || head.getNext() == null)
        {
            return null;
        }
        Node fast = head.getNext();
        Node slow = head;
        while (fast != null)
        {
            fast = fast.getNext();
            if (fast != null)
            {
                fast = fast.getNext();
                slow = slow.getNext();
            }
        }
        Node result = slow.getNext();
        slow.setNext(null);
        return result;
    }
}

//domain obj
class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
        next = null;
    }

    int getData()
    {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
