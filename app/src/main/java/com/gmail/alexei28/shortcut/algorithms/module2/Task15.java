package com.gmail.alexei28.shortcut.algorithms.module2;

/*
    Задание 15: Set Matrix Zeroes [Medium]
    Источник: https://leetcode.com/problems/set-matrix-zeroes/
    Дана mxn матрица. Если элемент равен 0, то установите всю его строку и столбец в 0. Сделайте это in-place.
    Примеры:
        Вход:
        matrix =
        [
          [1,1,1],
          [1,0,1],
          [1,1,1]
        ]

        Выход:
        [
          [1,0,1],
          [0,0,0],
          [1,0,1]
        ]

    Требования:
    - Сложность: O(m*n) - означает, что алгоритм проходит по каждому элементу матрицы один раз (например через вложенный цикл)
    - Память: O(1) — in-place решение без использования дополнительной матрицы
*/
public class Task15 {

    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++ ) {
                if (!isFirstRowZero && matrix[0][j] == 0) {
                    isFirstRowZero = true;
                }
                if (!isFirstColumnZero && matrix[i][0] == 0) {
                    isFirstColumnZero = true;
                }
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }

                // if last row
                if (isFirstRowZero && i == matrix.length - 1 && j > 0) {
                    matrix[0][j - 1] = 0;
                }
            }
        }

    }
}
