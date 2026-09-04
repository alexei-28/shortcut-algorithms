package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyStackTest {

    private MyStack stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    @DisplayName("should return true for a newly created stack")
    void shouldReturnTrue_WhenStackIsNew() {
        // Arrange - handled by setUp()

        // Act
        boolean isEmpty = stack.empty();

        // Assert
        assertThat(isEmpty).isTrue();
    }

    @Test
    @DisplayName("should return false when elements exist")
    void shouldReturnFalse_WhenElementsPushed() {
        // Arrange
        stack.push(10);

        // Act
        boolean isEmpty = stack.empty();

        // Assert
        assertThat(isEmpty).isFalse();
    }

    @Test
    @DisplayName("should return the last pushed element without removing it")
    void shouldReturnLastPushedElement_WithoutRemovingIt() {
        // Arrange
        stack.push(1);
        stack.push(2);

        // Act
        int topElement = stack.top();

        // Assert
        assertThat(topElement).isEqualTo(2);
        assertThat(stack.empty()).isFalse();
    }

    @Test
    @DisplayName("should remove and return the last pushed element")
    void shouldRemoveAndReturnTopElement() {
        // Arrange
        stack.push(100);
        stack.push(200);

        // Act
        int poppedValue = stack.pop();

        // Assert
        assertThat(poppedValue).isEqualTo(200);
        assertThat(stack.top()).isEqualTo(100);
    }

    @Test
    @DisplayName("Should maintain LIFO order across multiple operations")
    void shouldMaintainLifoOrder() {
        // Arrange
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Act & Assert (Sequential pops verifying LIFO behavior)
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.empty()).isTrue();
    }

    @Test
    @DisplayName("LeetCode Example 1 scenario")
    void leetCodeExample1() {
        // Arrange
        // myStack instantiated in setUp()

        // Act & Assert sequence mirroring LeetCode steps
        stack.push(1);
        stack.push(2);

        int topResult = stack.top();
        assertThat(topResult).isEqualTo(2);

        int popResult = stack.pop();
        assertThat(popResult).isEqualTo(2);

        boolean emptyResult = stack.empty();
        assertThat(emptyResult).isFalse();
    }
}