package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task20Test {

    private Task20 task;

    @BeforeEach
    void setUp() {
        task = new Task20();
    }

    @Test
    @DisplayName("Example 1: Should return two most frequent elements [1, 2]")
    void shouldReturnTopTwoFrequentElements() {
        // Arrange
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Act
        int[] result = task.topKFrequent(nums, k);

        // Assert
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(1, 2);
    }

    @Test
    @DisplayName("Example 2: Should return the single element when array has one element")
    void shouldReturnSingleElementWhenArrayHasOneElement() {
        // Arrange
        int[] nums = {1};
        int k = 1;

        // Act
        int[] result = task.topKFrequent(nums, k);

        // Assert
        assertThat(result)
                .hasSize(1)
                .containsExactly(1);
    }

    @Test
    @DisplayName("Example 3: Should handle larger chaotic array and return top 2 elements")
    void shouldReturnTopTwoFrequentElementsFromChaoticArray() {
        // Arrange
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k = 2;

        // Act
        int[] result = task.topKFrequent(nums, k);

        // Assert
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(1, 2);
    }

    @Test
    @DisplayName("Boundary Case: Should return all elements if k equals total unique elements")
    void shouldReturnAllElementsWhenKEqualsUniqueCount() {
        // Arrange
        int[] nums = {4, 4, 5, 5, 6, 6};
        int k = 3;

        // Act
        int[] result = task.topKFrequent(nums, k);

        // Assert
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(4, 5, 6);
    }

    @Test
    @DisplayName("Negative Numbers: Should work correctly with negative numbers in the array")
    void shouldWorkCorrectlyWithNegativeNumbers() {
        // Arrange
        int[] nums = {-1, -1, -2, -2, -2, 0};
        int k = 2;

        // Act
        int[] result = task.topKFrequent(nums, k);

        // Assert
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(-2, -1);
    }
}