package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task18Test {

    private Task18 task18;

    @BeforeEach
    void setUp() {
        task18 = new Task18();
    }

    @Test
    void findTheDifference_WhenExtraLetterAtTheEnd_ShouldReturnExtraLetter() {
        // Arrange
        String s = "abcd";
        String t = "abcde";

        // Act
        char result = task18.findTheDifference(s, t);

        // Assert
        assertThat(result)
                .as("The added letter should be 'e'")
                .isEqualTo('e');
    }

    @Test
    void findTheDifference_WhenSourceStringIsEmpty_ShouldReturnTheOnlyLetter() {
        // Arrange
        String s = "";
        String t = "y";

        // Act
        char result = task18.findTheDifference(s, t);

        // Assert
        assertThat(result)
                .as("If s is empty, the result must be the single character in t")
                .isEqualTo('y');
    }

    @Test
    void findTheDifference_WhenExtraLetterIsDuplicate_ShouldReturnCorrectDuplicate() {
        // Arrange
        String s = "aae";
        String t = "aaae"; // 'a' is added

        // Act
        char result = task18.findTheDifference(s, t);

        // Assert
        assertThat(result)
                .as("Should correctly identify the extra duplicate character")
                .isEqualTo('a');
    }

    @Test
    void findTheDifference_WhenStringsAreShuffled_ShouldFindTheAddedLetter() {
        // Arrange
        String s = "abc";
        String t = "bcap"; // 'p' is added and order is shuffled

        // Act
        char result = task18.findTheDifference(s, t);

        // Assert
        assertThat(result)
                .as("Should find the added letter regardless of shuffling")
                .isEqualTo('p');
    }
}