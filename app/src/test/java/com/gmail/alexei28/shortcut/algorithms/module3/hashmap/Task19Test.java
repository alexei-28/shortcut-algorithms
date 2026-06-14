package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task19Test {

    private final Task19 task = new Task19();

    @Test
    @DisplayName("Should find the single number when it is at the end of the array")
    void shouldFindSingleNumberWhenAtTheEnd() {
        // 1. Arrange
        int[] nums = {2, 2, 1};
        int expectedResult = 1;

        // 2. Act
        int actualResult = task.singleNumber(nums);

        // 3. Assert
        assertThat(actualResult)
                .as("The single number in [2, 2, 1] should be 1")
                .isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should find the single number when it is at the beginning of the array")
    void shouldFindSingleNumberWhenAtTheBeginning() {
        // 1. Arrange
        int[] nums = {4, 1, 2, 1, 2};
        int expectedResult = 4;

        // 2. Act
        int actualResult = task.singleNumber(nums);

        // 3. Assert
        assertThat(actualResult)
                .as("The single number in [4, 1, 2, 1, 2] should be 4")
                .isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Should return the only element when array size is one")
    void shouldReturnElementWhenArrayHasSingleElement() {
        // 1. Arrange
        int[] nums = {1};
        int expectedResult = 1;

        // 2. Act
        int actualResult = task.singleNumber(nums);

        // 3. Assert
        assertThat(actualResult)
                .as("The single number in a single-element array should be the element itself")
                .isEqualTo(expectedResult);
    }
}