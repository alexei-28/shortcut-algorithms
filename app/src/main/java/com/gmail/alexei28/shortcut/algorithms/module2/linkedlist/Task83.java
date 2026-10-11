package com.gmail.alexei28.shortcut.algorithms.module2.linkedlist;

/*
    83. Remove Duplicates from Sorted List [Easy]
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

    Given the head of a sorted linked list, delete all duplicates such that each element
    appears only once. Return the linked list sorted as well.

    Example 1:
    Input: head = [1,1,2]
    Output: [1,2]

    Example 2:
    Input: head = [1,1,1,2,3,3]
    Output: [1,2,3]

*/
public class Task83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode left = head;
            ListNode right = head.next;
            while (right != null) {
                if (left.val != right.val) {
                    left.next = right;
                    left = left.next;
                }
                right = right.next;
            }
            left.next = null;
            return head;
        }
    }

    public static class ListNode {
        int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
