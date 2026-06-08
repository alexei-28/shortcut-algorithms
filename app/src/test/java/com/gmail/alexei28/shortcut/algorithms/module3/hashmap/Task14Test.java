package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task14Test {

    private Task14 task14;

    @BeforeEach
    void setUp() {
        task14 = new Task14();
    }

    @Test
    @DisplayName("Should return 4 for a standard unsorted sequence")
    void longestConsecutive_StandardUnsortedSequence_ReturnsCorrectLength() {
        // Arrange
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("The longest consecutive sequence is [1, 2, 3, 4]")
                .isEqualTo(4);
    }

    @Test
    @DisplayName("Should return 9 for a large unsorted sequence with duplicates")
    void longestConsecutive_SequenceWithDuplicates_ReturnsCorrectLength() {
        // Arrange
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("The longest consecutive sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]")
                .isEqualTo(9);
    }

    @Test
    @DisplayName("Should return 0 when the input array is empty")
    void longestConsecutive_EmptyArray_ReturnsZero() {
        // Arrange
        int[] nums = {};

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("An empty array should yield a streak of 0")
                .isZero();
    }

    @Test
    @DisplayName("Should return 0 when the input array is null")
    void longestConsecutive_NullInput_ReturnsZero() {
        // Arrange
        int[] nums = null;

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("A null input array should yield a streak of 0")
                .isZero();
    }

    @Test
    @DisplayName("Should return 1 when the input array has only one element")
    void longestConsecutive_SingleElementArray_ReturnsOne() {
        // Arrange
        int[] nums = {42};

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("A single element array should yield a streak of 1")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Should return 1 when all elements in the array are duplicates")
    void longestConsecutive_AllDuplicateElements_ReturnsOne() {
        // Arrange
        int[] nums = {5, 5, 5, 5, 5};

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("An array of purely identical elements should yield a streak of 1")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Should return correct length when there are no consecutive elements")
    void longestConsecutive_NoConsecutiveElements_ReturnsOne() {
        // Arrange
        int[] nums = {10, 30, 50, 70};

        // Act
        int result = task14.longestConsecutive(nums);

        // Assert
        assertThat(result)
                .as("When no numbers are consecutive, max streak length should be 1")
                .isEqualTo(1);
    }
}