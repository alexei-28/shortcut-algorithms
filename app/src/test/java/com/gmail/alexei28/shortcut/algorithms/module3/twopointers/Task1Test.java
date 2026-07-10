package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    private final Task1 task = new Task1();

    @Test
    void shouldReturnTrueForValidPalindromePhrase() {
        // Arrange
        String input = "A man, a plan, a canal: Panama";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseForNonPalindromePhrase() {
        // Arrange
        String input = "race a car";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrueForStringContainingOnlySpaces() {
        // Arrange
        String input = " ";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnTrueForSimplePalindrome() {
        // Arrange
        String input = "madam";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldIgnoreCase() {
        // Arrange
        String input = "MadAm";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldIgnoreNonAlphanumericCharacters() {
        // Arrange
        String input = ".,!@#$";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Timeout(unit = TimeUnit.SECONDS, value = 5)
    @Test
    void shouldHandleNumbersInPalindrome() {
        // Arrange
        String input = "12321";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldHandleMixedLettersAndNumbers() {
        // Arrange
        String input = "A1b2B1a";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseForMixedLettersAndNumbersWhenNotPalindrome() {
        // Arrange
        String input = "A1b2C1a";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrueForSingleCharacter() {
        // Arrange
        String input = "a";

        // Act
        boolean result = task.isPalindrome(input);

        // Assert
        assertThat(result).isTrue();
    }
}