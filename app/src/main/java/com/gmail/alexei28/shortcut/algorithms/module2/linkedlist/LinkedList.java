package com.gmail.alexei28.shortcut.algorithms.module2.linkedlist;

/*
    Задание 20: Реализация связного списка [Medium]
    Реализуйте связный список с операциями:
    - Добавление в конец
    - Удаление по значению
    - Поиск значения
    - Разворот списка

    Требования:
    - Все операции должны быть корректными с точки зрения сложности
    - Разворот списка: O(n) время, O(1) память
    - Оформите решение как класс с методами

    Подсказка: Создайте класс LinkedList с методами append, delete, search, reverse.
    Для разворота используйте три указателя: prev, current, next. Проходите по списку и меняйте ссылки в обратном направлении.

    Решение:
    | Метод   | Время | Память |
    | ------- | ----- | ------ |
    | append  | O(1)  | O(1)   |
    | delete  | O(n)  | O(1)   |
    | search  | O(n)  | O(1)   |
    | reverse | O(n)  | O(1)   |

*/
public class LinkedList {
    private ListNode head;
    private ListNode tail;

    public void append(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }
        // цепляем к хвосту
        tail.next = newNode;
        // двигаем tail
        tail = tail.next;
    }

    public boolean delete(int value) {
        ListNode current = head;
        ListNode prev = head;
        while (current != null) {
            if (current.val == value) {
                if (head.val == value) {
                    head = current.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    prev.next = current.next;
                    if (prev.next == null) {
                        tail = prev;
                    }
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public ListNode search(int value) {
        ListNode current = head;
        while (current != null) {
            if (current.val == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public LinkedList reverse() {
        if (head == null) {
            return null;
        }
        ListNode headOfReverseList = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = headOfReverseList; // Меняем ссылку

            // Двигаем указатели
            headOfReverseList = current;
            current = next;
        }
        tail = head;
        head = headOfReverseList;
        return this;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTail() {
        return tail;
    }
}
