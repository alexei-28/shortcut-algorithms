package com.gmail.alexei28.shortcut.algorithms.module2.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task20Test {

    private Task20 task;

    @BeforeEach
    void setUp() {
        task = new Task20();
    }

    @Test
    void hasCycle_WhenListHasCycle_ShouldReturnTrue() {
        // Arrange
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Creates the cycle back to node1 (index 1)

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void hasCycle_WhenTwoNodesHaveCycle_ShouldReturnTrue() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;
        node1.next = head; // Creates a cycle back to the head

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void hasCycle_WhenSingleNodeWithNoCycle_ShouldReturnFalse() {
        // Arrange
        ListNode head = new ListNode(1);

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void hasCycle_WhenTwoNodesWithNoCycle_ShouldReturnFalse() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }


    @Test
    void hasCycle_WhenMultipleNodesWithNoCycle_ShouldReturnFalse() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        head.next = node1;
        node1.next = node2; // Straight line, tail points to null

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void hasCycle_WhenListIsEmpty_ShouldReturnFalse() {
        // Arrange
        ListNode head = null;

        // Act
        boolean result = task.hasCycle(head);

        // Assert
        assertThat(result).isFalse();
    }
}