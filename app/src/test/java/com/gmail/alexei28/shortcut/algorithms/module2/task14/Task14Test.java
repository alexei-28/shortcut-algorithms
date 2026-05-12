package com.gmail.alexei28.shortcut.algorithms.module2.task14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class Task14Test {

    private final Task14 task = new Task14();

    @Test
    void mergeTwoLists_ShouldMergeStandardLists2() {
        // Arrange
        ListNode l1 = new ListNode(1, new ListNode(9, new ListNode(15, new ListNode(49))));
        ListNode l2 = new ListNode(2, new ListNode(7, new ListNode(12, new ListNode(14, new ListNode(60)))));

        // Act
        ListNode actual = task.mergeTwoLists(l1, l2);

        // Assert
        assertThat(actual).isNotNull();
        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.next.val).isEqualTo(2);
        assertThat(actual.next.next.val).isEqualTo(7);
        assertThat(actual.next.next.next.val).isEqualTo(9);
        assertThat(actual.next.next.next.next.val).isEqualTo(12);
        assertThat(actual.next.next.next.next.next.val).isEqualTo(14);
        assertThat(actual.next.next.next.next.next.next.val).isEqualTo(15);
        assertThat(actual.next.next.next.next.next.next.next.val).isEqualTo(49);
        assertThat(actual.next.next.next.next.next.next.next.next.val).isEqualTo(60);
        assertThat(actual.next.next.next.next.next.next.next.next.next).isNull();
    }

    @Test
    void mergeTwoLists_ShouldMergeStandardLists() {
        // Arrange
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        // Act
        ListNode actual = task.mergeTwoLists(l1, l2);

        // Assert
        assertThat(actual).isNotNull();
        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.next.val).isEqualTo(2);
        assertThat(actual.next.next.val).isEqualTo(3);
        assertThat(actual.next.next.next.val).isEqualTo(4);
        assertThat(actual.next.next.next.next.val).isEqualTo(5);
        assertThat(actual.next.next.next.next.next.val).isEqualTo(6);
        assertThat(actual.next.next.next.next.next.next).isNull();
    }

    @Test
    void mergeTwoLists_ShouldHandleEmptyLists() {
        // Arrange
        ListNode l1 = null;
        ListNode l2 = null;

        // Act
        ListNode actual = task.mergeTwoLists(l1, l2);

        // Assert
        assertThat(actual).isNull();
    }

    @Test
    void mergeTwoLists_ShouldHandleOneEmptyList() {
        // Arrange
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);

        // Act
        ListNode actual = task.mergeTwoLists(l1, l2);

        // Assert
        assertThat(actual).isNotNull();
        assertThat(actual.val).isZero();
        assertThat(actual.next).isNull();
    }

    @Test
    void mergeTwoLists_ShouldHandleDifferentLengths() {
        // Arrange
        ListNode l1 = new ListNode(1, new ListNode(2));
        ListNode l2 = new ListNode(5);

        // Act
        ListNode actual = task.mergeTwoLists(l1, l2);

        // Assert
        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.next.val).isEqualTo(2);
        assertThat(actual.next.next.val).isEqualTo(5);
    }
}