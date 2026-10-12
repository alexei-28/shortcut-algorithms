package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Task6Test {

    private Task6 task6;

    @BeforeEach
    void setUp() {
        // Arrange
        task6 = new Task6();
    }

    @Test
    @DisplayName("Example 1: Target exists in a rotated array")
    void testSearch_whenTargetExistsInRotatedArray_returnsCorrectIndex() {
        // Arrange
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expectedIndex = 4;

        // Act
        int actualIndex = task6.search(nums, target);

        // Assert
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("Example 2: Target does not exist in a rotated array")
    void testSearch_whenTargetDoesNotExist_returnsNegativeOne() {
        // Arrange
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expectedIndex = -1;

        // Act
        int actualIndex = task6.search(nums, target);

        // Assert
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("Example 3: Single element array where target is not present")
    void testSearch_singleElementArrayNotFound_returnsNegativeOne() {
        // Arrange
        int[] nums = {1};
        int target = 0;
        int expectedIndex = -1;

        // Act
        int actualIndex = task6.search(nums, target);

        // Assert
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @ParameterizedTest(name = "nums = {0}, target = {1} -> expected index = {2}")
    @MethodSource("provideRotatedArrayTestData")
    @DisplayName("Parameterized test for various rotated array scenarios")
    void testSearch_withVariousScenarios(int[] nums, int target, int expectedIndex) {
        // Act
        int actualIndex = task6.search(nums, target);

        // Assert
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    private static Stream<Arguments> provideRotatedArrayTestData() {
        return Stream.of(
                // Target is a single element and matches
                Arguments.of(new int[]{1}, 1, 0),
                // Target is at the beginning of the rotated array
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0),
                // Target is at the end of the rotated array
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6),
                // Array not rotated (rotated by 0 conceptually)
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, 2),
                // Two elements, rotated
                Arguments.of(new int[]{3, 1}, 1, 1),
                // Two elements, not rotated
                Arguments.of(new int[]{1, 3}, 3, 1)
        );
    }
}