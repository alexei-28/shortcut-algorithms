package com.gmail.alexei28.shortcut.algorithms.module2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task15Test {

    private Task15 solver;

    @BeforeEach
    void setUp() {
        solver = new Task15();
    }

    @Test
    @DisplayName("Базовый случай: ноль в центре матрицы 3x3")
    void testBasicCase() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько нулей в разных местах")
    void testMultipleZeroes() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int[][] expected = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Ноль в верхнем левом углу (проверка пересечения первой строки и столбца)")
    void testZeroAtOrigin() {
        int[][] matrix = {
                {0, 1},
                {1, 1}
        };
        int[][] expected = {
                {0, 0},
                {0, 1}
        };
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Матрица без нулей не должна измениться")
    void testNoZeroes() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {1, 2},
                {3, 4}
        };
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Матрица из одного элемента (ноль)")
    void testSingleElementZero() {
        int[][] matrix = {{0}};
        int[][] expected = {{0}};
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Матрица-строка с одним нулем")
    void testSingleRow() {
        int[][] matrix = {{1, 0, 3}};
        int[][] expected = {{0, 0, 0}};
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }
}