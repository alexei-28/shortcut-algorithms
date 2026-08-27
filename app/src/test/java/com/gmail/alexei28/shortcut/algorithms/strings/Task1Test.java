package com.gmail.alexei28.shortcut.algorithms.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    private Task1 task1;

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @Test
    @DisplayName("Should return true for valid mirror string 'AspPSa'")
    void isMirror_ValidMirrorString_ReturnsTrue() {
        // Arrange
        String input = "AspPSa";

        // Act
        boolean result = task1.isMirror(input);

        // Assert
        assertThat(result)
                .as("Checking if '%s' is recognized as a valid mirror string", input)
                .isTrue();
    }

    @Test
    @DisplayName("Should return true for valid mirror string 'aspPSA'")
    void isMirror_AnotherValidMirrorString_ReturnsTrue() {
        // Arrange
        String input = "aspPSA";

        // Act
        boolean result = task1.isMirror(input);

        // Assert
        assertThat(result)
                .as("Checking if '%s' is recognized as a valid mirror string", input)
                .isTrue();
    }

    @Test
    @DisplayName("Should return false for invalid string 'Ajsldfjl'")
    void isMirror_InvalidString_ReturnsFalse() {
        // Arrange
        String input = "Ajsldfjl";

        // Act
        boolean result = task1.isMirror(input);

        // Assert
        assertThat(result)
                .as("Checking if '%s' is recognized as an invalid string", input)
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aA", "AbCdefFEDcBa", "xYzZyX"})
    @DisplayName("Should return true for various valid case-inverted mirror strings")
    void isMirror_ParameterizedValidCases_ReturnsTrue(String input) {
        // Arrange
        // (Input provided by @ValueSource)

        // Act
        boolean result = task1.isMirror(input);

        // Assert
        assertThat(result)
                .as("String '%s' should be valid", input)
                .isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"AspPSab"})
    @DisplayName("Should return false for invalid input")
    void isMirror_InvalidInput_ReturnsFalse(String input) {
        // Arrange

        // Act
        boolean result = task1.isMirror(input);

        // Assert
        assertThat(result).isFalse();
    }
}
