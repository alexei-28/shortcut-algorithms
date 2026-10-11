package com.gmail.alexei28.shortcut.algorithms.module2.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task83Test {

    private final Task83.Solution solution = new Task83().new Solution();

    @Test
    @DisplayName("Should remove duplicates from a sorted list with multiple duplicates")
    void shouldRemoveDuplicatesWhenMultipleDuplicatesExist() {
        // Arrange
        Task83.ListNode head = fromArray(1, 1, 1, 2, 3, 3);

        // Act
        Task83.ListNode result = solution.deleteDuplicates(head);

        // Assert
        assertThat(toList(result)).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("Should handle a list with simple duplicates")
    void shouldRemoveDuplicatesWhenSimpleDuplicatesExist() {
        // Arrange
        Task83.ListNode head = fromArray(1, 1, 2);

        // Act
        Task83.ListNode result = solution.deleteDuplicates(head);

        // Assert
        assertThat(toList(result)).containsExactly(1, 2);
    }

    @Test
    @DisplayName("Should return the same list when there are no duplicates")
    void shouldReturnSameListWhenNoDuplicatesExist() {
        // Arrange
        Task83.ListNode head = fromArray(1, 2, 3);

        // Act
        Task83.ListNode result = solution.deleteDuplicates(head);

        // Assert
        assertThat(toList(result)).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("Should handle a list with a single element")
    void shouldHandleSingleElementList() {
        // Arrange
        Task83.ListNode head = fromArray(1);

        // Act
        Task83.ListNode result = solution.deleteDuplicates(head);

        // Assert
        assertThat(toList(result)).containsExactly(1);
    }

    @Test
    @DisplayName("Should handle a null head safely")
    void shouldHandleNullHead() {
        // Arrange
        Task83.ListNode head = null;

        // Act
        Task83.ListNode result = solution.deleteDuplicates(head);

        // Assert
        assertThat(result).isNull();
    }

    // --- Helper Methods ---
    private Task83.ListNode fromArray(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Task83.ListNode dummy = new Task83.ListNode(0);
        Task83.ListNode current = dummy;
        for (int val : values) {
            current.next = new Task83.ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private List<Integer> toList(Task83.ListNode head) {
        List<Integer> list = new ArrayList<>();
        Task83.ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }
}