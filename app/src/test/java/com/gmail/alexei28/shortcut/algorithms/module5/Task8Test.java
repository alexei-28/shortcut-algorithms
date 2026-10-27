package com.gmail.alexei28.shortcut.algorithms.module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Task8Test {

    private Task8 task8;

    @BeforeEach
    void setUp() {
        // Arrange
        task8 = new Task8();
    }

    @Test
    @DisplayName("Example 1: Standard case with moderate piles and hours")
    void testMinEatingSpeed_Example1() {
        // Arrange
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int expected = 4;

        // Act
        int actual = task8.minEatingSpeed(piles, h);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Example 2: Hours equal to number of piles (must eat each pile in 1 hour)")
    void testMinEatingSpeed_Example2() {
        // Arrange
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int expected = 30;

        // Act
        int actual = task8.minEatingSpeed(piles, h);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Example 3: Hours slightly more than number of piles")
    void testMinEatingSpeed_Example3() {
        // Arrange
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int expected = 23;

        // Act
        int actual = task8.minEatingSpeed(piles, h);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Edge Case: Single pile with exact hours")
    void testMinEatingSpeed_SinglePile() {
        // Arrange
        int[] piles = {10};
        int h = 2;
        int expected = 5;

        // Act
        int actual = task8.minEatingSpeed(piles, h);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Edge Case: Large number of available hours relative to pile sizes")
    void testMinEatingSpeed_LargeHours() {
        // Arrange
        int[] piles = {3, 6, 7, 11};
        int h = 100;
        int expected = 1;

        // Act
        int actual = task8.minEatingSpeed(piles, h);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "piles = {0}, h = {1} -> expected = {2}")
    @MethodSource("provideTestData")
    @DisplayName("Parameterized tests for various combinations of piles and hours")
    void testMinEatingSpeed_Parameterized(int[] piles, int h, int expected) {
        // Act
        int actual = task8.minEatingSpeed(piles, h);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 5, 30),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 6, 23),
                Arguments.of(new int[]{1000000000}, 2, 500000000)
        );
    }
}