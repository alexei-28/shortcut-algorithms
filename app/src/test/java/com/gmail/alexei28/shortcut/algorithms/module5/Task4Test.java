package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    private Task4 task4;

    @BeforeEach
    void setUp() {
        task4 = new Task4();
    }

    @Test
    @DisplayName("Example 1: Should find pick = 6 when n = 10")
    void guessNumber_Example1() {
        // Arrange
        int n = 10;
        int expectedPick = 6;
        task4.pick = expectedPick;

        // Act
        int actualPick = task4.guessNumber(n);

        // Assert
        assertThat(actualPick)
                .as("Should return the picked number when n = %d and pick = %d", n, expectedPick)
                .isEqualTo(expectedPick);
    }

    @Test
    @DisplayName("Example Big number: Should find pick = 1702766719 when n = 2126753390")
    void guessNumber_Example_BigNumber() {
        // Arrange
        int n = 2126753390;
        int expectedPick = 1702766719;
        task4.pick = expectedPick;

        // Act
        int actualPick = task4.guessNumber(n);

        // Assert
        assertThat(actualPick)
                .as("Should return the picked number when n = %d and pick = %d", n, expectedPick)
                .isEqualTo(expectedPick);
    }

    @Test
    @DisplayName("Example 2: Should find pick = 1 when n = 1")
    void guessNumber_Example2() {
        // Arrange
        int n = 1;
        int expectedPick = 1;
        task4.pick = expectedPick;

        // Act
        int actualPick = task4.guessNumber(n);

        // Assert
        assertThat(actualPick)
                .as("Should handle single-element range where pick is 1")
                .isEqualTo(expectedPick);
    }

    @Test
    @DisplayName("Example 3: Should find pick = 1 when n = 2")
    void guessNumber_Example3() {
        // Arrange
        int n = 2;
        int expectedPick = 1;
        task4.pick = expectedPick;

        // Act
        int actualPick = task4.guessNumber(n);

        // Assert
        assertThat(actualPick)
                .as("Should return lower bound when n = 2 and pick = 1")
                .isEqualTo(expectedPick);
    }

    @Test
    @DisplayName("Boundary Test: Should find pick = n (upper boundary)")
    void guessNumber_PickIsUpperBoundary() {
        // Arrange
        int n = 10;
        int expectedPick = 10;
        task4.pick = expectedPick;

        // Act
        int actualPick = task4.guessNumber(n);

        // Assert
        assertThat(actualPick)
                .as("Should find target when pick is the maximum boundary n")
                .isEqualTo(expectedPick);
    }
}