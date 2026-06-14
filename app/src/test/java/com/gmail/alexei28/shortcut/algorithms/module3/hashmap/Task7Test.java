package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование задачи Two Sum (Task7)")
class Task7Test {

    private Task7 task7;

    @BeforeEach
    void setUp() {
        task7 = new Task7();
    }

    @Test
    @DisplayName("Должен найти индексы для базового примера из условия")
    void shouldFindIndicesForBasicExample() {
        // Arrange (Подготовка данных)
        int[] nums = {2, 4, 11, 3};
        int target = 6;

        // Act (Выполнение действия)
        int[] result = task7.twoSum(nums, target);

        // Assert (Проверка результата с помощью AssertJ)
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .containsExactlyInAnyOrder(0, 1);
    }

    @Test
    @DisplayName("Должен корректно работать, когда элементы стоят в конце массива")
    void shouldFindIndicesWhenTargetElementsAreAtTheEnd() {
        // Arrange
        int[] nums = {3, 2, 4};
        int target = 6;

        // Act
        int[] result = task7.twoSum(nums, target);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .containsExactlyInAnyOrder(1, 2);
    }

    @Test
    @DisplayName("Должен корректно работать с одинаковыми числами (дубликатами)")
    void shouldFindIndicesWithDuplicateNumbers() {
        // Arrange
        int[] nums = {3, 3};
        int target = 6;

        // Act
        int[] result = task7.twoSum(nums, target);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .containsExactlyInAnyOrder(0, 1);
    }

    @Test
    @DisplayName("Должен находить индексы, если массив содержит отрицательные числа")
    void shouldFindIndicesWithNegativeNumbers() {
        // Arrange
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;

        // Act
        int[] result = task7.twoSum(nums, target);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .containsExactlyInAnyOrder(2, 4); // -3 + (-5) = -8
    }

    @Test
    @DisplayName("Должен находить индексы, если одно из чисел равно нулю")
    void shouldFindIndicesWithZero() {
        // Arrange
        int[] nums = {0, 4, 3, 0};
        int target = 0;

        // Act
        int[] result = task7.twoSum(nums, target);

        // Assert
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .containsExactlyInAnyOrder(0, 3);
    }


}