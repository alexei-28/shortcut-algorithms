package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Task1Test {

    private Task1 task;

    @BeforeEach
    void setUp() {
        task = new Task1();
    }

    @Test
    void maxSumSubArray_withValidArray_returnsCorrectMaxSum() {
        // Arrange
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        // Act
        int result = task.maxSumSubArray(nums, k);

        // Assert
        assertThat(result)
                .as("The maximum sum of a subarray of length 4 should be 39")
                .isEqualTo(39);
    }

    @Test
    void maxSumSubArray_whenKEqualsArrayLength_returnsTotalSum() {
        // Arrange
        int[] nums = {1, 2, 3, 4};
        int k = 4;

        // Act
        int result = task.maxSumSubArray(nums, k);

        // Assert
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidInputs")
    void maxSumSubArray_withInvalidInputs_throwsIllegalArgumentException(int[] nums, int k) {
        // Arrange & Act & Assert (AssertJ combines Act & Assert for exceptions)
        assertThatThrownBy(() -> task.maxSumSubArray(nums, k))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid input");
    }

    private static Stream<Arguments> provideInvalidInputs() {
        return Stream.of(
                Arguments.of(null, 3),                          // Null array
                Arguments.of(new int[]{1, 2}, 3),               // k greater than array length
                Arguments.of(new int[]{1, 2, 3}, 0),            // k is zero
                Arguments.of(new int[]{1, 2, 3}, -1)            // k is negative
        );
    }
}