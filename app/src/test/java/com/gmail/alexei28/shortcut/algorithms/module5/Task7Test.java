package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task7Test {

    private Task7 solution;

    @BeforeEach
    void setUp() {
        solution = new Task7();
    }

    @Test
    @DisplayName("Should find minimum in standard rotated array (Example 1)")
    void shouldFindMinimumInRotatedArrayExample1() {
        // Arrange
        int[] nums = {3, 4, 5, 1, 2};
        int expected = 1;

        // Act
        int actual = solution.findMin(nums);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should find minimum in larger rotated array (Example 2)")
    void shouldFindMinimumInRotatedArrayExample2() {
        // Arrange
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;

        // Act
        int actual = solution.findMin(nums);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should find minimum in unrotated sorted array (Example 3)")
    void shouldFindMinimumInUnrotatedArrayExample3() {
        // Arrange
        int[] nums = {11, 13, 15, 17};
        int expected = 11;

        // Act
        int actual = solution.findMin(nums);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle single element array")
    void shouldHandleSingleElementArray() {
        // Arrange
        int[] nums = {5};
        int expected = 5;

        // Act
        int actual = solution.findMin(nums);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle two elements rotated once")
    void shouldHandleTwoElementsRotatedOnce() {
        // Arrange
        int[] nums = {2, 1};
        int expected = 1;

        // Act
        int actual = solution.findMin(nums);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle array rotated at the very end")
    void shouldHandleArrayRotatedAtEnd() {
        // Arrange
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 1;

        // Act
        int actual = solution.findMin(nums);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }
}