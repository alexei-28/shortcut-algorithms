package com.gmail.alexei28.shortcut.algorithms.module2.task17;

/*
    Задание 17: Remove Nth Node From End of List [Medium]
    Источник: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    Удалите n-й узел с конца связного списка. Верните голову списка.

    Пример:
    Вход:  1 → 2 → 3 → 4 → 5, n = 2
    Выход: 1 → 2 → 3 → 5

    Вход:  1 → 2, n = 2
    Выход: 2

    Требования:
    - Сложность: O(n)
    - Память: O(1)
*/
public class Task17 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Считаем длину списка
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int findIndex = length - n;
        // Крайний случай: если нужно удалить самый первый узел
        if (findIndex == 0) {
            return head.next;
        }

        // 2. Идем до узла, который стоит ПЕРЕД удаляемым
        ListNode curr = head;
        for (int i = 0; i < findIndex - 1; i++) {
            curr = curr.next;
        }

        // Перебрасываем ссылку через один узел (удаляем n-й с конца)
        curr.next = curr.next.next;

        return head;
    }
}
