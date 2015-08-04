package Coding.DS.LL;

/**
 * Created by aliHitawala on 7/31/15.
 */
public class RunnerIntersection {
    public static void main(String[] args) {
        LinkedList first = LinkedListHelper.newNode(1);
        first.setNext(LinkedListHelper.newNode(2));
        first.getNext().setNext(LinkedListHelper.newNode(3));
        first.getNext().getNext().setNext(LinkedListHelper.newNode(4));

        LinkedList first1 = LinkedListHelper.newNode(5);

        first.getNext().getNext().getNext().setNext(first1);

        first1.setNext(LinkedListHelper.newNode(6));
        first1.getNext().setNext(LinkedListHelper.newNode(7));
        first1.getNext().getNext().setNext(LinkedListHelper.newNode(8));

        LinkedList second = LinkedListHelper.newNode(10);
        second.setNext(LinkedListHelper.newNode(12));
        second.getNext().setNext(LinkedListHelper.newNode(13));
        second.getNext().getNext().setNext(LinkedListHelper.newNode(14));
        second.getNext().getNext().getNext().setNext(first.getNext().getNext());

        LinkedListHelper.printList(first);
        LinkedListHelper.printList(second);
        LinkedListHelper.printList(LinkedListHelper.findIntersection(first, second));
    }
}
