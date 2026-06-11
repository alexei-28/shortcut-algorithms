package com.gmail.alexei28.shortcut.algorithms.module3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task22Test {

    private Task22 task22;

    @BeforeEach
    void setUp() {
        task22 = new Task22();
    }

    @Test
    @DisplayName("Should return true when strings are isomorphic (e.g., egg -> add)")
    void shouldReturnTrueWhenStringsAreIsomorphic() {
        // Arrange
        String s = "egg";
        String t = "add";

        // Act
        boolean result = task22.isIsomorphic(s, t);

        // Assert
        assertThat(result)
                .as("Strings '%s' and '%s' should be isomorphic", s, t)
                .isTrue();
    }

    @Test
    @DisplayName("Should return false when one character maps to multiple characters")
    void shouldReturnFalseWhenCharacterMapsToMultiple() {
        // Arrange
        String s = "f11";
        String t = "b23";

        // Act
        boolean result = task22.isIsomorphic(s, t);

        // Assert
        assertThat(result)
                .as("Strings '%s' and '%s' should not be isomorphic because '1' maps to both '2' and '3'", s, t)
                .isFalse();
    }

    @Test
    @DisplayName("Should return true for longer isomorphic strings (e.g., paper -> title)")
    void shouldReturnTrueForLongerIsomorphicStrings() {
        // Arrange
        String s = "paper";
        String t = "title";

        // Act
        boolean result = task22.isIsomorphic(s, t);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should return true for single character strings")
    void shouldReturnTrueForSingleCharacterStrings() {
        // Arrange
        String s = "a";
        String t = "b";

        // Act
        boolean result = task22.isIsomorphic(s, t);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should return false when different characters map to the same character")
    void shouldReturnFalseWhenDifferentCharactersMapToSameCharacter() {
        // Arrange
        String s = "bad";
        String t = "bab"; // Both 'd' and 'b' would try to map to 'b'

        // Act
        boolean result = task22.isIsomorphic(s, t);

        // Assert
        // NOTE: This test will currently FAIL with your original implementation due to the bug mentioned above.
        assertThat(result)
                .as("Strings '%s' and '%s' should not be isomorphic because 'b' and 'd' both map to 'b'", s, t)
                .isFalse();
    }
}