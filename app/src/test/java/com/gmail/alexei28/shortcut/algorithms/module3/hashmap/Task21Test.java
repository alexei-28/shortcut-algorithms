package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task21Test {

    private Task21 task;

    @BeforeEach
    void setUp() {
        task = new Task21();
    }

    @Test
    @DisplayName("Should return true when string strictly follows the abba pattern")
    void wordPattern_ValidPattern_ReturnsTrue() {
        // Arrange
        String pattern = "abba";
        String s = "dog cat cat dog";

        // Act
        boolean result = task.wordPattern(pattern, s);

        // Assert
        assertThat(result)
                .as("Pattern '%s' should match string '%s'", pattern, s)
                .isTrue();
    }

    @Test
    @DisplayName("Should return false when a pattern character maps to a different word")
    void wordPattern_MismatchingWord_ReturnsFalse() {
        // Arrange
        String pattern = "abba";
        String s = "dog cat cat fish";

        // Act
        boolean result = task.wordPattern(pattern, s);

        // Assert
        assertThat(result)
                .as("Pattern '%s' should not match string '%s' due to trailing mismatch", pattern, s)
                .isFalse();
    }

    @Test
    @DisplayName("Should return false when multiple pattern characters map to the same word")
    void wordPattern_DuplicateWordMapping_ReturnsFalse() {
        // Arrange
        String pattern = "aaaa";
        String s = "dog cat cat dog";

        // Act
        boolean result = task.wordPattern(pattern, s);

        // Assert
        assertThat(result)
                .as("Pattern '%s' should fail because 'a' cannot map to both 'dog' and 'cat'", pattern, s)
                .isFalse();
    }

    @Test
    @DisplayName("Should return false when lengths of pattern and words do not match")
    void wordPattern_LengthMismatch_ReturnsFalse() {
        // Arrange
        String pattern = "aaa";
        String s = "dog dog dog dog";

        // Act
        boolean result = task.wordPattern(pattern, s);

        // Assert
        assertThat(result)
                .as("Should fail immediately if pattern length doesn't match word count")
                .isFalse();
    }

    @Test
    @DisplayName("Should return false when different pattern characters map to the same word")
    void wordPattern_DifferentKeysSameValue_ReturnsFalse() {
        // Arrange
        String pattern = "abba";
        String s = "dog dog dog dog";

        // Act
        boolean result = task.wordPattern(pattern, s);

        // Assert
        assertThat(result)
                .as("Bijection requires unique keys to map to unique values")
                .isFalse();
    }
}