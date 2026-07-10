package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

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
    @DisplayName("Example 1: Standard string with repeating patterns")
    void should_ReturnThree_When_InputIsAbcabcbb() {
        // Arrange
        String input = "abcabcbb";

        // Act
        int result = task.lengthOfLongestSubstring(input);

        // Assert
        assertThat(result)
                .as("The longest substring without repeating characters should be 'abc' (length 3)")
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Example 2: String with all identical characters")
    void should_ReturnOne_When_InputIsAllIdenticalCharacters() {
        // Arrange
        String input = "bbbbb";

        // Act
        int result = task.lengthOfLongestSubstring(input);

        // Assert
        assertThat(result)
                .as("The longest substring without repeating characters should be 'b' (length 1)")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Example 3: Substring interspersed with duplicates")
    void should_ReturnThree_When_InputIsPwwkew() {
        // Arrange
        String input = "pwwkew";

        // Act
        int result = task.lengthOfLongestSubstring(input);

        // Assert
        assertThat(result)
                .as("The longest substring without repeating characters should be 'wke' (length 3)")
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Edge Case: Empty string")
    void should_ReturnZero_When_InputIsEmpty() {
        // Arrange
        String input = "";

        // Act
        int result = task.lengthOfLongestSubstring(input);

        // Assert
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("Edge Case: Single character string")
    void should_ReturnOne_When_InputIsSingleCharacter() {
        // Arrange
        String input = "a";

        // Act
        int result = task.lengthOfLongestSubstring(input);

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest(name = "Input \"{0}\" should yield length {1}")
    @CsvSource({
            "' ', 1",          // Single space
            "'au', 2",         // All unique characters
            "'dvdf', 3",       // Requires left pointer to jump forward correctly
            "'abba', 2",       // Left pointer must not move backward to an old index
            "'abcdef', 6"      // Entire string is unique
    })
    @DisplayName("Parameterized cases for complex sliding window adjustments")
    void should_ReturnExpectedLength_For_VariousInputs(String input, int expectedLength) {
        // Act
        int result = task.lengthOfLongestSubstring(input);

        // Assert
        assertThat(result).isEqualTo(expectedLength);
    }
}