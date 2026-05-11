package com.gmail.alexei28.shortcut.algorithms.module2.task13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task13Test {

    private final Task13 task = new Task13();

    @Test
    @DisplayName("Разворот списка из 5 элементов")
    void shouldReverseListWithFiveElements() {
        // Создаем список: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = createList(1, 2, 3, 4, 5);

        ListNode result = task.reverseList(head);

        // Проверяем значения: 5 -> 4 -> 3 -> 2 -> 1
        assertThat(result.val).isEqualTo(5);
        assertThat(result.next.val).isEqualTo(4);
        assertThat(result.next.next.val).isEqualTo(3);
        assertThat(result.next.next.next.val).isEqualTo(2);
        assertThat(result.next.next.next.next.val).isEqualTo(1);
        assertThat(result.next.next.next.next.next).isNull();
    }

    @Test
    @DisplayName("Разворот списка из 1 элемента")
    void shouldReturnSameNodeWhenListHasOneElement() {
        ListNode head = new ListNode(1);

        ListNode result = task.reverseList(head);

        assertThat(result).isNotNull();
        assertThat(result.val).isEqualTo(1);
        assertThat(result.next).isNull();
    }

    @Test
    @DisplayName("Передача null в качестве головы списка")
    void shouldReturnNullWhenHeadIsNull() {
        ListNode result = task.reverseList(null);

        assertThat(result).isNull();
    }

    @Test
    @DisplayName("Проверка пустого списка (синоним null в ListNode)")
    void shouldReturnNullWhenEmptyList() {
        // В данной реализации ListNode пустой список обычно представлен как null
        ListNode head = null;

        ListNode result = task.reverseList(head);

        assertThat(result).isNull();
    }

    // Вспомогательный метод для удобного создания связанного списка
    private ListNode createList(int... values) {
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