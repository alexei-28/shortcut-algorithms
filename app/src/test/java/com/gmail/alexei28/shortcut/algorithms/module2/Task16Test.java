package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task16Test {

    private final Task16 task = new Task16();

    @Test
    void shouldParseSimpleNumber() {
        assertThat(task.myAtoi("42")).isEqualTo(42);
    }

    @Test
    void shouldHandleLeadingSpacesAndNegative() {
        assertThat(task.myAtoi("   -42")).isEqualTo(-42);
    }

    @Test
    void shouldHandleNoLeadingSpacesAndNegative() {
        assertThat(task.myAtoi("-42")).isEqualTo(-42);
    }

    @Test
    void shouldHandlePlusMinusTogetherAsInvalid() {
        assertThat(task.myAtoi("+-12")).isZero();
    }

    @Test
    void shouldHandleBeZeroWhenMinusBetweenNumbers() {
        assertThat(task.myAtoi("0-1")).isZero();
    }

    @Test
    void shouldHandleBeZeroAndSpaceBetweenNumbers() {
        assertThat(task.myAtoi("   +0 123")).isZero();
    }

    @Test
    void shouldHandleSinglePlusBBetweenSpaces() {
        assertThat(task.myAtoi("  +  413")).isZero();
    }


    @Test
    void shouldHandleBeTwoZeroAndSpaceBetweenNumbers() {
        assertThat(task.myAtoi("  -0012a42")).isEqualTo(-12);
    }

    @Test
    void shouldReturnZeroWhenNoDigitsAtStart() {
        assertThat(task.myAtoi("words and 987")).isZero();
    }

    @Test
    void shouldParseUntilNonDigit() {
        assertThat(task.myAtoi("4193 with words")).isEqualTo(4193);
    }

    @Test
    void shouldHandlePositiveSign() {
        assertThat(task.myAtoi("+1")).isEqualTo(1);
    }

    @Test
    void shouldHandleMultipleLeadingZeros() {
        assertThat(task.myAtoi("00000-42a1234")).isZero();
    }

    @Test
    void shouldHandleEleven() {
        assertThat(task.myAtoi("000000000000000000000000000011")).isEqualTo(11);
    }

    @Test
    void shouldHandleOverflowPositive() {
        int expected = Integer.MAX_VALUE; // 2147483647
        int actual = task.myAtoi("2147483648");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldHandleOverflowNegative() { // expected -2147483648
        assertThat(task.myAtoi("-9128347233")).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void shouldHandleOverflowNegativ2e() { // expected -2147483648
        assertThat(task.myAtoi("-9223372036854775809")).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void shouldHandleOnlySpaces() {
        assertThat(task.myAtoi("     ")).isZero();
    }

    @Test
    void shouldStopAtFirstInvalidCharacter() {
        assertThat(task.myAtoi("3.14159")).isEqualTo(3);
    }

    @Test
    void shouldHandleEmptyString() {
        assertThat(task.myAtoi("")).isZero();
    }


}