package com.gmail.alexei28.shortcut.algorithms.module2.task13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task13Test {

    private final Task13 task = new Task13();

    @Test
    @DisplayName("Разворот связанного списка из 5 элементов")
    void shouldReverseListWithFiveElements() {
        // Создаем связанный список: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = createLinkedList(1, 2, 3, 4, 5);

        ListNode actual = task.reverseList(head);

        // Проверяем значения: 5 -> 4 -> 3 -> 2 -> 1
        assertThat(actual.val).isEqualTo(5);
        assertThat(actual.next.val).isEqualTo(4);
        assertThat(actual.next.next.val).isEqualTo(3);
        assertThat(actual.next.next.next.val).isEqualTo(2);
        assertThat(actual.next.next.next.next.val).isEqualTo(1);
        assertThat(actual.next.next.next.next.next).isNull();
    }

    @Test
    @DisplayName("Разворот связанного списка из 1 элемента")
    void shouldReturnSameNodeWhenListHasOneElement() {
        ListNode head = new ListNode(1);

        ListNode actual = task.reverseList(head);

        assertThat(actual).isNotNull();
        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.next).isNull();
    }

    @Test
    @DisplayName("Передача null в качестве головы связанного списка")
    void shouldReturnNullWhenHeadIsNull() {
        ListNode actual = task.reverseList(null);

        assertThat(actual).isNull();
    }

    @Test
    @DisplayName("Проверка пустого связанного списка (синоним null в ListNode)")
    void shouldReturnNullWhenEmptyList() {
        // В данной реализации ListNode пустой связанный список обычно представлен как null
        ListNode head = null;

        ListNode actual = task.reverseList(head);

        assertThat(actual).isNull();
    }

    // Вспомогательный метод для удобного создания связанного списка
    private ListNode createLinkedList(int... values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}