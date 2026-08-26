package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {

    private Task3 task;

    @BeforeEach
    void setUp() {
        task = new Task3();
    }

    @Test
    @DisplayName("Should return true when both strings produce identical text after backspaces")
    void backspaceCompare_WhenBothStringsEqualAfterBackspace_ReturnsTrue() {
        // Arrange
        String s = "ab#c";
        String t = "ad#c";

        // Act
        boolean result = task.backspaceCompare(s, t);

        // Assert
        assertThat(result)
                .as("Strings '%s' and '%s' should be equal after applying backspaces", s, t)
                .isTrue();
    }

    @Test
    @DisplayName("Should return true when all characters are erased by backspaces")
    void backspaceCompare_WhenAllCharactersErased_ReturnsTrue() {
        // Arrange
        String s = "ab##";
        String t = "c#d#";

        // Act
        boolean result = task.backspaceCompare(s, t);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should return false when resulting strings are different")
    void backspaceCompare_WhenResultingStringsDiffer_ReturnsFalse() {
        // Arrange
        String s = "a#c";
        String t = "b";

        // Act
        boolean result = task.backspaceCompare(s, t);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Should handle backspaces on empty strings without throwing exceptions")
    void backspaceCompare_WhenExtraBackspacesOnEmptyString_ReturnsTrue() {
        // Arrange
        String s = "a##b";
        String t = "#b";

        // Act
        boolean result = task.backspaceCompare(s, t);

        // Assert
        assertThat(result).isTrue();
    }

    @ParameterizedTest(name = "s=\"{0}\", t=\"{1}\" -> expected={2}")
    @CsvSource({
            "ab#c, ad#c, true",
            "ab##, c#d#, true",
            "a#c, b, false",
            "a##b, #b, true",
            "bxj##tw, bxj###tw, false",
            "#, #, true"
    })
    @DisplayName("Parameterized test for backspace string comparison")
    void backspaceCompare_ParameterizedCases(String s, String t, boolean expected) {
        // Arrange & Act
        boolean result = task.backspaceCompare(s, t);

        // Assert
        assertThat(result).isEqualTo(expected);
    }
}