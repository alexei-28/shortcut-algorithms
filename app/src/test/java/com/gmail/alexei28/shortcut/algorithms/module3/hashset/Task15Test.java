package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task15Test {

    private Task15 task15;

    @BeforeEach
    void setUp() {
        task15 = new Task15();
    }

    @Test
    @DisplayName("Should return true when array contains duplicates (Example 1)")
    void shouldReturnTrueWhenDuplicatesExist() {
        // Arrange
        int[] nums = {1, 2, 3, 1};

        // Act
        boolean result = task15.containsDuplicate(nums);

        // Assert
        assertThat(result)
                .as("Array %s contains duplicate '1'", java.util.Arrays.toString(nums))
                .isTrue();
    }

    @Test
    @DisplayName("Should return false when all elements are distinct (Example 2)")
    void shouldReturnFalseWhenAllElementsAreDistinct() {
        // Arrange
        int[] nums = {1, 2, 3, 4};

        // Act
        boolean result = task15.containsDuplicate(nums);

        // Assert
        assertThat(result)
                .as("Array %s has only unique elements", java.util.Arrays.toString(nums))
                .isFalse();
    }

    @Test
    @DisplayName("Should return true when array has multiple duplicates scattered around (Example 3)")
    void shouldReturnTrueWhenMultipleDuplicatesExist() {
        // Arrange
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        // Act
        boolean result = task15.containsDuplicate(nums);

        // Assert
        assertThat(result)
                .as("Array contains multiple duplicate elements")
                .isTrue();
    }

    @Test
    @DisplayName("Should return false when array is empty")
    void shouldReturnFalseWhenArrayIsEmpty() {
        // Arrange
        int[] nums = {};

        // Act
        boolean result = task15.containsDuplicate(nums);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Should return false when array has only one element")
    void shouldReturnFalseWhenArrayHasSingleElement() {
        // Arrange
        int[] nums = {42};

        // Act
        boolean result = task15.containsDuplicate(nums);

        // Assert
        assertThat(result).isFalse();
    }
}