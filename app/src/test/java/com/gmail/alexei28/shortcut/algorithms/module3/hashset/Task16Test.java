package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task16Test {

    private Task16 task;

    @BeforeEach
    void setUp() {
        task = new Task16();
    }

    @Test
    @DisplayName("Should remove duplicates from a short sorted array (Example 1)")
    void should_RemoveDuplicates_When_ArrayHasFewDuplicates() {
        // Arrange
        int[] nums = {1, 1, 2};
        int[] expectedUniquePrefix = {1, 2};

        // Act
        int k = task.removeDuplicates(nums);

        // Assert
        assertThat(k)
                .as("The number of unique elements should match the expected prefix length")
                .isEqualTo(expectedUniquePrefix.length);

        assertThat(nums)
                .as("The first %d elements of the array must match the expected unique values", k)
                .startsWith(expectedUniquePrefix);
    }

    @Test
    @DisplayName("Should remove duplicates from a longer sorted array (Example 2)")
    void should_RemoveDuplicates_When_ArrayHasMultipleDuplicates() {
        // Arrange
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedUniquePrefix = {0, 1, 2, 3, 4};

        // Act
        int k = task.removeDuplicates(nums);

        // Assert
        assertThat(k).isEqualTo(expectedUniquePrefix.length);
        assertThat(nums).startsWith(expectedUniquePrefix);
    }

    @Test
    @DisplayName("Should handle an array with no duplicate elements")
    void should_ReturnSameLength_When_NoDuplicatesExist() {
        // Arrange
        int[] nums = {1, 2, 3, 4, 5};
        int[] expectedUniquePrefix = {1, 2, 3, 4, 5};

        // Act
        int k = task.removeDuplicates(nums);

        // Assert
        assertThat(k).isEqualTo(expectedUniquePrefix.length);
        assertThat(nums).startsWith(expectedUniquePrefix);
    }

    @Test
    @DisplayName("Should handle an array where all elements are identical")
    void should_ReturnLengthOne_When_AllElementsAreIdentical() {
        // Arrange
        int[] nums = {2, 2, 2, 2};
        int[] expectedUniquePrefix = {2};

        // Act
        int k = task.removeDuplicates(nums);

        // Assert
        assertThat(k).isEqualTo(expectedUniquePrefix.length);
        assertThat(nums).startsWith(expectedUniquePrefix);
    }

    @Test
    @DisplayName("Should handle an array with a single element")
    void should_ReturnLengthOne_When_ArrayHasSingleElement() {
        // Arrange
        int[] nums = {42};
        int[] expectedUniquePrefix = {42};

        // Act
        int k = task.removeDuplicates(nums);

        // Assert
        assertThat(k).isEqualTo(expectedUniquePrefix.length);
        assertThat(nums).startsWith(expectedUniquePrefix);
    }
}