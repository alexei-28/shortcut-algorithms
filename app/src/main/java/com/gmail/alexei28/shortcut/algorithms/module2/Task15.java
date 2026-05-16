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

        // обходим только первую строку и первую колонку
        for (int row = 0; row < matrix.length; row++) {
            int columnsCount = matrix[0].length;
            if (row > 0) {
                columnsCount = 1;
            }
            for (int col = 0; col < columnsCount; col++) {
                if (row == 0 && matrix[row][col] == 0) {
                    isFirstRowZero = true;
                    if (col == 0) {
                        isFirstColumnZero = true;
                    }
                    break;
                }
                if (row > 0 && matrix[row][col] == 0) {
                    isFirstColumnZero = true;
                    break;
                }
            }
        }
        // set 0 in first row and first column
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // skip first row and first column
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                // если в первой строке этого столбца стоит 0, то текущему элементу присвой 0
                if (matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
                // если в первом столбце этой строки стоит 0, то текущему элементу присвой 0
                if (matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        System.out.println("isFirstRowZero = " + isFirstRowZero + ", isFirstColumnZero = " + isFirstColumnZero);
        if (isFirstRowZero) {
            // обходим только первую строку и обнуляем ее
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        if (isFirstColumnZero) {
            // обходим только первую колонку и обнуляем ее
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
