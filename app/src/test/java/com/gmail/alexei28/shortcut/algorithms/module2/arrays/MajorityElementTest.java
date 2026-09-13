package com.gmail.alexei28.shortcut.algorithms.module2.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {

    private MajorityElement solution;

    @BeforeEach
    void setUp() {
        solution = new MajorityElement();
    }

    @Test
    @DisplayName("Should return 3 when majority element appears in odd length array")
    void majorityElement_WhenOddLengthArray_ReturnsMajorityElement() {
        // Arrange
        int[] nums = {3, 2, 3};

        // Act
        int result = solution.majorityElement(nums);

        // Assert
        assertThat(result)
                .as("Majority element should be 3")
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Should return 2 when majority element appears in even length array")
    void majorityElement_WhenEvenLengthArray_ReturnsMajorityElement() {
        // Arrange
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        // Act
        int result = solution.majorityElement(nums);

        // Assert
        assertThat(result)
                .as("Majority element should be 2")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Should return the single element when array length is 1")
    void majorityElement_WhenSingleElementArray_ReturnsElement() {
        // Arrange
        int[] nums = {1};

        // Act
        int result = solution.majorityElement(nums);

        // Assert
        assertThat(result)
                .as("Majority element for a single-element array should be the element itself")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Should handle negative numbers correctly")
    void majorityElement_WhenArrayContainsNegativeNumbers_ReturnsMajorityElement() {
        // Arrange
        int[] nums = {-1, -1, 2147483647, -1};

        // Act
        int result = solution.majorityElement(nums);

        // Assert
        assertThat(result)
                .as("Majority element should handle negative values properly")
                .isEqualTo(-1);
    }

    @ParameterizedTest(name = "Test case {index}: input={0}, expected={1}")
    @MethodSource("provideArraysForMajorityElement")
    @DisplayName("Parameterized test for various majority element inputs")
    void majorityElement_ParameterizedTests(int[] nums, int expected) {
        // Arrange - parameters injected via method source

        // Act
        int result = solution.majorityElement(nums);

        // Assert
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArraysForMajorityElement() {
        return Stream.of(
                Arguments.of(new int[]{3, 3, 4}, 3),
                Arguments.of(new int[]{6, 5, 5}, 5),
                Arguments.of(new int[]{1, 1, 1, 1, 2, 3, 4}, 1)
        );
    }
}