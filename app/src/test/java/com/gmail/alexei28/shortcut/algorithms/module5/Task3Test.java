package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {

    private Task3 solution;

    @BeforeEach
    void setUp() {
        solution = new Task3();
    }

    @Test
    @DisplayName("Should return 0 when input x is 0")
    void mySqrt_zeroInput_returnsZero() {
        // Arrange
        int x = 0;

        // Act
        int result = solution.mySqrt(x);

        // Assert
        assertThat(result)
                .as("Square root of 0 should be 0")
                .isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 1 when input x is 1")
    void mySqrt_oneInput_returnsOne() {
        // Arrange
        int x = 1;

        // Act
        int result = solution.mySqrt(x);

        // Assert
        assertThat(result)
                .as("Square root of 1 should be 1")
                .isEqualTo(1);
    }

    @ParameterizedTest(name = "sqrt({0}) rounded down should be {1}")
    @CsvSource({
            "0, 0",
            "4, 2",
            "8, 2",
            "9, 3",
            "15, 3",
            "16, 4",
            "2147395599, 46339", // Testing near max non-overflow square
            "2147483647, 46340"  // Integer.MAX_VALUE
    })
    @DisplayName("Should return correct integer square root rounded down for various inputs")
    void mySqrt_validInputs_returnsRoundedDownSquareRoot(int x, int expected) {
        // Arrange & Act
        int result = solution.mySqrt(x);

        // Assert
        assertThat(result)
                .as("Square root of %d should round down to %d", x, expected)
                .isEqualTo(expected);
    }
}