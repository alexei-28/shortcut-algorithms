package com.gmail.alexei28.shortcut.algorithms.module2.task19;

/*
    Задание 19: Reverse Linked List II [Medium]
    Источник: https://leetcode.com/problems/reverse-linked-list-ii/

    Разворот части связного списка от позиции left до позиции right (1-indexed).
    Пример:
    Вход:  1 → 2 → 3 → 4 → 5, left = 2, right = 4
    Выход: 1 → 4 → 3 → 2 → 5

    Требования:
    - Сложность: O(n)
    - Память: O(1)

    Подсказка: Это расширение базового разворота списка (задание 13).
    Найдите узел перед позицией left, разверните часть от left до right, затем аккуратно соедините развернутую часть с остальным списком.

    Решение:
    1. Временная сложность (Time Complexity): O(N)
       Алгоритм работает за линейное время, где N — количество узлов в списке.
       - Первый цикл while (поиск границ): Проходим по списку от головы до узла на позиции right.
         В худшем случае (когда right находится в самом конце списка) этот цикл совершит N итераций. Это дает  O(N).
       - Второй цикл while (в методе reverseList): Здесь происходит разворот подсписка. Количество итераций строго равно count,
         что эквивалентно right - left + 1. В худшем случае (разворот всего списка) этот цикл совершит N итераций. Это дает еще O(N).
       Поскольку эти шаги выполняются последовательно, а не вложенно, общая временная сложность составляет O(N) + O(N) = O(2N),
       что в терминах Big O сокращается до O(N).

    2. Пространственная сложность (Space Complexity): O(1)
       Алгоритм использует константное количество дополнительной памяти.
       - Создаем только несколько указателей (prevLeftNode, nextRightNode, currentNode, reverseList, nextNode) и примитивных переменных
         для счетчиков (currentIndex, currentCount).
       - Память под эти переменные не зависит от размера входного списка N.
       - Перестановка узлов происходит "in-place" (на месте) — просто меняем направления существующих ссылок .next, не создавая новых узлов.
       Следовательно, пространственная сложность идеальна — O(1) (константная)
*/
public class Task19 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prevLeftNode = head;
        ListNode nextRightNode = null;
        ListNode currentNode = head;
        int currentIndex = 1;
        while (currentNode != null) {
            if (currentIndex == left - 1) {
                prevLeftNode = currentNode;
            }
            if (currentIndex == right) {
                nextRightNode = currentNode.next;
                break;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }
        ListNode reverseList = null;
        if (left == 1) {
            reverseList = reverseList(head, right - left + 1, nextRightNode);
        } else {
            reverseList = reverseList(prevLeftNode.next, right - left + 1, nextRightNode);
        }
        if (left == 1 && currentIndex == right) {
            return reverseList;
        }
        prevLeftNode.next = reverseList;
        return head;
    }

    private ListNode reverseList(ListNode leftNode, int count, ListNode tail) {
        if (leftNode == null) {
            return leftNode;
        }
        int currentCount = 0;
        ListNode reverseList = tail;
        ListNode currentNode = leftNode;
        while (currentNode != null) {
            if (currentCount == count) {
                break;
            }
            ListNode nextNode = currentNode.next;
            currentNode.next = reverseList; // Меняем ссылку
            currentCount++;

            // Двигаем указатели
            reverseList = currentNode;
            currentNode = nextNode;
        }
        return reverseList;
    }
}
