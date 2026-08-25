package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RecentCounterTest {

    @Test
    void shouldReturnCorrectNumberOfRecentCalls() {
        // Arrange
        Task2 recentCounter = new Task2();

        // Act
        int result1 = recentCounter.ping(1);
        int result2 = recentCounter.ping(100);
        int result3 = recentCounter.ping(3001);
        int result4 = recentCounter.ping(3002);

        // Assert
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(3);
        assertThat(result4).isEqualTo(3);
    }

    @Test
    void shouldEvictCallsOlderThan3000Milliseconds() {
        // Arrange
        Task2 recentCounter = new Task2();

        // Act & Assert
        // t = 100, range [-2900, 100]
        assertThat(recentCounter.ping(100)).isEqualTo(1);

        // t = 3100, range [100, 3100] -> keeps 100
        assertThat(recentCounter.ping(3100)).isEqualTo(2);

        // t = 3101, range [101, 3101] -> evicts 100
        assertThat(recentCounter.ping(3101)).isEqualTo(2);
    }
}