package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TaskBaseTest {

    private TaskBase task1;

    @BeforeEach
    void setUp() {
        task1 = new TaskBase();
    }

    @Nested
    @DisplayName("Iterative Binary Search Tests")
    class IterativeBinarySearchTests {

        @Test
        @DisplayName("Should return correct index when target is in the middle")
        void binarySearch_ElementInMiddle_ReturnsIndex() {
            // Arrange
            int[] arr = {1, 3, 5, 7, 9};
            int target = 5;

            // Act
            int actualIndex = task1.binarySearch(arr, target);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(2);
        }

        @Test
        @DisplayName("Should return correct index when target is at the beginning")
        void binarySearch_ElementAtStart_ReturnsZeroIndex() {
            // Arrange
            int[] arr = {10, 20, 30, 40, 50};
            int target = 10;

            // Act
            int actualIndex = task1.binarySearch(arr, target);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(0);
        }

        @Test
        @DisplayName("Should return correct index when target is at the end")
        void binarySearch_ElementAtEnd_ReturnsLastIndex() {
            // Arrange
            int[] arr = {10, 20, 30, 40, 50};
            int target = 50;

            // Act
            int actualIndex = task1.binarySearch(arr, target);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(4);
        }

        @Test
        @DisplayName("Should return -1 when target is absent")
        void binarySearch_ElementMissing_ReturnsMinusOne() {
            // Arrange
            int[] arr = {2, 4, 6, 8, 10};
            int target = 5;

            // Act
            int actualIndex = task1.binarySearch(arr, target);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(-1);
        }

        @Test
        @DisplayName("Should return -1 when array is empty")
        void binarySearch_EmptyArray_ReturnsMinusOne() {
            // Arrange
            int[] arr = {};
            int target = 10;

            // Act
            int actualIndex = task1.binarySearch(arr, target);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(-1);
        }

        @Test
        @DisplayName("Should find element in single element array")
        void binarySearch_SingleElementArray_ReturnsIndex() {
            // Arrange
            int[] arr = {42};
            int target = 42;

            // Act
            int actualIndex = task1.binarySearch(arr, target);

            // Assert
            assertThat(actualIndex)
                    .isZero();
        }
    }

    @Nested
    @DisplayName("Recursive Binary Search Tests")
    class RecursiveBinarySearchTests {

        @Test
        @DisplayName("Should return correct index when target exists in array")
        void binarySearchRecursive_ElementExists_ReturnsIndex() {
            // Arrange
            int[] arr = {1, 3, 5, 7, 9, 11};
            int target = 7;

            // Act
            int actualIndex = task1.binarySearchRecursive(arr, target, 0, arr.length - 1);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(3);
        }

        @Test
        @DisplayName("Should return -1 when target does not exist in array")
        void binarySearchRecursive_ElementMissing_ReturnsMinusOne() {
            // Arrange
            int[] arr = {1, 3, 5, 7, 9};
            int target = 4;

            // Act
            int actualIndex = task1.binarySearchRecursive(arr, target, 0, arr.length - 1);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(-1);
        }

        @Test
        @DisplayName("Should return -1 when invalid search bounds are provided")
        void binarySearchRecursive_InvalidBounds_ReturnsMinusOne() {
            // Arrange
            int[] arr = {1, 2, 3};
            int target = 2;

            // Act
            int actualIndex = task1.binarySearchRecursive(arr, target, 2, 1);

            // Assert
            assertThat(actualIndex)
                    .isEqualTo(-1);
        }
    }

    @ParameterizedTest(name = "Iterative & Recursive search for target {0} -> expected index {1}")
    @CsvSource({
            "1, 0",
            "5, 2",
            "9, 4",
            "0, -1",
            "10, -1"
    })
    @DisplayName("Parameterized test comparing both implementations")
    void binarySearch_ParameterizedTest_MatchesExpectedIndex(int target, int expectedIndex) {
        // Arrange
        int[] arr = {1, 3, 5, 7, 9};

        // Act
        int iterativeResult = task1.binarySearch(arr, target);
        int recursiveResult = task1.binarySearchRecursive(arr, target, 0, arr.length - 1);

        // Assert
        assertThat(iterativeResult)
                .as("Iterative binary search result for target %d", target)
                .isEqualTo(expectedIndex);

        assertThat(recursiveResult)
                .as("Recursive binary search result for target %d", target)
                .isEqualTo(expectedIndex);
    }
}