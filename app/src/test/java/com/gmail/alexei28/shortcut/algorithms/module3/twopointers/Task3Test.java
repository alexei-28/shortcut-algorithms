package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {

    private Task3 task3;

    @BeforeEach
    void setUp() {
        task3 = new Task3();
    }

    @Test
    void should_RemoveMiddleNode_When_NIsInMiddleOfList() {
        // Arrange
        ListNode head = createLinkedList(1, 2, 3, 4, 5);
        int n = 2; // Removes '4'

        // Act
        ListNode result = task3.removeNthFromEnd(head, n);

        // Assert
        assertThat(toList(result)).containsExactly(1, 2, 3, 5);
    }

    @Test
    void should_RemoveHeadNode_When_NIsLengthOfList() {
        // Arrange
        ListNode head = createLinkedList(1, 2, 3);
        int n = 3; // Removes '1'

        // Act
        ListNode result = task3.removeNthFromEnd(head, n);

        // Assert
        assertThat(toList(result)).containsExactly(2, 3);
    }

    @Test
    void should_RemoveLastNode_When_NIsOne() {
        // Arrange
        ListNode head = createLinkedList(1, 2, 3);
        int n = 1; // Removes '3'

        // Act
        ListNode result = task3.removeNthFromEnd(head, n);

        // Assert
        assertThat(toList(result)).containsExactly(1, 2);
    }

    @Test
    void should_ReturnNull_When_ListHasOneElementAndNIsOne() {
        // Arrange
        ListNode head = createLinkedList(1);
        int n = 1; // Removes '1'

        // Act
        ListNode result = task3.removeNthFromEnd(head, n);

        // Assert
        assertThat(result).isNull();
    }

    // --- Helper Methods for Easier Test Setup and Verification ---

    private ListNode createLinkedList(int... values) {
        if (values == null || values.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }
}