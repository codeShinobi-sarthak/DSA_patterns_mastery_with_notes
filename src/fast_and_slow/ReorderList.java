package fast_and_slow;

import fast_and_slow.ListNode;

//! Link : https://leetcode.com/problems/reorder-list/

public class ReorderList {
    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode list1 = head;
        ListNode list2 = reverseList(slow);


// ! one way
//        while (list2 != null) {
//            ListNode nextNode = list1.next;
//            list1.next = list2;
//            list1 = list2;
//            list2 = nextNode;
//        }


        while(list1 != null){
            ListNode n1 = list1.next;
            ListNode n2 = list2.next;

            list1.next = list2;

            if(n1 == null) break;

            list2.next = n1;
            list1 = n1;
            list2 = n2;

        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
