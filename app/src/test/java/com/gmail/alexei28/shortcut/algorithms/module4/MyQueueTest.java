package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyQueueTest {

    @Nested
    @DisplayName("Empty Queue State")
    class EmptyQueue {

        @Test
        @DisplayName("empty() should return true when queue is freshly initialized")
        void shouldReturnTrue_WhenQueueIsNew() {
            // Arrange
            MyQueue queue = new MyQueue();

            // Act
            boolean isEmpty = queue.empty();

            // Assert
            assertThat(isEmpty).isTrue();
        }

        @Test
        @DisplayName("should return true when all pushed elements are popped")
        void shouldReturnTrue_WhenAllElementsArePopped() {
            // Arrange
            MyQueue queue = new MyQueue();
            queue.push(10);
            queue.pop();

            // Act
            boolean isEmpty = queue.empty();

            // Assert
            assertThat(isEmpty).isTrue();
        }
    }

    @Nested
    @DisplayName("Push Operations")
    class PushOperations {

        @Test
        @DisplayName("should return false after pushing an element")
        void shouldMakeQueueNonEmpty() {
            // Arrange
            MyQueue queue = new MyQueue();

            // Act
            queue.push(1);

            // Assert
            assertThat(queue.empty()).isFalse();
        }
    }

    @Nested
    @DisplayName("Peek Operations")
    class PeekOperations {

        @Test
        @DisplayName("should return front element without removing it")
        void shouldReturnFrontElement_WithoutRemovingIt() {
            // Arrange
            MyQueue queue = new MyQueue();
            queue.push(10);
            queue.push(20);

            // Act
            int firstPeek = queue.peek();
            int secondPeek = queue.peek();

            // Assert
            assertThat(firstPeek)
                    .as("First peek should return earliest pushed element")
                    .isEqualTo(10);

            assertThat(secondPeek)
                    .as("Second peek should still return the same element")
                    .isEqualTo(10);

            assertThat(queue.empty())
                    .as("Queue should not be empty after peek operations")
                    .isFalse();
        }
    }

    @Nested
    @DisplayName("Pop Operations")
    class PopOperations {

        @Test
        @DisplayName("should remove and return elements in FIFO order")
        void shouldReturnElementsInFifoOrder() {
            // Arrange
            MyQueue queue = new MyQueue();
            queue.push(1);
            queue.push(2);
            queue.push(3);

            // Act
            int firstPopped = queue.pop();
            int secondPopped = queue.pop();

            // Assert
            assertThat(firstPopped).isEqualTo(1);
            assertThat(secondPopped).isEqualTo(2);
        }

        @Test
        @DisplayName("Interleaved push and pop operations maintain FIFO order")
        void shouldHandleInterleavedPushAndPop() {
            // Arrange
            MyQueue queue = new MyQueue();

            // Act & Assert
            queue.push(1);
            queue.push(2);
            assertThat(queue.pop()).isEqualTo(1);

            queue.push(3);
            assertThat(queue.peek()).isEqualTo(2);
            assertThat(queue.pop()).isEqualTo(2);
            assertThat(queue.pop()).isEqualTo(3);
            assertThat(queue.empty()).isTrue();
        }
    }

    @Nested
    @DisplayName("LeetCode Example 1 Scenario")
    class LeetCodeExample {

        @Test
        @DisplayName("Should pass LeetCode Example 1 sequence")
        void testLeetCodeExample1() {
            // Arrange
            MyQueue myQueue = new MyQueue();

            // Act & Assert
            myQueue.push(1); // queue is: [1]
            myQueue.push(2); // queue is: [1, 2]

            int peekVal = myQueue.peek(); // return 1
            int popVal = myQueue.pop();   // return 1, queue is [2]
            boolean isEmpty = myQueue.empty(); // return false

            assertThat(peekVal).isEqualTo(1);
            assertThat(popVal).isEqualTo(1);
            assertThat(isEmpty).isFalse();
        }
    }
}