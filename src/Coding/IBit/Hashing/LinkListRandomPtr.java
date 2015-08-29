package Coding.IBit.Hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliHitawala on 8/28/15.
 */
public class LinkListRandomPtr {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode temp = head;
        RandomListNode newHead = copyList(head);
        RandomListNode newTemp = newHead;
        while (temp != null) {
            RandomListNode nextNode = temp.next;
            temp.next = newTemp;
            newTemp.random = temp;
            temp = nextNode;
            newTemp = newTemp.next;
        }
        newTemp = newHead;
        ArrayList<RandomListNode> list = new ArrayList<>();
        while (newTemp != null) {
            if (newTemp.random.random == null)
                list.add(null);
            else
                list.add(newTemp.random.random.next);
            newTemp = newTemp.next;
        }
        newTemp = newHead;
        while (newTemp.next != null) {
            newTemp.random.next = newTemp.next.random;
            newTemp = newTemp.next;
        }
        newTemp.random.next = null;
        newTemp = newHead;
        int i=0;
        while (newTemp != null) {
            newTemp.random = list.get(i++);
            newTemp = newTemp.next;
        }
        return newHead;
    }

    private RandomListNode copyList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode temp = newHead;
        head = head.next;
        while (head != null) {
            temp.next = new RandomListNode(head.label);
            temp = temp.next;
            head = head.next;
        }
        return newHead;
    }
}
//*
// * Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }

    public static RandomListNode getList(List<Integer> list) {
        RandomListNode head = new RandomListNode(list.get(0));
        RandomListNode prev = head;
        for (int i = 1; i < list.size(); i++) {
            RandomListNode node = new RandomListNode(list.get(i));
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public static void print(RandomListNode listNode) {
        while (listNode != null)
        {
            System.out.print(listNode.label + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
};
