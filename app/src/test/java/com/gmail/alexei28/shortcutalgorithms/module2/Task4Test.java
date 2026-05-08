package com.gmail.alexei28.shortcutalgorithms.module2;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    /*
        Вход: arr = [1, 2, 3, 4, 5, 6]
        Выход: 3 (числа 2, 4, 6)
    */
    @Test
    void shouldReturnCountOfEvenNumber() {
        // Arrange
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        // Act
        int actual = new Task4().solution(arr);

        // Assert
        assertThat(actual).isEqualTo(3);
    }

    /*
        Вход: arr = [1, 3, 5, 7]
        Выход: 0
    */
    @Test
    void shouldReturnZeroWhenNotFoundEvenNumbers() {
        // Arrange
        int[] arr = new int[]{1, 3, 5, 7};

        // Act
        int actual = new Task4().solution(arr);

        // Assert
        assertThat(actual).isZero();
    }

    /*
       Вход: arr = []
       Выход: 0
   */
    @Test
    void shouldReturnZeroWhenArrayIsEmpty() {
        // Arrange
        int[] arr = new int[]{};

        // Act
        int actual = new Task4().solution(arr);

        // Assert
        assertThat(actual).isZero();
    }
}