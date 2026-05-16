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
    @DisplayName("Ноль в первой строке 8x10")
    void testZeroInFirstRow() {
        int[][] matrix = {
                {3, 5, 5, 6, 9, 1, 4, 5, 0, 5},
                {2, 7, 9, 5, 9, 5, 4, 9, 6, 8},
                {6, 0, 7, 8, 1, 0, 1, 6, 8, 1},
                {7, 2, 6, 5, 8, 5, 6, 5, 0, 6},
                {2, 3, 3, 1, 0, 4, 6, 5, 3, 5},
                {5, 9, 7, 3, 8, 8, 5, 1, 4, 3},
                {2, 4, 7, 9, 9, 8, 4, 7, 3, 7},
                {3, 5, 2, 8, 8, 2, 2, 4, 9, 8}
        };
        int[][] expected = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 9, 5, 0, 0, 4, 9, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 7, 3, 0, 0, 5, 1, 0, 3},
                {2, 0, 7, 9, 0, 0, 4, 7, 0, 7},
                {3, 0, 2, 8, 0, 0, 2, 4, 0, 8}
        };
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Крайний случай: ноль в последней колонки матрицы 5x6")
    void testLastColumnZero() {
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1}
        };
        int[][] expected = {
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0}
        };
        solver.setZeroes(matrix);
        assertThat(matrix)
                .isDeepEqualTo(expected);
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