package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    private Task2 task;

    @BeforeEach
    void setUp() {
        task = new Task2();
    }

    @Test
    @DisplayName("Should return false when the linked list is empty")
    void shouldReturnFalseWhenListIsEmpty() {
        // Arrange
        ListNode head = null;

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Should return false when the list has a single node with no cycle")
    void shouldReturnFalseWhenSingleNodeHasNoCycle() {
        // Arrange
        ListNode head = new ListNode(1);

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Should return true when a single node points to itself")
    void shouldReturnTrueWhenSingleNodePointsToItself() {
        // Arrange
        ListNode head = new ListNode(1);
        head.next = head;

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should return false when a multi-node list has no cycle")
    void shouldReturnFalseWhenMultiNodeListHasNoCycle() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);

        head.next = second;
        //second.next = second;

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Should return true when a multi-node list contains a cycle")
    void shouldReturnTrueWhenMultiNodeListHasCycle() {
        // Arrange & Setup a cycle: 3 -> 2 -> 0 -> -4 -> (loops back to 2)
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating the cycle here

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isTrue();
    }
}