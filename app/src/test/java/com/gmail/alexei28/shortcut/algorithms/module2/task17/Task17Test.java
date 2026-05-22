package com.gmail.alexei28.shortcut.algorithms.module2.task17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task17Test {

    private Task17 task;

    @BeforeEach
    void setUp() {
        task = new Task17();
    }

    @Test
    @DisplayName("Should remove middle node from the end")
    void shouldRemoveMiddleNodeFromEnd() {
        // Given: 1 -> 2 -> 3 -> 4 -> 5, n = 2
        ListNode head = createLinkedList(1, 2, 3, 4, 5);
        int n = 2;

        // When
        ListNode result = task.removeNthFromEnd(head, n);

        // Then: 1 -> 2 -> 3 -> 5
        assertThat(toList(result)).isEqualTo(List.of(1, 2, 3, 5));
    }

    @Test
    @DisplayName("Should remove the only node in the list")
    void shouldRemoveOnlyNode() {
        // Given: 1, n = 1
        ListNode head = createLinkedList(1);
        int n = 1;

        // When
        ListNode result = task.removeNthFromEnd(head, n);

        // Then: Empty list
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("Should remove the head node (first node from the front)")
    void shouldRemoveHeadNode() {
        // Given: 1 -> 2, n = 2 (removes 1)
        ListNode head = createLinkedList(1, 2);
        int n = 2;

        // When
        ListNode result = task.removeNthFromEnd(head, n);

        // Then: 2
        assertThat(toList(result)).isEqualTo(List.of(2));
    }

    @Test
    @DisplayName("Should remove the last node (1st node from the end)")
    void shouldRemoveLastNode() {
        // Given: 1 -> 2, n = 1 (removes 2)
        ListNode head = createLinkedList(1, 2);
        int n = 1;

        // When
        ListNode result = task.removeNthFromEnd(head, n);

        // Then: 1
        assertThat(toList(result)).isEqualTo(List.of(1));
    }

    // --- Helper Methods for Setup and Assertions ---

    private ListNode createLinkedList(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }
}