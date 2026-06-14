package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task5Test {

    private Task5 task5;

    @BeforeEach
    void setUp() {
        task5 = new Task5();
    }

    @Test
    @DisplayName("Должен вернуть 3, когда есть 3 драгоценных камня (пример 1)")
    void shouldReturnThreeWhenThreeJewelsExist() {
        // Arrange (Подготовка)
        String jewels = "aA";
        String stones = "aAAbbbb";
        int expectedCount = 3;

        // Act (Действие)
        int actualCount = task5.numJewelsInStones(jewels, stones);

        // Assert (Проверка)
        assertThat(actualCount)
                .as("Количество драгоценностей в камнях должно быть равно 3")
                .isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("Должен вернуть 0, когда нет совпадений из-за регистра (пример 2)")
    void shouldReturnZeroWhenNoJewelsDueToCaseSensitivity() {
        // Arrange
        String jewels = "z";
        String stones = "ZZ";
        int expectedCount = 0;

        // Act
        int actualCount = task5.numJewelsInStones(jewels, stones);

        // Assert
        assertThat(actualCount)
                .as("Должен строго учитываться регистр, ожидается 0 совпадений")
                .isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("Должен вернуть 0, если у нас вообще нет камней (stones пуст)")
    void shouldReturnZeroWhenStonesAreEmpty() {
        // Arrange
        String jewels = "aA";
        String stones = "";
        int expectedCount = 0;

        // Act
        int actualCount = task5.numJewelsInStones(jewels, stones);

        // Assert
        assertThat(actualCount)
                .as("Если нет камней, количество драгоценностей должно быть 0")
                .isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("Должен вернуть 0, если нет типов драгоценностей (jewels пуст)")
    void shouldReturnZeroWhenJewelsAreEmpty() {
        // Arrange
        String jewels = "";
        String stones = "aAAbbbb";
        int expectedCount = 0;

        // Act
        int actualCount = task5.numJewelsInStones(jewels, stones);

        // Assert
        assertThat(actualCount)
                .as("Если типы драгоценностей не заданы, результат должен быть 0")
                .isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("Должен вернуть длину камней, если абсолютно все камни — драгоценные")
    void shouldReturnStonesLengthWhenAllStonesAreJewels() {
        // Arrange
        String jewels = "abc";
        String stones = "aabbcc";
        int expectedCount = 6;

        // Act
        int actualCount = task5.numJewelsInStones(jewels, stones);

        // Assert
        assertThat(actualCount)
                .as("Так как все камни являются драгоценными, должно вернуться их общее количество")
                .isEqualTo(expectedCount);
    }
}