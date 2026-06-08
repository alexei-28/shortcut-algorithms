package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Task12Test {

    private Task12 collection;

    @BeforeEach
    void setUp() {
        collection = new Task12();
    }

    @Test
    @DisplayName("insert() должен возвращать true для нового элемента и false для дубликата")
    void insert_ShouldReturnTrueForNewElement_AndFalseForDuplicate() {
        // Arrange & Act
        boolean firstInsert = collection.insert(1);
        boolean secondInsert = collection.insert(1);
        boolean distinctInsert = collection.insert(2);

        // Assert
        assertThat(firstInsert).isTrue();
        assertThat(secondInsert).isFalse();
        assertThat(distinctInsert).isTrue();
    }

    @Test
    @DisplayName("remove() должен возвращать false, если элемент отсутствует")
    void remove_ShouldReturnFalse_WhenElementDoesNotExist() {
        // Arrange
        collection.insert(1);

        // Act
        boolean result = collection.remove(2);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("remove() должен успешно удалять существующий элемент")
    void remove_ShouldReturnTrue_WhenElementExistsAndIsRemoved() {
        // Arrange
        collection.insert(1);
        collection.insert(2);

        // Act
        boolean result = collection.remove(1);

        // Assert
        assertThat(result).isTrue();
        assertThat(collection.getRandom()).isEqualTo(2);
    }

    @Test
    @DisplayName("remove() должен корректно обрабатывать удаление дубликатов поочередно")
    void remove_ShouldHandleDuplicatesCorrectly() {
        // Arrange
        collection.insert(1);
        collection.insert(1);
        collection.insert(2);

        // Act & Assert - Удаляем первый дубликат
        boolean firstRemove = collection.remove(1);
        assertThat(firstRemove).isTrue();

        // В коллекции всё еще должны оставаться 1 и 2
        assertThat(collection.getRandom()).isIn(1, 2);

        // Act & Assert - Удаляем второй дубликат
        boolean secondRemove = collection.remove(1);
        assertThat(secondRemove).isTrue();

        // Теперь осталась только двойка
        assertThat(collection.getRandom()).isEqualTo(2);
    }

    @Test
    @DisplayName("getRandom() должен возвращать единственный элемент, если он один в коллекции")
    void getRandom_ShouldReturnTheOnlyElement_WhenSingleElementExists() {
        // Arrange
        collection.insert(42);

        // Act
        int result = collection.getRandom();

        // Assert
        assertThat(result).isEqualTo(42);
    }

    @Test
    @DisplayName("getRandom() должен возвращать элементы с учетом их распределения/дубликатов")
    void getRandom_ShouldReturnElementsWithRespectToDuplicates() {
        // Arrange
        collection.insert(1);
        collection.insert(1);
        collection.insert(2);

        // Act
        // Сделаем выборку несколько раз, чтобы убедиться, что возвращаются оба значения
        List<Integer> samples = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            samples.add(collection.getRandom());
        }

        // Assert
        assertThat(samples)
                .contains(1, 2) // содержит оба значения
                .doesNotContain(3); // посторонних значений нет
    }
}