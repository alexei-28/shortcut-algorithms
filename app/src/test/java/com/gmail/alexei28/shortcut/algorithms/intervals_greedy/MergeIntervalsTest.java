package com.gmail.alexei28.shortcut.algorithms.intervals_greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeIntervalsTest {

    private MergeIntervals mergeIntervals;

    @BeforeEach
    void setUp() {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    @DisplayName("Should merge overlapping intervals")
    void merge_overlappingIntervals_returnsMergedList() {
        // Arrange
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result)
                .as("Overlapping intervals should be combined correctly")
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should merge touching intervals at boundary points")
    void merge_touchingIntervals_returnsMergedInterval() {
        // Arrange
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should sort and merge unordered input intervals")
    void merge_unorderedIntervals_returnsSortedAndMergedList() {
        // Arrange
        int[][] intervals = {{4, 7}, {1, 4}};
        int[][] expected = {{1, 7}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle single interval input")
    void merge_singleInterval_returnsSameInterval() {
        // Arrange
        int[][] intervals = {{1, 5}};
        int[][] expected = {{1, 5}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should return unchanged list when no intervals overlap")
    void merge_disjointIntervals_returnsOriginalIntervals() {
        // Arrange
        int[][] intervals = {{1, 2}, {4, 5}, {7, 8}};
        int[][] expected = {{1, 2}, {4, 5}, {7, 8}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should merge completely nested/contained intervals")
    void merge_nestedIntervals_returnsOuterInterval() {
        // Arrange
        int[][] intervals = {{1, 10}, {2, 6}, {3, 5}};
        int[][] expected = {{1, 10}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should merge multiple intervals into a single combined interval")
    void merge_chainOfOverlappingIntervals_returnsSingleMergedInterval() {
        // Arrange
        int[][] intervals = {{1, 4}, {2, 5}, {4, 7}, {6, 9}};
        int[][] expected = {{1, 9}};

        // Act
        int[][] result = mergeIntervals.merge(intervals);

        // Assert
        assertThat(result).isDeepEqualTo(expected);
    }
}