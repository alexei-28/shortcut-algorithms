package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Task5Test {

    @Test
    void shouldReverseCharsWithOddCount() {
        // Arrange
        char[] sourceArr = new char[] {'h', 'e', 'l', 'l', 'o'};
        char[] expectedArr = new char[] {'o', 'l', 'l', 'e', 'h'};

        // Act
        char[] actual = new Task5().solution(sourceArr);

        // Assert
        assertThat(actual).isEqualTo(expectedArr);
    }

    @Test
    void shouldReverseCharsWithEvenCount() {
        // Arrange
        char[] sourceArr = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] expectedArr = new char[] {'h', 'a', 'n', 'n', 'a', 'H'};

        // Act
        char[] actual = new Task5().solution(sourceArr);

        // Assert
        assertThat(actual).isEqualTo(expectedArr);
    }

    @Test
    void shouldReturnEmptyArrayWhenInputArrayIsEmpty() {
        // Arrange
        char[] sourceArr = new char[] {};
        char[] expectedArr = new char[] {};

        // Act
        char[] actual = new Task5().solution(sourceArr);

        // Assert
        assertThat(actual).isEqualTo(expectedArr);
    }

    @Test
    void shouldBeSameArrays() {
        // Arrange
        char[] sourceArr = new char[] {'a', 'a', 'a', 'a', 'a', 'a'};
        char[] expectedArr = new char[] {'a', 'a', 'a', 'a', 'a', 'a'};

        // Act
        char[] actual = new Task5().solution(sourceArr);

        // Assert
        assertThat(actual).isEqualTo(expectedArr);
    }
}