package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task13Test {

    @Test
    @DisplayName("Должен возвращать -1, если ключ отсутствует в пустом или заполненном кэше")
    void should_ReturnMinusOne_When_KeyDoesNotExist() {
        // Arrange
        Task13 cache = new Task13(2);

        // Act
        int resultForEmptyCache = cache.get(1);
        cache.put(2, 2);
        int resultForMissingKey = cache.get(3);

        // Assert
        assertThat(resultForEmptyCache)
                .as("При поиске в пустом кэше должно возвращаться -1")
                .isEqualTo(-1);

        assertThat(resultForMissingKey)
                .as("При отсутствии ключа должно возвращаться -1")
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Должен успешно сохранять и возвращать значение по ключу")
    void should_StoreAndRetrieveValue_When_KeyIsPut() {
        // Arrange
        Task13 cache = new Task13(2);
        cache.put(1, 100);

        // Act
        int value = cache.get(1);

        // Assert
        assertThat(value)
                .as("Кэш должен возвращать корректное сохраненное значение")
                .isEqualTo(100);
    }

    @Test
    @DisplayName("Должен обновлять существующее значение по ключу без вытеснения других элементов")
    void should_UpdateExistingValue_When_SameKeyIsPutWithNewValue() {
        // Arrange
        Task13 cache = new Task13(2);
        cache.put(1, 10);
        cache.put(2, 20);

        // Act
        cache.put(1, 15); // Обновляем значение ключа 1

        // Assert
        assertThat(cache.get(1)).isEqualTo(15);
        assertThat(cache.get(2)).isEqualTo(20); // Ключ 2 не должен быть вытеснен
    }

    @Test
    @DisplayName("Должен вытеснять наименее недавно использованный (LRU) элемент при превышении емкости")
    void should_EvictLeastRecentlyUsedElement_When_CapacityIsExceeded() {
        // Arrange
        Task13 cache = new Task13(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // Act
        cache.put(3, 3); // Превышаем емкость (2). Ключ 1 должен быть вытеснен, так как он LRU

        // Assert
        assertThat(cache.get(1))
                .as("Ключ 1 должен быть вытеснен из кэша")
                .isEqualTo(-1);

        assertThat(cache.get(2)).isEqualTo(2);
        assertThat(cache.get(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("Вызов get должен делать элемент недавно использованным и защищать его от вытеснения")
    void should_UpdateRecency_When_GetIsCalled() {
        // Arrange
        Task13 cache = new Task13(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // Act
        cache.get(1);    // Обращаемся к ключу 1. Теперь ключ 2 становится наименее используемым (LRU)
        cache.put(3, 3); // Превышаем емкость. Должен вытесниться ключ 2

        // Assert
        assertThat(cache.get(2))
                .as("Ключ 2 должен быть вытеснен, так как к ключу 1 обращались позже")
                .isEqualTo(-1);

        assertThat(cache.get(1)).isEqualTo(1);
        assertThat(cache.get(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("Вызов put для существующего ключа должен делать его недавно использованным")
    void should_UpdateRecency_When_PutUpdatesExistingKey() {
        // Arrange
        Task13 cache = new Task13(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // Act
        cache.put(1, 10); // Обновляем ключ 1. Теперь он становится MRU, а ключ 2 — LRU
        cache.put(3, 3);  // Превышаем емкость. Должен вытесниться ключ 2

        // Assert
        assertThat(cache.get(2))
                .as("Ключ 2 должен быть вытеснен, так как обновление ключа 1 сделало его активным")
                .isEqualTo(-1);

        assertThat(cache.get(1)).isEqualTo(10);
        assertThat(cache.get(3)).isEqualTo(3);
    }
}