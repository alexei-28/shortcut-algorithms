package com.gmail.alexei28.shortcutalgorithms.module2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {

    /*
       Должен вернуть индекс первого вхождения элемента в массиве
       Вход: arr = [1, 2, 3, 4, 5], value = 3
       Выход: 2
   */
    @Test
    void shouldReturnIndexFirstOccurrenceOfItem() {
        // Arrange
        int[] arr = new int[]{1, 2, 3, 4, 5};

        // Act
        int actual = new Task3().solution(arr, 3);

        // Assert
        assertThat(actual).isEqualTo(2);
    }

    /*
        Элемент не найден, должен вернуть -1
        Вход: arr = [1, 2, 3, 4, 5], value = 6
        Выход: -1
    */
    @Test
    void shouldReturnMinusOneIfItemNotFound() {
        // Arrange
        int[] arr = new int[]{1, 2, 3, 4, 5};

        // Act
        int actual = new Task3().solution(arr, 6);

        // Assert
        assertThat(actual).isEqualTo(-1);
    }

    /*
        Массив пустой. Элемент не найден, должен вернуть -1
        Вход: arr = [], value = 6
        Выход: -1
    */
    @Test
    void shouldReturnMinusOneIArrayIsEmpty() {
        // Arrange
        int[] arr = new int[]{};

        // Act
        int actual = new Task3().solution(arr, 6);

        // Assert
        assertThat(actual).isEqualTo(-1);
    }



}