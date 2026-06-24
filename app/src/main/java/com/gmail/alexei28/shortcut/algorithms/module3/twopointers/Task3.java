package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

/*
    19. Remove Nth Node From End of List [Easy]
    Source: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    Given the head of a linked list, remove the nth node from the end of the list and return
    its head.

    Решение:
    Сложность:
    Время: O(n) — проходим список один раз
    Память: O(1) — используем только два указателя и фиктивный узел

*/
public class Task3 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Создаём фиктивный узел для упрощения удаления первого элемента
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Двигаем fast на n+1 позиций вперёд
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Двигаем оба указателя, пока fast не достигнет конца
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Удаляем узел после slow
        slow.next = slow.next.next;
        return dummy.next;
    }
}
