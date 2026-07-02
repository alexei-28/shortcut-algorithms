package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class Task2Test {

    private Task2 task2;

    @BeforeEach
    void setUp() {
        task2 = new Task2();
    }

    @Test
    void should_FindMaxAverage_When_ArrayHasMultipleElements() {
        // Arrange
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double expected = 12.75000;

        // Act
        double actual = task2.findMaxAverage(nums, k);

        // Assert
        assertThat(actual).isCloseTo(expected, within(1e-5));
    }

    @Test
    void should_FindMaxAverage_When_ArrayHasSingleElement() {
        // Arrange
        int[] nums = {5};
        int k = 1;
        double expected = 5.00000;

        // Act
        double actual = task2.findMaxAverage(nums, k);

        // Assert
        assertThat(actual).isCloseTo(expected, within(1e-5));
    }

    @Test
    void should_FindMaxAverage_When_AllElementsAreNegative() {
        // Arrange
        int[] nums = {-1, -12, -5, -6, -50, -3};
        int k = 2;
        double expected = -3.5; // (-1 + -6) / 2 = -3.5 is NOT max. Max is (-1 + -5)/2 = -3 or (-5 + -6)/2 = -5.5. Wait, contiguous: -1,-12=-6.5; -12,-5=-8.5; -5,-6=-5.5; -6,-50=-28; -50,-3=-26.5. Max is -5.5

        // Let's pick a cleaner example: {-1, -2, -3, -4} k=2. Max contiguous is -1 + -2 = -3 / 2 = -1.5
        int[] negativeNums = {-1, -2, -3, -4};
        int negativeK = 2;
        double expectedNegative = -1.5;

        // Act
        double actual = task2.findMaxAverage(negativeNums, negativeK);

        // Assert
        assertThat(actual).isCloseTo(expectedNegative, within(1e-5));
    }

    @Test
    void should_FindMaxAverage_When_KEqualsArrayLength() {
        // Arrange
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        double expected = 2.5; // (1 + 2 + 3 + 4) / 4 = 10 / 4 = 2.5

        // Act
        double actual = task2.findMaxAverage(nums, k);

        // Assert
        assertThat(actual).isCloseTo(expected, within(1e-5));
    }
}