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

    Временная сложность: O(n)
     - Почему: Проходим по списку ровно один раз. Цикл while посещает каждый узел ровно по одному разу, выполняя внутри операции
       за константное время (перекладывание ссылок).
     - Здесь n — это количество узлов в списке. Больше узлов — пропорционально больше времени, никакой магии.

    Пространственная сложность: O(1)
     - Почему: Не создается никаких дополнительных структур данных (массивов, списков или стеков), размер которых рос бы вместе
       с входными данными.
     - Используется всего три переменные-указателя (prev, current, next), которые занимают фиксированный объем памяти независимо от того,
       10 узлов в списке или 10 миллионов.
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
