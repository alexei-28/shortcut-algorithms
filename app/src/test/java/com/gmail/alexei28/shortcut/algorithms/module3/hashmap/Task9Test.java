package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task9Test {

    private Task9 task;

    @BeforeEach
    void setUp() {
        task = new Task9();
    }

    @Test
    void firstUniqChar_shouldReturnIndex_whenFirstUniqueIsAtStart() {
        // Arrange
        String input = "leetcode";

        // Act
        int result = task.firstUniqChar(input);

        // Assert
        assertThat(result)
                .as("The first unique character is 'l' at index 0")
                .isEqualTo(0);
    }

    @Test
    void firstUniqChar_shouldReturnIndex_whenFirstUniqueIsInMiddle() {
        // Arrange
        String input = "loveleetcode";

        // Act
        int result = task.firstUniqChar(input);

        // Assert
        assertThat(result)
                .as("The first unique character is 'v' at index 2")
                .isEqualTo(2);
    }

    @Test
    void firstUniqChar_shouldReturnMinusOne_whenNoUniqueCharactersExist() {
        // Arrange
        String input = "aabb";

        // Act
        int result = task.firstUniqChar(input);

        // Assert
        assertThat(result)
                .as("There are no unique characters, should return -1")
                .isEqualTo(-1);
    }

    @Test
    void firstUniqChar_shouldReturnZero_whenStringHasOnlyOneCharacter() {
        // Arrange
        String input = "z";

        // Act
        int result = task.firstUniqChar(input);

        // Assert
        assertThat(result)
                .as("A single character string should return index 0")
                .isEqualTo(0);
    }

    @Test
    void firstUniqChar_shouldReturnLastIndex_whenUniqueCharacterIsAtTheEnd() {
        // Arrange
        String input = "abcabcx";

        // Act
        int result = task.firstUniqChar(input);

        // Assert
        assertThat(result)
                .as("The only unique character is 'x' at the very end")
                .isEqualTo(6);
    }

    @Test
    void firstUniqChar_shouldReturnMinusOne_whenStringIsEmpty() {
        // Arrange
        String input = "";

        // Act
        int result = task.firstUniqChar(input);

        // Assert
        assertThat(result)
                .as("An empty string has no unique characters, should return -1")
                .isEqualTo(-1);
    }
}