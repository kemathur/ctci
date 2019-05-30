package com.keshav.ctci.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode tail = null;
        int val, carry = 0;

        while (l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;
            carry = val/10;
            val %= 10;
            ListNode next = new ListNode(val);
            if (head == null) {
                head = next;
            }
            else {
                tail.next = next;
            }
            tail = next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            val = l1.val + carry;
            carry = val/10;
            val %= 10;
            tail.next = new ListNode(val);
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 != null) {
            val = l2.val + carry;
            carry = val/10;
            val %= 10;
            tail.next = new ListNode(val);
            l2 = l2.next;
            tail = tail.next;
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }

        return head;
    }
}