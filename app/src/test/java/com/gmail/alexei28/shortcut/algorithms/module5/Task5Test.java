package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task5Test {

    private Task5 task5;

    @BeforeEach
    void setUp() {
        task5 = new Task5();
    }

    @Test
    @DisplayName("Should return starting and ending indices when target appears multiple times")
    void shouldReturnRangeWhenTargetExistsMultipleTimes() {
        // Arrange
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("Should return [-1, -1] when target is not present in the array")
    void shouldReturnMinusOnePairWhenTargetNotFound() {
        // Arrange
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = {-1, -1};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("Should return [-1, -1] when input array is empty")
    void shouldReturnMinusOnePairWhenArrayIsEmpty() {
        // Arrange
        int[] nums = {};
        int target = 0;
        int[] expected = {-1, -1};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("Should return same index twice when target appears exactly once")
    void shouldReturnSameIndexTwiceWhenTargetAppearsOnce() {
        // Arrange
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int[] expected = {2, 2};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("Should return [0, n-1] when all elements in the array match target")
    void shouldReturnFullRangeWhenAllElementsMatchTarget() {
        // Arrange
        int[] nums = {8, 8, 8, 8, 8};
        int target = 8;
        int[] expected = {0, 4};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("Should handle single-element array matching target")
    void shouldHandleSingleElementArrayMatchingTarget() {
        // Arrange
        int[] nums = {1};
        int target = 1;
        int[] expected = {0, 0};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("Should return [-1, -1] for single-element array not matching target")
    void shouldReturnMinusOnePairForSingleElementArrayNotMatchingTarget() {
        // Arrange
        int[] nums = {1};
        int target = 2;
        int[] expected = {-1, -1};

        // Act
        int[] result = task5.searchRange(nums, target);

        // Assert
        assertThat(result)
                .containsExactly(expected);
    }
}