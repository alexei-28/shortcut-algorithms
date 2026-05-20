package com.gmail.alexei28.shortcut.algorithms.module2.task20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    private LinkedList list;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
    }

    @Nested
    @DisplayName("Append Operations")
    class AppendTests {

        @Test
        @DisplayName("Should correctly append to an empty list")
        void appendToEmptyList() {
            // Arrange
            int value = 42;

            // Act
            list.append(value);

            // Assert
            assertThat(list.getHead()).isNotNull();
            assertThat(list.getHead().val).isEqualTo(value);
            assertThat(list.getTail()).isSameAs(list.getHead());
            assertThat(list.getHead().next).isNull();
        }

        @Test
        @DisplayName("Should correctly append multiple elements sequentially")
        void appendMultipleElements() {
            // Arrange & Act
            list.append(10);
            list.append(20);
            list.append(30);

            // Assert
            assertThat(list.getHead().val).isEqualTo(10);
            assertThat(list.getHead().next.val).isEqualTo(20);
            assertThat(list.getTail().val).isEqualTo(30);
            assertThat(list.getTail().next).isNull();
        }
    }

    @Nested
    @DisplayName("Search Operations")
    class SearchTests {

        @Test
        @DisplayName("Should return null when searching an empty list")
        void searchInEmptyList() {
            // Arrange
            int target = 5;

            // Act
            ListNode result = list.search(target);

            // Assert
            assertThat(result).isNull();
        }

        @Test
        @DisplayName("Should return the exact node if the value exists")
        void searchExistingElement() {
            // Arrange
            list.append(1);
            list.append(2);
            list.append(3);

            // Act
            ListNode result = list.search(2);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result.val).isEqualTo(2);
            assertThat(result.next).isNotNull().extracting(n -> n.val).isEqualTo(3);
        }

        @Test
        @DisplayName("Should return null if the value does not exist")
        void searchNonExistingElement() {
            // Arrange
            list.append(1);
            list.append(2);

            // Act
            ListNode result = list.search(99);

            // Assert
            assertThat(result).isNull();
        }
    }

    @Nested
    @DisplayName("Delete Operations")
    class DeleteTests {

        @Test
        @DisplayName("Should return false when attempting to delete from an empty list")
        void deleteFromEmptyList() {
            // Arrange
            int valToDelete = 10;

            // Act
            boolean isDeleted = list.delete(valToDelete);

            // Assert
            assertThat(isDeleted).isFalse();
            assertThat(list.getHead()).isNull();
            assertThat(list.getTail()).isNull();
        }

        @Test
        @DisplayName("Should handle deleting the single remaining element in the list")
        void deleteOnlyElement() {
            // Arrange
            list.append(100);

            // Act
            boolean isDeleted = list.delete(100);

            // Assert
            assertThat(isDeleted).isTrue();
            assertThat(list.getHead()).isNull();
            assertThat(list.getTail()).isNull();
        }

        @Test
        @DisplayName("Should correctly update the head pointer when deleting the first element")
        void deleteHeadElement() {
            // Arrange
            list.append(10);
            list.append(20);
            list.append(30);

            // Act
            boolean isDeleted = list.delete(10);

            // Assert
            assertThat(isDeleted).isTrue();
            assertThat(list.getHead().val).isEqualTo(20);
            assertThat(list.getTail().val).isEqualTo(30);
        }

        @Test
        @DisplayName("Should correctly bridge nodes when deleting an element from the middle")
        void deleteMiddleElement() {
            // Arrange
            list.append(10);
            list.append(20);
            list.append(30);

            // Act
            boolean isDeleted = list.delete(20);

            // Assert
            assertThat(isDeleted).isTrue();
            assertThat(list.getHead().val).isEqualTo(10);
            assertThat(list.getHead().next.val).isEqualTo(30);
            assertThat(list.getTail().val).isEqualTo(30);
        }

        @Test
        @DisplayName("Should correctly update the tail pointer when deleting the last element")
        void deleteTailElement() {
            // Arrange
            list.append(10);
            list.append(20);
            list.append(30);

            // Act
            boolean isDeleted = list.delete(30);

            // Assert
            assertThat(isDeleted).isTrue();
            assertThat(list.getHead().val).isEqualTo(10);
            assertThat(list.getHead().next.val).isEqualTo(20);
            assertThat(list.getTail().val).isEqualTo(20);
            assertThat(list.getTail().next).isNull();
        }
    }

    @Nested
    @DisplayName("Reverse Operations")
    class ReverseTests {

        @Test
        @DisplayName("Should return null when reversing an empty list")
        void reverseEmptyList() {
            // Arrange & Act
            LinkedList result = list.reverse();

            // Assert
            assertThat(result).isNull();
        }

        @Test
        @DisplayName("Should preserve structure when reversing a list with a single element")
        void reverseSingleElementList() {
            // Arrange
            list.append(5);

            // Act
            LinkedList result = list.reverse();

            // Assert
            assertThat(result).isSameAs(list);
            assertThat(list.getHead().val).isEqualTo(5);
            assertThat(list.getTail().val).isEqualTo(5);
            assertThat(list.getHead().next).isNull();
        }

        @Test
        @DisplayName("Should completely invert links and swap head/tail pointers")
        void reverseMultiElementList() {
            // Arrange
            list.append(1);
            list.append(2);
            list.append(3);

            // Act
            LinkedList result = list.reverse();

            // Assert
            assertThat(result).isSameAs(list);

            // Value Chain Verification: 3 -> 2 -> 1
            assertThat(list.getHead().val).isEqualTo(3);
            assertThat(list.getHead().next.val).isEqualTo(2);
            assertThat(list.getHead().next.next.val).isEqualTo(1);

            // Boundary Verification
            assertThat(list.getTail().val).isEqualTo(1);
            assertThat(list.getTail().next).isNull();
        }
    }
}