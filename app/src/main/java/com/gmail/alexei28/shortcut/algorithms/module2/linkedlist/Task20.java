package com.gmail.alexei28.shortcut.algorithms.module2.linkedlist;

/*
     141. Linked List Cycle [Easy]
     https://leetcode.com/problems/linked-list-cycle/description/?utm_source=chatgpt.com

     Given head, the head of a linked list, determine if the linked list has a cycle in it.
     There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
     Internally, "pos" is used to denote the index of the node that tail's next pointer is connected to.
     Note that "pos" is not passed as a parameter.

     Return true if there is a cycle in the linked list. Otherwise, return false.

     Example 1:
     Input: head = [3,2,0,-4], pos = 1
     Output: true
     Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

     Example 2:
     Input: head = [1,2], pos = 0
     Output: true
     Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

     Example 3:
     Input: head = [1], pos = -1
     Output: false
     Explanation: There is no cycle in the linked list.

     Решение:
     Временная сложность (Time Complexity): O(N)
     Где N — количество узлов в связном списке.
     - Если цикла нет: Быстрый указатель (nextOfNext) дойдет до конца списка за N/2 шагов.
       Это дает линейное время O(N).
     - Если цикл есть: Оба указателя попадут внутрь цикла. В худшем случае расстояние между ними внутри цикла не превышает
       длину самого цикла. Поскольку быстрый указатель приближается к медленному на 1 узел за каждый шаг, они обязательно встретятся
       максимум за K шагов, где K — длина цикла (K <= N). Общее время работы останется линейным — O(N).

     Пространственная сложность: O(1)
     Алгоритм использует фиксированное количество дополнительной памяти.
     - Выделяется память только под две переменные-указателя (current и nextOfNext).
     - Количество используемой памяти никак не зависит от размера списка N, так как узлы не копируются и дополнительные структуры данных
       (вроде HashSet) не создаются. Это называется константной пространственной сложностью.
*/
public class Task20 {

    public boolean hasCycle(ListNode head) {
        if (head != null) {
            ListNode current = head;
            ListNode nextOfNext = current;
            while (nextOfNext.next != null && nextOfNext.next.next != null) {
                nextOfNext = nextOfNext.next.next;
                current = current.next;
                if (current == nextOfNext) {
                    return true;
                }
            }
        }
        return false;
    }
}
