package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    private Task4 task4;

    @BeforeEach
    void setUp() {
        task4 = new Task4();
    }

    @Test
    @DisplayName("Пример 1: Стандартный массив с дубликатами и пропущенными числами")
    void should_FindDisappearedNumbers_When_ArrayHasDuplicatesAndGaps() {
        // Arrange
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        // Act
        List<Integer> result = task4.findDisappearedNumbers(nums);

        // Assert
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(5, 6);
    }

    @Test
    @DisplayName("Пример 2: Массив из одинаковых элементов, где пропущена часть диапазона")
    void should_FindDisappearedNumbers_When_ArrayHasOnlyOnes() {
        // Arrange
        int[] nums = {1, 1};

        // Act
        List<Integer> result = task4.findDisappearedNumbers(nums);

        // Assert
        assertThat(result)
                .hasSize(1)
                .containsExactly(2);
    }

    @Test
    @DisplayName("Граничный случай: Пустой массив")
    void should_ReturnEmptyList_When_ArrayIsEmpty() {
        // Arrange
        int[] nums = {};

        // Act
        List<Integer> result = task4.findDisappearedNumbers(nums);

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Граничный случай: Массив из одного элемента (без пропусков)")
    void should_ReturnEmptyList_When_SingleElementArrayHasNoGaps() {
        // Arrange
        int[] nums = {1};

        // Act
        List<Integer> result = task4.findDisappearedNumbers(nums);

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Идеальный случай: Массив содержит все числа от 1 до n без дубликатов")
    void should_ReturnEmptyList_When_ArrayContainsAllNumbers() {
        // Arrange
        int[] nums = {1, 2, 3, 4, 5};

        // Act
        List<Integer> result = task4.findDisappearedNumbers(nums);

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Крайний случай: Пропущены все элементы, кроме одного")
    void should_FindAllOtherNumbers_When_ArrayContainsOnlyOneRepeatedNumber() {
        // Arrange
        int[] nums = {3, 3, 3, 3}; // n = 4, диапазон [1, 4]

        // Act
        List<Integer> result = task4.findDisappearedNumbers(nums);

        // Assert
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(1, 2, 4);
    }
}