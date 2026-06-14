package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Task10Test {

    private Task10 task;

    @BeforeEach
    void setUp() {
        task = new Task10();
    }

    @Test
    @DisplayName("Базовый пример: стандартный набор слов-анаграмм")
    void testStandardExample() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = task.groupAnagrams(input);

        // Проверяем, что размер общего списка верный (3 группы)
        assertThat(result).hasSize(3);

        // Проверяем содержание групп независимо от их порядка и порядка элементов внутри
        assertThat(result)
                .map(List::stream).map(s -> s.sorted().toList()) // Сортируем списки внутри для консистентного сравнения
                .containsExactlyInAnyOrder(
                        List.of("ate", "eat", "tea"),
                        List.of("nat", "tan"),
                        List.of("bat")
                );
    }

    @Test
    @DisplayName("Пустая строка в массиве")
    void testEmptyString() {
        String[] input = {""};
        List<List<String>> result = task.groupAnagrams(input);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).containsExactly("");
    }

    @Test
    @DisplayName("Один символ в массиве")
    void testSingleCharacter() {
        String[] input = {"a"};
        List<List<String>> result = task.groupAnagrams(input);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).containsExactly("a");
    }

    @Test
    @DisplayName("Несколько пустых строк")
    void testMultipleEmptyStrings() {
        String[] input = {"", "", ""};
        List<List<String>> result = task.groupAnagrams(input);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).containsExactlyInAnyOrder("", "", "");
    }

    @Test
    @DisplayName("Слова с одинаковыми буквами, но разным количеством повторений")
    void testWordsWithSameLettersButDifferentCount() {
        String[] input = {"boo", "bob"};
        List<List<String>> result = task.groupAnagrams(input);

        assertThat(result).hasSize(2);
        assertThat(result)
                .map(List::stream).map(s -> s.sorted().toList())
                .containsExactlyInAnyOrder(
                        List.of("boo"),
                        List.of("bob")
                );
    }

    @Test
    @DisplayName("Все слова являются анаграммами")
    void testAllAnagrams() {
        String[] input = {"abc", "bca", "cab", "cba"};
        List<List<String>> result = task.groupAnagrams(input);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).containsExactlyInAnyOrder("abc", "bca", "cab", "cba");
    }
}