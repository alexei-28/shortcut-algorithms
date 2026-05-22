package com.gmail.alexei28.shortcut.algorithms.module2.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task19Test {
    private final Task19 task19 = new Task19();

    @Test
    void reverseBetween_StandardCase_ReversesMiddlePart() {
        // Arrange
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6,7});
        int left = 4;
        int right = 6;
        int[] expected = {1, 2, 3, 6, 5, 4, 7};

        // Act
        ListNode result = task19.reverseBetween(head, left, right);

        // Assert
        assertThat(listToArray(result)).isEqualTo(expected);
    }

    @Test
    void reverseBetween_EntireList_ReversesAllElements() {
        // Arrange
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int left = 1;
        int right = 5;
        int[] expected = {5, 4, 3, 2, 1};

        // Act
        ListNode result = task19.reverseBetween(head, left, right);

        // Assert
        assertThat(listToArray(result)).isEqualTo(expected);
    }

    @Test
    void reverseBetween_SingleElementList_ReturnsSameList() {
        // Arrange
        ListNode head = createList(new int[]{1});
        int left = 1;
        int right = 1;
        int[] expected = {1};

        // Act
        ListNode result = task19.reverseBetween(head, left, right);

        // Assert
        assertThat(listToArray(result)).isEqualTo(expected);
    }

    @Test
    void reverseBetween_LeftEqualsRight_NoChanges() {
        // Arrange
        ListNode head = createList(new int[]{1, 2, 3});
        int left = 2;
        int right = 2;
        int[] expected = {1, 2, 3};

        // Act
        ListNode result = task19.reverseBetween(head, left, right);

        // Assert
        assertThat(listToArray(result)).isEqualTo(expected);
    }

    @Test
    void reverseBetween_StartsFromHead_ReversesCorrectly() {
        // Arrange
        ListNode head = createList(new int[]{1, 2, 3, 4});
        int left = 1;
        int right = 3;
        int[] expected = {3, 2, 1, 4};

        // Act
        ListNode result = task19.reverseBetween(head, left, right);

        // Assert
        assertThat(listToArray(result)).isEqualTo(expected);
    }

    @Test
    void reverseBetween_EndsAtTail_ReversesCorrectly() {
        // Arrange
        ListNode head = createList(new int[]{1, 2, 3, 4});
        int left = 2;
        int right = 4;
        int[] expected = {1, 4, 3, 2};

        // Act
        ListNode result = task19.reverseBetween(head, left, right);

        // Assert
        assertThat(listToArray(result)).isEqualTo(expected);
    }

    // Вспомогательный метод для создания связанного списка из массива чисел
    private ListNode createList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Вспомогательный метод для преобразования списка в массив для удобного Assert
    private int[] listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}