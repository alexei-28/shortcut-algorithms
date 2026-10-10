package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    private Task1 task1;

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @Nested
    @DisplayName("LeetCode Examples")
    class LeetCodeExamples {

        @Test
        @DisplayName("Should find index of target when present in array (Example 1)")
        void search_WhenTargetExists_ReturnsCorrectIndex() {
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 9;

            int result = task1.search(nums, target);

            assertThat(result).isEqualTo(4);
        }

        @Test
        @DisplayName("Should return -1 when target is missing (Example 2)")
        void search_WhenTargetDoesNotExist_ReturnsMinusOne() {
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 2;

            int result = task1.search(nums, target);

            assertThat(result).isEqualTo(-1);
        }
    }

    @Nested
    @DisplayName("Boundary and Edge Cases")
    class BoundaryCases {

        @Test
        @DisplayName("Single element array - target exists")
        void search_SingleElement_TargetFound() {
            int[] nums = {5};
            assertThat(task1.search(nums, 5)).isEqualTo(0);
        }

        @Test
        @DisplayName("Single element array - target missing")
        void search_SingleElement_TargetNotFound() {
            int[] nums = {5};
            assertThat(task1.search(nums, 10)).isEqualTo(-1);
        }

        @Test
        @DisplayName("Two elements array - target is first element")
        void search_TwoElements_FirstElement() {
            int[] nums = {2, 5};
            assertThat(task1.search(nums, 2)).isEqualTo(0);
        }

        @Test
        @DisplayName("Two elements array - target is second element")
        void search_TwoElements_SecondElement() {
            int[] nums = {2, 5};
            assertThat(task1.search(nums, 5)).isEqualTo(1);
        }

        @Test
        @DisplayName("Target is smaller than all elements in array")
        void search_TargetSmallerThanMin_ReturnsMinusOne() {
            int[] nums = {10, 20, 30, 40};
            assertThat(task1.search(nums, 5)).isEqualTo(-1);
        }

        @Test
        @DisplayName("Target is larger than all elements in array")
        void search_TargetLargerThanMax_ReturnsMinusOne() {
            int[] nums = {10, 20, 30, 40};
            assertThat(task1.search(nums, 50)).isEqualTo(-1);
        }

        @Test
        @DisplayName("Target at first position (index 0)")
        void search_TargetAtStart_ReturnsZero() {
            int[] nums = {-10, -3, 0, 5, 9, 12, 15};
            assertThat(task1.search(nums, -10)).isEqualTo(0);
        }

        @Test
        @DisplayName("Target at last position (index n-1)")
        void search_TargetAtEnd_ReturnsLastIndex() {
            int[] nums = {-10, -3, 0, 5, 9, 12, 15};
            assertThat(task1.search(nums, 15)).isEqualTo(6);
        }
    }

    @ParameterizedTest(name = "[{index}] nums={0}, target={1} -> expectedIndex={2}")
    @MethodSource("provideSearchCases")
    @DisplayName("Parameterized search verification across various array configurations")
    void search_ParameterizedTests(int[] nums, int target, int expected) {
        int actual = task1.search(nums, target);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSearchCases() {
        return Stream.of(
                // Odd length array search positions
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 1, 0),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 9, 4),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 4, -1),

                // Even length array search positions
                Arguments.of(new int[]{1, 3, 5, 7}, 1, 0),
                Arguments.of(new int[]{1, 3, 5, 7}, 3, 1),
                Arguments.of(new int[]{1, 3, 5, 7}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 7}, 7, 3),
                Arguments.of(new int[]{1, 3, 5, 7}, 6, -1),

                // Large values / Negative values
                Arguments.of(new int[]{-100, -50, -10, -2, 0}, -50, 1),
                Arguments.of(new int[]{Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE, 3)
        );
    }
}