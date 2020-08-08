package leetcode.may_challenge.week3;

public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fl = head;
        ListNode sl = head.next;
        ListNode sHead = head.next;
        while (sl != null && sl.next != null) {
            ListNode slNext = sl.next;

            fl.next = slNext;
            sl.next = slNext.next;

            fl = fl.next;
            sl = sl.next;
            if (sl == null) {
                break;
            }
            slNext = sl.next;
        }

        fl.next = sHead;
        return head;
    }

}