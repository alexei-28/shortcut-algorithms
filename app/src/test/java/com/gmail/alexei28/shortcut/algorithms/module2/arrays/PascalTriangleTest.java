package com.gmail.alexei28.shortcut.algorithms.module2.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PascalTriangleTest {

    private PascalTriangle pascalTriangle;

    @BeforeEach
    void setUp() {
        pascalTriangle = new PascalTriangle();
    }

    @Test
    @DisplayName("Should return empty list when numRows is 0")
    void shouldReturnEmptyListWhenNumRowsIsZero() {
        // Arrange
        int numRows = 0;

        // Act
        List<List<Integer>> result = pascalTriangle.generate(numRows);

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Should return single row when numRows is 1")
    void shouldReturnSingleRowWhenNumRowsIsOne() {
        // Arrange
        int numRows = 1;
        List<List<Integer>> expected = List.of(
                List.of(1)
        );

        // Act
        List<List<Integer>> result = pascalTriangle.generate(numRows);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(1)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return first 2 rows when numRows is 2")
    void shouldReturnTwoRowsWhenNumRowsIsTwo() {
        // Arrange
        int numRows = 2;
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(1, 1)
        );

        // Act
        List<List<Integer>> result = pascalTriangle.generate(numRows);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return first 5 rows for standard input")
    void shouldReturnFiveRowsWhenNumRowsIsFive() {
        // Arrange
        int numRows = 5;
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
        );

        // Act
        List<List<Integer>> result = pascalTriangle.generate(numRows);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(5)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Should satisfy basic Pascal Triangle structural properties for 5 rows")
    void shouldVerifyStructuralProperties() {
        // Arrange
        int numRows = 5;

        // Act
        List<List<Integer>> result = pascalTriangle.generate(numRows);

        // Assert
        assertThat(result)
                .isNotNull()
                .allSatisfy(row -> {
                    assertThat(row.get(0)).isEqualTo(1);
                    assertThat(row.get(row.size() - 1)).isEqualTo(1);
                });

        // Verify element count increases by 1 for each row (1, 2, 3, 4, 5 elements)
        assertThat(result)
                .extracting(List::size)
                .containsExactly(1, 2, 3, 4, 5);
    }
}