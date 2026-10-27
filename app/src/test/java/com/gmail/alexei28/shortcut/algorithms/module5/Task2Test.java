package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    private Task2 solution;

    @BeforeEach
    void setUp() {
        solution = new Task2();
    }

    @ParameterizedTest(name = "nums={0}, target={1} -> expected index={2}")
    @MethodSource("provideTestCases")
    @DisplayName("Should return target index or correct insertion index")
    void searchInsert_ShouldReturnExpectedIndex(int[] nums, int target, int expectedIndex) {
        int actualIndex = solution.searchInsert(nums, target);

        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // Standard LeetCode Examples
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2), // Target present in middle
                Arguments.of(new int[]{1, 3, 5, 6}, 2, 1), // Target absent, insert in middle
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4), // Target absent, insert at end

                // Boundary Cases: Target outside array range
                Arguments.of(new int[]{1, 3, 5, 6}, 0, 0), // Target smaller than all elements
                Arguments.of(new int[]{1, 3, 5, 6}, 6, 3), // Target present at last element

                // Boundary Cases: Single element array
                Arguments.of(new int[]{5}, 5, 0), // Single element, matches target
                Arguments.of(new int[]{5}, 2, 0), // Single element, target smaller
                Arguments.of(new int[]{5}, 8, 1), // Single element, target larger

                // Two-element array
                Arguments.of(new int[]{1, 3}, 0, 0), // Insert before start
                Arguments.of(new int[]{1, 3}, 1, 0), // Match first
                Arguments.of(new int[]{1, 3}, 2, 1), // Insert between
                Arguments.of(new int[]{1, 3}, 3, 1), // Match second
                Arguments.of(new int[]{1, 3}, 4, 2)  // Insert after end
        );
    }

    @Test
    @DisplayName("Should correctly locate target at the exact first index")
    void searchInsert_TargetAtFirstIndex() {
        int[] nums = {10, 20, 30, 40, 50};
        int target = 10;

        int result = solution.searchInsert(nums, target);

        assertThat(result).isZero();
    }

    @Test
    @DisplayName("Should correctly locate target at the exact middle index")
    void searchInsert_TargetAtMiddleIndex() {
        int[] nums = {10, 20, 30, 40, 50};
        int target = 30;

        int result = solution.searchInsert(nums, target);

        assertThat(result).isEqualTo(2);
    }
}