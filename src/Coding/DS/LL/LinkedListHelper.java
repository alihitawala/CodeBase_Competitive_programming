package Coding.DS.LL;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;

/**
 * Created by aliHitawala on 7/24/15.
 */
public class LinkedListHelper {
    public static LinkedList newNode(int data) {
        return new LinkedList(data);
    }

    public static LinkedList newList(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return null;
        }
        LinkedList head = newNode(a.get(0));
        LinkedList temp = head;
        for (int i=1;i<a.size();i++) {
            LinkedList node = newNode(a.get(i));
            temp.setNext(node);
            temp = node;
        }
        return head;
    }

    public static void printList(LinkedList head) {
        while(head != null) {
            System.out.print(head.getData() + "-->");
            head = head.getNext();
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static int length(LinkedList list) {
        int result = 0;
        while (list != null){
            result++;
            list=list.getNext();
        }
        return result;
    }

    public static LinkedList mergeAlternate(LinkedList a, LinkedList b) {
        if (a == null) return b;
        if (b == null) return a;
        LinkedList t = mergeAlternate(a.getNext(), b.getNext());
        a.setNext(b);
        b.setNext(t);
        return a;
    }

    public static LinkedList reverse(LinkedList head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        LinkedList temp = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return temp;
    }

    public static ArrayList<LinkedList> split(LinkedList a) {
        ArrayList<LinkedList> result = new ArrayList<LinkedList>();
        if (a == null || a.getNext() == null) {
            result.add(a);
            result.add(null);
            return result;
        }
        LinkedList p = a;
        LinkedList q = a.getNext();
        result.add(p);
        result.add(q);
        while (p.getNext() != null && q.getNext() != null) {
            p.setNext(q.getNext());
            q.setNext(p.getNext().getNext());
            p = p.getNext();
            q = q.getNext();
        }
        if (p.getNext() != null){
            p.setNext(null);
        }
        return result;
    }

    public static LinkedList sortedInsert(LinkedList head, LinkedList node) {
        int data = node.getData();
        if (head == null || head.getData() > data) {
            node.setNext(head);
            return node;
        }
        LinkedList temp = head;
        while (temp.getNext() != null && temp.getNext().getData() <= data) {
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
        return head;
    }

    public static LinkedList insertAtPosition(LinkedList head, int val, int position) {
        LinkedList node = newNode(val);
        if (position == 0) {
            node.setNext(head);
            return node;
        }
        if (position > length(head))
            throw new RuntimeException("List's length is smaller than the position being inserted!");
        LinkedList t = head;
        for (int i=0;i<position-1;i++) {
            head=head.getNext();
        }
        node.setNext(head.getNext());
        head.setNext(node);
        return t;
    }

    public static LinkedList insertSort(LinkedList list) {
        LinkedList result = null;
        LinkedList tempPointer;
        while (list != null) {
            tempPointer = list.getNext();
            result = sortedInsert(result, list);
            list = tempPointer;
        }
        return result;
    }

    public static ArrayList<LinkedList> frontBackSplit(LinkedList list) {
        ArrayList<LinkedList> result = new ArrayList<LinkedList>();
        result.add(list);
        if (list == null || list.getNext() == null) {
            result.add(null);
            return result;
        }
        LinkedList slow = list, fast = list.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        result.add(slow.getNext());
        slow.setNext(null);
        return result;
    }

    public static LinkedList middleElement(LinkedList list) {
        if (list == null || list.getNext() == null)
            return list;
        LinkedList slow = list;
        LinkedList fast = list.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static LinkedList rotateList(LinkedList list, int n) {
        if (n < 0)
            throw new RuntimeException("n cannot be negative");
        int rotate = n % length(list);
        if (rotate == 0)
            return list;
        LinkedList lastNth = lastNthNode(list, rotate+1);
        if (lastNth == null)
            throw new RuntimeException("List size is smaller than expected");
        LinkedList lastNode = lastNode(list);
        lastNode.setNext(list);
        LinkedList newHead = lastNth.getNext();
        lastNth.setNext(null);
        return newHead;
    }

    private static LinkedList lastNode(LinkedList list) {
        if (list == null)
            return null;
        while (list.getNext() != null)
            list = list.getNext();
        return list;
    }

    private static LinkedList lastNthNode(LinkedList list, int n) {
        if (list == null)
            return null;
        if (n == 1) return list;
        LinkedList slow = list;
        LinkedList fast = list;
        for (int i=0;i<n;i++) {
            if (fast!=null) {
                fast = fast.getNext();
            }
            else {
                return null;
            }
        }
        while(fast!=null) {
            slow=slow.getNext();
            fast=fast.getNext();
        }
        return slow;
    }

    public static LinkedList removeDuplicates(LinkedList list) {
        if (list == null || list.getNext() == null)
            return list;
        LinkedList p1 = list;
        LinkedList p2 = list.getNext();
        while (p1 != null && p2 != null) {
            while (p2 != null && p1.getData() == p2.getData()) {
                LinkedList next = p2.getNext();
                deleteNext(p1);
                p2 = next;
            }
            if (p2 == null)
                break;
            p2 = p2.getNext();
            p1 = p1.getNext();
        }
        return list;
    }

    private static void deleteNext(LinkedList p) {
        if (p.getNext() != null) {
            LinkedList temp = p.getNext();
            p.setNext(temp.getNext());
            temp.setNext(null);
        }
    }

    public static LinkedList sortedMerge(LinkedList a, LinkedList b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        LinkedList result;
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(),b));
        }
        else {
            result = b;
            result.setNext(sortedMerge(a,b.getNext()));
        }
        return result;
    }

    public static LinkedList mergeSort(LinkedList list) {
        if (list == null || list.getNext() == null)
            return list;
        ArrayList<LinkedList> split = frontBackSplit(list);
        LinkedList a = mergeSort(split.get(0));
        LinkedList b = mergeSort(split.get(1));
        list = sortedMerge(a,b);
        return list;
    }

    public static LinkedList sortedIntersect(LinkedList a, LinkedList b) {
        if (a == null || b == null)
            return null;
        LinkedList result = null;
        if (a.getData() == b.getData()) {
            result = newNode(a.getData());
            result.setNext(sortedIntersect(a.getNext(), b.getNext()));
        } else if (a.getData() < b.getData()) {
            result = sortedIntersect(a.getNext(), b);
        } else {
            result = sortedIntersect(a, b.getNext());
        }
        return result;
    }

    public static LinkedList deleteLastNthNode(LinkedList list, int n) {
        if (list == null || n < 1)
            return list;
        LinkedList fast = list;
        int i;
        for (i=0;i<n && fast != null;i++) {
            fast = fast.getNext();
        }
        if (fast == null && i < n)
            throw new RuntimeException("Invalid n");
        else if (fast == null) {
            LinkedList temp = list;
            list = list.getNext();
            temp.setNext(null);
        }
        else {
            LinkedList t = list;
            while (fast.getNext() != null) {
                fast = fast.getNext();
                t=t.getNext();
            }
            deleteNext(t);
        }
        return list;
    }

    public static LinkedList findIntersection(LinkedList first, LinkedList second) {
        int l1 = length(first);
        int l2 = length(second);
        if (l1 > l2) {
            int diff = l1-l2;
            while (first != null && diff != 0) {
                first = first.getNext();
                diff--;
            }
        }
        else if (l2 > l1) {
            int diff = l2-l1;
            while (second != null && diff != 0) {
                second = second.getNext();
                diff--;
            }
        }
        while (first != null && second != null && first != second) {
            first = first.getNext();
            second = second.getNext();
        }
        if (first == null || second == null)
            throw new RuntimeException("No intersection found!");
        return newNode(first.getData());
    }
 }