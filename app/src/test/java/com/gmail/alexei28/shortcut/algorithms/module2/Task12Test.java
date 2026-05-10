package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task12Test {

    @ParameterizedTest(name = "Массив \"{0}\" должна вернуть \"{1}\"")
    @MethodSource("testData")
    void shouldFindMinAndMax(int[] input, int[] expected) {
        // arrange
        Task12 solution = new Task12();

        // act
        int[] actual = solution.plusOne(input);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    // Источник данных для теста
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                arguments(new int[]{9}, new int[]{1, 0}),
                arguments(new int[]{9, 9}, new int[]{1, 0, 0})
        );
    }

}