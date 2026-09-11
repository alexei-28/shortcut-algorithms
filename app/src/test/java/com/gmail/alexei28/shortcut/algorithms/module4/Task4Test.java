package com.gmail.alexei28.shortcut.algorithms.module4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    private final Task4 task = new Task4();

    @Test
    void shouldEvaluateAdditionAndMultiplication() {
        // Arrange
        String[] tokens = {"2", "1", "+", "3", "*"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(9);
    }

    @Test
    void shouldEvaluateDivisionAndAddition() {
        // Arrange
        String[] tokens = {"4", "13", "5", "/", "+"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldEvaluateComplexExpression() {
        // Arrange
        String[] tokens = {
                "10", "6", "9", "3", "+", "-11", "*",
                "/", "*", "17", "+", "5", "+"
        };

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(22);
    }

    @Test
    void shouldEvaluateSubtraction() {
        // Arrange
        String[] tokens = {"5", "3", "-"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(2);
    }

    @Test
    void shouldEvaluateMultiplication() {
        // Arrange
        String[] tokens = {"4", "5", "*"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(20);
    }

    @Test
    void shouldEvaluateDivision() {
        // Arrange
        String[] tokens = {"10", "2", "/"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    void shouldTruncateDivisionTowardZeroForPositiveAndNegativeNumbers() {
        // Arrange
        String[] tokens = {"7", "-3", "/"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(-2);
    }

    @Test
    void shouldHandleNegativeNumbers() {
        // Arrange
        String[] tokens = {"-5", "2", "*"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(-10);
    }

    @Test
    void shouldHandleExpressionWithMultipleOperations() {
        // Arrange
        String[] tokens = {"2", "3", "+", "4", "*"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(20);
    }

    @Test
    void shouldHandleSingleNumber() {
        // Arrange
        String[] tokens = {"42"};

        // Act
        int result = task.evalRPN(tokens);

        // Assert
        assertThat(result).isEqualTo(42);
    }
}