package com.gmail.alexei28.shortcut.algorithms.module3;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ArrayIntersectionMoreTest {

    private final Task3 solution = new Task3();

    @Test
    void shouldHandleNegativeNumbersAndZero() {
        // Arrange
        int[] nums1 = {-1, 0, 1, 2};
        int[] nums2 = {2, 0, -5, -1};
        int[] expected = {-1, 0, 2};

        // Act
        int[] actual = solution.intersection(nums1, nums2);

        // Assert
        assertThat(actual)
                .as("Should correctly find intersections involving negative numbers and zero")
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    void shouldHandleArraysWithVaryingSizes() {
        // Arrange
        int[] nums1 = {9, 4, 9, 8, 4};
        int[] nums2 = {4, 95};
        int[] expected = {4};

        // Act
        int[] actual = solution.intersection(nums1, nums2);

        // Assert
        assertThat(actual)
                .as("Should handle cases where one array is significantly smaller than the other")
                .containsExactlyInAnyOrder(expected);
    }

    @Test
    void shouldReturnEmptyArrayWhenOneInputIsEmpty() {
        // Arrange
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};

        // Act
        int[] actual = solution.intersection(nums1, nums2);

        // Assert
        assertThat(actual)
                .as("An intersection with an empty array must always be empty")
                .isEmpty();
    }

    @Test
    void shouldReturnUniqueElementsWhenBothArraysAreIdenticalWithDuplicates() {
        // Arrange
        int[] nums1 = {7, 7, 7, 7};
        int[] nums2 = {7, 7};
        int[] expected = {7};

        // Act
        int[] actual = solution.intersection(nums1, nums2);

        // Assert
        assertThat(actual)
                .as("Result should only contain unique values even if inputs contain identical duplicates")
                .containsExactlyInAnyOrder(expected);
    }
}