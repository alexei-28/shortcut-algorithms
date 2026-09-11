package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {

    @Test
    @DisplayName("Should pass LeetCode Example 1 scenario")
    void shouldPassLeetCodeExample1() {
        // Arrange
        MinStack minStack = new MinStack();

        // Act & Assert sequence mirroring Example 1
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertThat(minStack.getMin()).isEqualTo(-3);

        minStack.pop();

        assertThat(minStack.top()).isZero();
        assertThat(minStack.getMin()).isEqualTo(-2);
    }

    @Nested
    @DisplayName("Push and Top Operations")
    class PushAndTopTests {

        @Test
        @DisplayName("Should return the last pushed element when calling top")
        void top_ShouldReturnLastPushedElement() {
            // Arrange
            MinStack minStack = new MinStack();

            // Act
            minStack.push(10);
            minStack.push(20);

            // Assert
            assertThat(minStack.top()).isEqualTo(20);
        }
    }

    @Nested
    @DisplayName("Pop Operations")
    class PopTests {

        @Test
        @DisplayName("Should remove top element and reveal previous top")
        void pop_ShouldRemoveTopElement() {
            // Arrange
            MinStack minStack = new MinStack();
            minStack.push(10);
            minStack.push(20);

            // Act
            minStack.pop();

            // Assert
            assertThat(minStack.top()).isEqualTo(10);
        }
    }

    @Nested
    @DisplayName("GetMin Operations")
    class GetMinTests {

        @Test
        @DisplayName("Should update minimum when a smaller element is pushed")
        void getMin_ShouldUpdateWhenSmallerElementPushed() {
            // Arrange
            MinStack minStack = new MinStack();

            // Act
            minStack.push(5);
            minStack.push(2);

            // Assert
            assertThat(minStack.getMin()).isEqualTo(2);
        }

        @Test
        @DisplayName("Should restore previous minimum when current minimum is popped")
        void getMin_ShouldRestorePreviousMinAfterPoppingCurrentMin() {
            // Arrange
            MinStack minStack = new MinStack();
            minStack.push(5);
            minStack.push(2);
            minStack.push(1);

            // Act
            minStack.pop();

            // Assert
            assertThat(minStack.getMin()).isEqualTo(2);
        }

        @Test
        @DisplayName("Should handle duplicate minimum values correctly after popping")
        void getMin_ShouldHandleDuplicateMinimumValues() {
            // Arrange
            MinStack minStack = new MinStack();
            minStack.push(2);
            minStack.push(1);
            minStack.push(1);

            // Act
            minStack.pop();

            // Assert
            assertThat(minStack.getMin()).isEqualTo(1);
        }

        @Test
        @DisplayName("Should handle negative values and zero correctly")
        void getMin_ShouldHandleNegativeNumbersAndZero() {
            // Arrange
            MinStack minStack = new MinStack();

            // Act
            minStack.push(0);
            minStack.push(-5);
            minStack.push(-10);

            // Assert
            assertThat(minStack.getMin()).isEqualTo(-10);
        }
    }
}