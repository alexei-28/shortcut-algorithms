package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Task9Test {

    @ParameterizedTest(name = "Строка \"{0}\" должна вернуть длину {1}")
    @MethodSource("testData")
    void shouldReturnLengthOfLastWord(String input, int expected) {
        // arrange
        Task9 solution = new Task9();

        // act
        int actual = solution.lengthOfLastWord(input);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    // Источник данных для теста
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments("     ", -1),
                arguments("a", 1),
                arguments("abc", 3),
                arguments("abc ", 3),
                arguments(" abc", 3),
                arguments("a     ", 1),
                arguments("ab    ", 2),
                arguments(" a    ", 1),
                arguments(" ab   ", 2),
                arguments("      a", 1),
                arguments("      ab", 2),
                arguments("        ", -1),
                arguments("", -1),
                arguments("Hello World", 5),
                arguments("   fly me   to   the moon  ", 4),
                arguments("luffy is still joyboy", 6)
        );
    }


}