package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HappyNumberTest {

    private HappyNumber happyNumber;

    @BeforeEach
    void setUp() {
        happyNumber = new HappyNumber();
    }

    @Test
    @DisplayName("Should return true for happy number 19")
    void isHappy_GivenHappyNumber19_ReturnsTrue() {
        // Arrange
        int input = 19;

        // Act
        boolean result = happyNumber.isHappy(input);

        // Assert
        assertThat(result)
                .as("19 is a happy number (1² + 9² = 82 → 8² + 2² = 68 → 6² + 8² = 100 → 1² + 0² + 0² = 1)")
                .isTrue();
    }

    @Test
    @DisplayName("Should return true for base happy number 1")
    void isHappy_GivenNumber1_ReturnsTrue() {
        // Arrange
        int input = 1;

        // Act
        boolean result = happyNumber.isHappy(input);

        // Assert
        assertThat(result)
                .as("1 is already a happy number")
                .isTrue();
    }

    @Test
    @DisplayName("Should return true for happy number 7")
    void isHappy_GivenHappyNumber7_ReturnsTrue() {
        // Arrange
        int input = 7;

        // Act
        boolean result = happyNumber.isHappy(input);

        // Assert
        assertThat(result)
                .as("7 is a happy number")
                .isTrue();
    }

    @Test
    @DisplayName("Should return false for non-happy number 2 (enters cycle)")
    void isHappy_GivenUnhappyNumber2_ReturnsFalse() {
        // Arrange
        int input = 2;

        // Act
        boolean result = happyNumber.isHappy(input);

        // Assert
        assertThat(result)
                .as("2 loops infinitely into a cycle that does not contain 1")
                .isFalse();
    }

    @Test
    @DisplayName("Should return false for non-happy number 4")
    void isHappy_GivenUnhappyNumber4_ReturnsFalse() {
        // Arrange
        int input = 4;

        // Act
        boolean result = happyNumber.isHappy(input);

        // Assert
        assertThat(result)
                .as("4 enters the standard un-happy cycle (4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4)")
                .isFalse();
    }
}