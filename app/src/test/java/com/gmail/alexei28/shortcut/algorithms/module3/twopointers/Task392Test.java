package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task392Test {

    private Task392 task;

    @BeforeEach
    void setUp() {
        task = new Task392();
    }

    @ParameterizedTest(name = "s = \"{0}\", t = \"{1}\" should return {2}")
    @CsvSource({
            "'bc', 'ahbgdc', true",
            "'axc', 'ahbgdc', false",
            "'b', 'abc', true",
            "'', 'ahbgdc', true",
            "'abcde', 'abc', false",
            "'', '', true"
    })
    void shouldCheckIfSIsSubsequenceOfT(String s, String t, boolean expected) {
        // Act
        boolean result = task.isSubsequence(s, t);

        // Assert
        assertThat(result).isEqualTo(expected);
    }
}