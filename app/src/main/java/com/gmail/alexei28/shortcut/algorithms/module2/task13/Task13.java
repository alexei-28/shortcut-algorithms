package com.gmail.alexei28.shortcut.algorithms.module2.task13;

/*
    Задание 13: Reverse Linked List [Easy]
    Источник: https://leetcode.com/problems/reverse-linked-list/
    Разверните связный список (поменять порядок узлов на обратный).
    Пример:
        Вход:  1 → 2 → 3 → 4 → 5
        Выход: 5 → 4 → 3 → 2 → 1

    Требования:
    - Сложность: O(n)
    - Память: O(1) — разворот должен быть in-place

    Подсказка: Используйте три указателя: prev, current, next.
    В каждой итерации сохраняйте next, меняйте ссылку current.next на prev, и сдвигайте указатели вперед.
*/
public class Task13 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        current.next = prev;
        return current;
    }
}
