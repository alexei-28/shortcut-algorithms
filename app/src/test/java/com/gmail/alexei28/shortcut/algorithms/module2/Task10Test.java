package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task10Test {

    @ParameterizedTest(name = "Строка \"{0}\" должна вернуть \"{1}\"")
    @MethodSource("testData")
    void shouldLongestCommonPrefix(String[] input, String expected) {
        // arrange
        Task10 solution = new Task10();

        // act
        String actual = solution.longestCommonPrefix(input);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    // Источник данных для теста
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new String[]{""}, ""),
                arguments(new String[]{"flower","flow","flight"}, "fl"),
                arguments(new String[]{"dog","racecar","car"}, ""),
                arguments(new String[]{"cir","car"}, "c"),
                arguments(new String[]{"best","forest, worst"}, "")
        );
    }
}