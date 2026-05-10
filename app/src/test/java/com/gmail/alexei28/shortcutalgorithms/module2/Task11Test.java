package com.gmail.alexei28.shortcutalgorithms.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task11Test {

    @ParameterizedTest(name = "Массив \"{0}\" должна вернуть \"{1}\"")
    @MethodSource("testData")
    void shouldFindMinAndMax(int[] input, int[] expected) {
        // arrange
        Task11 solution = new Task11();

        // act
        int[] actual = solution.findMaxAndMin(input);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    // Источник данных для теста
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new int[]{}, new int[]{}),
                arguments(new int[]{3, 7, 2, 9, 1, 5}, new int[]{9, 1}),
                arguments(new int[]{3, -7, 2, 9}, new int[]{9, -7}),
                arguments(new int[]{-3, -7, -2, -9}, new int[]{-2, -9}),
                arguments(new int[]{3, 3}, new int[]{3, 3}),
                arguments(new int[]{-3, -3}, new int[]{-3, -3}),
                arguments(new int[]{-3, 3}, new int[]{3, -3}),
                arguments(new int[]{-3}, new int[]{-3, -3}),
                arguments(new int[]{0}, new int[]{0, 0}),
                arguments(new int[]{1, 2, 0, 1, 8}, new int[]{8, 0}),
                arguments(new int[]{7}, new int[]{7, 7})
        );
    }

}