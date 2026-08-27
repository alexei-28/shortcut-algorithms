package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    private Task1 task1;

    @BeforeEach
    void setUp() {
        task1 = new Task1();
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "()[]{}", "([])", "((({{{[[]]}}})))"})
    @DisplayName("Should return true for valid parentheses combinations")
    void isValid_ShouldReturnTrue_WhenParenthesesAreValid(String input) {
        // Arrange
        // (Input provided by ParameterizedTest)

        // Act
        boolean result = task1.isValid(input);

        // Assert
        assertThat(result)
                .as("String '%s' should be valid", input)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"(]", "([)]", "]", "((", "}}{{"})
    @DisplayName("Should return false for invalid parentheses combinations")
    void isValid_ShouldReturnFalse_WhenParenthesesAreInvalid(String input) {
        // Arrange
        // (Input provided by ParameterizedTest)

        // Act
        boolean result = task1.isValid(input);

        // Assert
        assertThat(result)
                .as("String '%s' should be invalid", input)
                .isFalse();
    }
}