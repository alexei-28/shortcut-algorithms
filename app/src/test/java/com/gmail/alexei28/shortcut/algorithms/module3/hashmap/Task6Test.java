package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6Test {

    private Task6 task;

    @BeforeEach
    void setUp() {
        task = new Task6();
    }

    @Test
    void maxFrequencyElements_SingleElementWithMaxFrequency_ReturnsFrequencyOfThatElement() {
        // Arrange
        int[] nums = {1, 2, 2, 3, 3, 3};
        int expected = 3; // Число 3 встречается 3 раза (макс. частота). Всего элементов с такой частотой: 3.

        // Act
        int actual = task.maxFrequencyElements(nums);

        // Assert
        assertEquals(expected, actual, "Должно возвращать суммарное количество элементов с максимальной частотой (один лидер)");
    }

    @Test
    void maxFrequencyElements_MultipleElementsWithMaxFrequency_ReturnsSumOfTheirFrequencies() {
        // Arrange
        int[] nums = {1, 2, 2, 3, 3};
        int expected = 4; // Числа 2 и 3 встречаются по 2 раза (макс. частота). Итого: 2 + 2 = 4.

        // Act
        int actual = task.maxFrequencyElements(nums);

        // Assert
        assertEquals(expected, actual, "Должно возвращать сумму частот всех элементов, имеющих максимальную частоту");
    }

    @Test
    void maxFrequencyElements_SingleElementArray_ReturnsOne() {
        // Arrange
        int[] nums = {5};
        int expected = 1;

        // Act
        int actual = task.maxFrequencyElements(nums);

        // Assert
        assertEquals(expected, actual, "Для массива из одного элемента результат всегда должен быть 1");
    }

    @Test
    void maxFrequencyElements_AllElementsUnique_ReturnsArrayLength() {
        // Arrange
        int[] nums = {10, 20, 30, 40};
        int expected = 4; // Все элементы имеют частоту 1. Макс. частота = 1. Элементов с такой частотой = 4.

        // Act
        int actual = task.maxFrequencyElements(nums);

        // Assert
        assertEquals(expected, actual, "Если все элементы уникальны, результат равен длине массива");
    }

    @Test
    void maxFrequencyElements_AllElementsIdentical_ReturnsArrayLength() {
        // Arrange
        int[] nums = {7, 7, 7, 7, 7};
        int expected = 5; // Одно число встречается 5 раз.

        // Act
        int actual = task.maxFrequencyElements(nums);

        // Assert
        assertEquals(expected, actual, "Если все элементы одинаковы, результат равен длине массива");
    }

    @Test
    void maxFrequencyElements_EmptyArray_ReturnsZero() {
        // Arrange
        int[] nums = {};
        int expected = 0;

        // Act
        int actual = task.maxFrequencyElements(nums);

        // Assert
        assertEquals(expected, actual, "Для пустого массива результат должен быть 0");
    }
}