package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task17Test {

    private Task17 task17;

    @BeforeEach
    void setUp() {
        task17 = new Task17();
    }

    @Test
    void shouldReturnFalseWhenMagazineDoesNotContainRequiredLetters() {
        // Arrange
        String ransomNote = "a";
        String magazine = "b";

        // Act
        boolean result = task17.canConstruct(ransomNote, magazine);

        // Assert
        assertThat(result)
                .as("Should return false because 'b' cannot form 'a'")
                .isFalse();
    }

    @Test
    void shouldReturnFalseWhenMagazineHasInsufficientLetterCount() {
        // Arrange
        String ransomNote = "aa";
        String magazine = "ab";

        // Act
        boolean result = task17.canConstruct(ransomNote, magazine);

        // Assert
        assertThat(result)
                .as("Should return false because 'ab' only has one 'a' but 'aa' requires two")
                .isFalse();
    }

    @Test
    void shouldReturnTrueWhenMagazineHasExactOrExtraRequiredLetters() {
        // Arrange
        String ransomNote = "aa";
        String magazine = "aab";

        // Act
        boolean result = task17.canConstruct(ransomNote, magazine);

        // Assert
        assertThat(result)
                .as("Should return true because 'aab' contains two 'a's and one 'b'")
                .isTrue();
    }

    @Test
    void shouldReturnTrueWhenRansomNoteIsEmpty() {
        // Arrange
        String ransomNote = "";
        String magazine = "abc";

        // Act
        boolean result = task17.canConstruct(ransomNote, magazine);

        // Assert
        assertThat(result)
                .as("An empty ransom note can always be constructed")
                .isTrue();
    }
}