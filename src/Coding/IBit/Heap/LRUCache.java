package Coding.IBit.Heap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alihitawala on 9/4/15.
 */
public class LRUCache {
    public static void main(String[] args) {
        Solution s = new Solution(4);
//        s.set(1, 10);
//        s.set(5, 12);
//        System.out.println(s.get(5));       // returns 12
//
//        System.out.println(s.get(1));       //returns 10
//
//        System.out.println(s.get(10));      //returns -1
//        s.set(6, 14);    //this pushes out key = 5 as LRU is full.
//
//        System.out.println(s.get(5));
//        System.out.println(s.get(1));
//        System.out.println(s.get(6));
        //6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
//        s.set(2,1);
//        s.set(1,1);
//        s.set(2,3);
//        s.set(4,1);
//        System.out.println(s.get(1));
//        System.out.println(s.get(2));
        //32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3
        s.set(5,13);
        s.set(9,6);
        s.set(4,1);
        System.out.println(s.get(4));
        s.set(6, 1);
        s.set(8, 11);
        System.out.println(s.get(13));
        System.out.println(s.get(1));
        s.set(12, 12);
        System.out.println(s.get(10));
    }

}
class Solution {
    private Map<Integer, DoublyLinkList> map;
    private int capacity;
    private DoublyLinkList head;
    private DoublyLinkList tail;
    private int count;

    public Solution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
        count = 0;
    }

    public int get(int key) {
        if (head != null) {
            if (map.containsKey(key)) {
                DoublyLinkList temp = map.get(key);
                nodeTouched(temp);
                return temp.val;
            }
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkList temp = map.get(key);
            temp.val = value;
            nodeTouched(temp);
        }
        else {
            DoublyLinkList newNode = new DoublyLinkList();
            newNode.key = key;
            newNode.val = value;
            newNode.next = head;
            map.put(key, newNode);
            if (head == null)
                tail = newNode;
            else
                head.prev = newNode;
            head = newNode;
            count++;

            if (count > capacity) {
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                count--;
            }
        }
    }

    private void nodeTouched(DoublyLinkList temp) {
        if (temp != head) {
            if (temp == tail && temp.prev != null)
                tail = temp.prev;
            if (temp.prev != null)
                temp.prev.next = temp.next;
            if (temp.next != null)
                temp.next.prev = temp.prev;
            temp.next = head;
            temp.prev = null;
            head = temp;
            if (head.next == null)
                tail = head;
            else
                head.next.prev = head;
        }
    }
    static class DoublyLinkList {
        int key;
        int val;
        DoublyLinkList next;
        DoublyLinkList prev;
    }
}
