package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    private Task4 task;

    @BeforeEach
    void setUp() {
        task = new Task4();
    }

    @Test
    @DisplayName("Should remove target element and return correct count for mixed elements")
    void shouldRemoveElementWhenMixedElementsPresent() {
        // Arrange
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        // Act
        int k = task.removeElement(nums, val);

        // Assert
        assertThat(k)
                .as("The number of remaining elements should be 2")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Should handle multiple target elements spread across the array")
    void shouldHandleMultipleOccurrences() {
        // Arrange
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        // Act
        int k = task.removeElement(nums, val);

        // Assert
        assertThat(k).isEqualTo(5);
    }

    @Test
    @DisplayName("Should return zero when array contains only target elements")
    void shouldReturnZeroWhenArrayContainsOnlyTargetElements() {
        // Arrange
        int[] nums = {2, 2, 2};
        int val = 2;

        // Act
        int k = task.removeElement(nums, val);

        // Assert
        assertThat(k).isZero();
    }

    @Test
    @DisplayName("Should return original length when target element is not present")
    void shouldReturnOriginalLengthWhenElementNotFound() {
        // Arrange
        int[] nums = {1, 2, 3, 4};
        int val = 5;

        // Act
        int k = task.removeElement(nums, val);

        // Assert
        assertThat(k).isEqualTo(4);
    }

    @Test
    @DisplayName("Should handle empty array gracefully")
    void shouldHandleEmptyArray() {
        // Arrange
        int[] nums = {};
        int val = 0;

        // Act
        int k = task.removeElement(nums, val);

        // Assert
        assertThat(k).isZero();
    }
}