package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task8Test {

    private Task8 task8;

    @BeforeEach
    void setUp() {
        task8 = new Task8();
    }

    @Test
    @DisplayName("Should return true when strings are valid anagrams")
    void shouldReturnTrueWhenStringsAreValidAnagrams() {
        // Arrange
        String s = "anagram";
        String t = "nagaram";

        // Act
        boolean result = task8.isAnagram(s, t);

        // Assert
        assertThat(result)
                .as("Strings '%s' and '%s' should be anagrams", s, t)
                .isTrue();
    }

    @Test
    @DisplayName("Should return false when strings have same length but different characters")
    void shouldReturnFalseWhenStringsHaveSameLengthButDifferentCharacters() {
        // Arrange
        String s = "rat";
        String t = "cat";

        // Act
        boolean result = task8.isAnagram(s, t);

        // Assert
        assertThat(result)
                .as("Strings '%s' and '%s' should not be anagrams", s, t)
                .isFalse();
    }

    @Test
    @DisplayName("Should return false when strings have different lengths")
    void shouldReturnFalseWhenStringsHaveDifferentLengths() {
        // Arrange
        String s = "hello";
        String t = "helloo";

        // Act
        boolean result = task8.isAnagram(s, t);

        // Assert
        assertThat(result)
                .as("Strings with different lengths cannot be anagrams")
                .isFalse();
    }

    @Test
    @DisplayName("Should return true when both strings are empty")
    void shouldReturnTrueWhenBothStringsAreEmpty() {
        // Arrange
        String s = "";
        String t = "";

        // Act
        boolean result = task8.isAnagram(s, t);

        // Assert
        assertThat(result)
                .as("Two empty strings should be considered anagrams")
                .isTrue();
    }

    @Test
    @DisplayName("Should return false when character frequencies do not match exactly")
    void shouldReturnFalseWhenFrequenciesDoNotMatch() {
        // Arrange
        String s = "aacc";
        String t = "ccca";

        // Act
        boolean result = task8.isAnagram(s, t);

        // Assert
        assertThat(result)
                .as("Strings with mismatching character frequencies should not be anagrams")
                .isFalse();
    }
}