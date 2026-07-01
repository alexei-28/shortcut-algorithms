package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @Test
    void shouldReturnMaxSumOfSubArrayForStandardCase() {
        // Arrange (Подготовка данных и окружения)
        Task1 task = new Task1();
        int[] array = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int subArrayLength = 4;
        // Ожидаемый результат: подмассив [4, 2, 10, 23] дает сумму 39
        int expectedSum = 39;

        // Act (Выполнение целевого действия)
        int actualSum = task.maxSumSubArray(array, subArrayLength);

        // Assert (Проверка результата с помощью AssertJ)
        assertThat(actualSum)
                .as("Максимальная сумма подмассива длины %d должна быть равна %d", subArrayLength, expectedSum)
                .isEqualTo(expectedSum);
    }

    @Test
    void shouldReturnSingleLargestElementWhenSubArrayLengthIsOne2() {
        // Arrange
        int[] array = {3, 7, 2, 9, 1};
        int subArrayLength = 1;
        Task1 task = new Task1();

        // Act
        int result = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(result).isEqualTo(9);
    }

    @Test
    void shouldReturnArraySumWhenSubArrayLengthEqualsArrayLength() {
        // Arrange
        int[] array = {2, 4, 6};
        int subArrayLength = 3;
        Task1 task = new Task1();

        // Act
        int result = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(result).isEqualTo(12);
    }

    @Test
    void shouldReturnSingleLargestElementWhenSubArrayLengthIsOne() {
        // Arrange
        int[] array = {3, 7, 2, 9, 1};
        int subArrayLength = 1;
        Task1 task = new Task1();


        // Act
        int result = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(result).isEqualTo(9);
    }

    @Test
    void shouldHandleNegativeNumbers() {
        // Arrange
        int[] array = {-8, -3, -6, -2, -5, -4};
        int subArrayLength = 2;
        Task1 task = new Task1();


        // Act
        int result = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(result).isEqualTo(-7);
    }

    @Test
    void shouldHandleMixedPositiveAndNegativeNumbers() {
        // Arrange
        int[] array = {-2, 5, -1, 3, -4, 2};
        int subArrayLength = 2;
        Task1 task = new Task1();


        // Act
        int result = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(result).isEqualTo(4);
    }

    @Test
    void shouldReturnZeroIfSubArrayLengthIsGreaterThanArrayLength() {
        // Arrange
        Task1 task = new Task1();
        int[] array = {1, 2, 3};
        int subArrayLength = 5;

        // Act
        int actualSum = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(actualSum).isZero();
    }

    @Test
    void shouldReturnZeroIfArrayIsEmpty() {
        // Arrange
        Task1 task = new Task1();
        int[] array = {};
        int subArrayLength = 2;

        // Act
        int actualSum = task.maxSumSubArray(array, subArrayLength);

        // Assert
        assertThat(actualSum).isZero();
    }
}