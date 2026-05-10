package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task6Test {
    @ParameterizedTest(name = "Массив {0} должен превратиться в \"{1}\"")
    @MethodSource("testData")
    void shouldReturnConcatenatedString(String[] input, String expected) {
        // Act
        String actual = new Task6().solution(input);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    // Источник данных для теста
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new String[]{"hello", " ", "world"}, "hello world"),
                arguments(new String[]{"Hello", " ", "World", "!"}, "Hello World!"),
                arguments(new String[]{"a", "b", "c"}, "abc"),
                arguments(new String[]{""}, ""),
                arguments(new String[]{"", "test", ""}, "test")
        );
    }


}