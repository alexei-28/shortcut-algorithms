package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    @Test
    @DisplayName("Should find picked number when n = 10 and pick = 6")
    void shouldFindPickedNumberStandardCase() {
        // Arrange
        int n = 10;
        int pick = 6;
        Task4 task4 = new Task4(pick);

        // Act
        int actual = task4.guessNumber(n);

        // Assert
        assertThat(actual)
                .as("Should correctly identify the picked number from 1 to %d", n)
                .isEqualTo(pick);
    }

    @ParameterizedTest(name = "n = {0}, pick = {1}")
    @CsvSource({
            "10, 6",
            "1, 1",
            "2, 1",
            "2, 2",
            "2147483647, 1702766719"
    })
    @DisplayName("Should guess number correctly across various ranges and pick values")
    void shouldGuessNumberCorrectly(int n, int pick) {
        // Arrange
        Task4 task4 = new Task4(pick);

        // Act
        int actual = task4.guessNumber(n);

        // Assert
        assertThat(actual).isEqualTo(pick);
    }
}