package com.gmail.alexei28.shortcut.algorithms.module2.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeBuySellStockTest {

    private BestTimeBuySellStock solution;

    @BeforeEach
    void setUp() {
        // Arrange
        solution = new BestTimeBuySellStock();
    }

    @Test
    @DisplayName("Should return maximum profit when prices fluctuate (Example 1)")
    void shouldReturnMaxProfitWhenPricesFluctuate() {
        // Arrange
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Act
        int actualProfit = solution.maxProfit(prices);

        // Assert
        assertThat(actualProfit)
                .as("Max profit buying at 1 and selling at 6 should be 5")
                .isEqualTo(5);
    }

    @Test
    @DisplayName("Should return 0 when prices are in strictly descending order (Example 2)")
    void shouldReturnZeroWhenPricesAreDescending() {
        // Arrange
        int[] prices = {7, 6, 4, 3, 1};

        // Act
        int actualProfit = solution.maxProfit(prices);

        // Assert
        assertThat(actualProfit)
                .as("No profit can be made when prices strictly decrease")
                .isZero();
    }

    @Test
    @DisplayName("Should return 0 when prices array has fewer than 2 elements")
    void shouldReturnZeroWhenPricesArrayHasLessThanTwoElements() {
        // Arrange
        int[] singlePrice = {5};
        int[] emptyPrices = {};

        // Act
        int singleResult = solution.maxProfit(singlePrice);
        int emptyResult = solution.maxProfit(emptyPrices);

        // Assert
        assertThat(singleResult).isZero();
        assertThat(emptyResult).isZero();
    }

    @Test
    @DisplayName("Should return 0 when all prices are identical")
    void shouldReturnZeroWhenPricesAreFlat() {
        // Arrange
        int[] prices = {3, 3, 3, 3, 3};

        // Act
        int actualProfit = solution.maxProfit(prices);

        // Assert
        assertThat(actualProfit).isZero();
    }

    @Test
    @DisplayName("Should calculate correct profit when minimum price occurs after a local maximum")
    void shouldCalculateCorrectProfitWhenLowestPriceIsLast() {
        // Arrange
        int[] prices = {2, 4, 1};

        // Act
        int actualProfit = solution.maxProfit(prices);

        // Assert
        assertThat(actualProfit)
                .as("Buying at 2 and selling at 4 yields profit of 2, even if 1 appears later")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Should return correct profit when max profit occurs late in the array")
    void shouldReturnMaxProfitWhenBestOpportunityIsAtEnd() {
        // Arrange
        int[] prices = {3, 2, 6, 5, 0, 3};

        // Act
        int actualProfit = solution.maxProfit(prices);

        // Assert
        assertThat(actualProfit)
                .as("Buying at 2 and selling at 6 gives max profit of 4")
                .isEqualTo(4);
    }
}