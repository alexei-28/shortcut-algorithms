package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task11Test {

    private Task11 task11;

    @BeforeEach
    void setUp() {
        task11 = new Task11();
    }

    @Test
    @DisplayName("Should return correct count for basic Example 1")
    void subarraySum_Example1_ReturnsExpectedCount() {
        // Arrange
        int[] nums = {1, 1, 1};
        int k = 2;

        // Act
        int result = task11.subarraySum(nums, k);

        // Assert
        assertThat(result)
                .as("Count of subarrays with sum %d in %s", k, java.util.Arrays.toString(nums))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Should return correct count for basic Example 2")
    void subarraySum_Example2_ReturnsExpectedCount() {
        // Arrange
        int[] nums = {1, 2, 3};
        int k = 3;

        // Act
        int result = task11.subarraySum(nums, k);

        // Assert
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("Should return 0 when no subarray sums up to K")
    void subarraySum_NoMatchingSubarray_ReturnsZero() {
        // Arrange
        int[] nums = {1, 2, 3};
        int k = 7;

        // Act
        int result = task11.subarraySum(nums, k);

        // Assert
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("Should handle arrays containing negative numbers correctly")
    void subarraySum_WithNegativeNumbers_ReturnsExpectedCount() {
        // Arrange
        int[] nums = {1, -1, 1, 1, -1};
        int k = 1;
        // Subarrays with sum 1: [1], [1,-1,1], [1], [1,-1,1], [-1,1,1], [1], [1,-1] (wait, let's verify:
        // [1] at index 0, 2, 3
        // [1,-1,1] at 0-2, 2-4
        // [-1,1,1] at 1-3
        // [1] at 3
        // Total should be 7. Let's pick a simpler verifiable negative test case:
        // [3, 4, -7, 1, 3, 3, 1, -4], k = 7
        // [3,4], [3,4,-7,1,3,3,1], [1,3,3], [3,3,1], [1,3,3,1,-4] -> 4 subarrays
        int[] numsSimple = {1, -1, 0};
        int kSimple = 0; // [1, -1], [0], [1, -1, 0] -> 3 subarrays

        // Act
        int result = task11.subarraySum(numsSimple, kSimple);

        // Assert
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should handle single element array matching K")
    void subarraySum_SingleElementMatchesK_ReturnsOne() {
        // Arrange
        int[] nums = {5};
        int k = 5;

        // Act
        int result = task11.subarraySum(nums, k);

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Should handle single element array not matching K")
    void subarraySum_SingleElementDoesNotMatchK_ReturnsZero() {
        // Arrange
        int[] nums = {5};
        int k = 3;

        // Act
        int result = task11.subarraySum(nums, k);

        // Assert
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("Should handle multiple zeroes correctly")
    void subarraySum_ArrayWithOnlyZeroes_ReturnsCorrectCount() {
        // Arrange
        int[] nums = {0, 0, 0};
        int k = 0;
        // Combinations: [0]@0, [0]@1, [0]@2, [0,0]@0-1, [0,0]@1-2, [0,0,0]@0-2 -> 6

        // Act
        int result = task11.subarraySum(nums, k);

        // Assert
        assertThat(result).isEqualTo(6);
    }
}