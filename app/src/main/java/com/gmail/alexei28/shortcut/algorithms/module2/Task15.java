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

    Решение:
    1. Временная сложность (Time Complexity): O(M * N)
      Несмотря на логическую ошибку (о ней ниже),
      общая временная сложность остается O(M * N), так как ты в худшем случае обходишь матрицу фиксированное количество раз.
      Пройдемся по этапам кода:
      1. Первый блок (проверка первой строки и колонки): ты обходишь только M + N элементов. Это занимает O(M + N).
      2. Второй блок (запись нулей в первую строку/колонку):
         Вот здесь кроется баг. Ты обходишь всю матрицу целиком ($M * N$), чтобы расставить маркеры.
         Но беда в том, что проверяем if (matrix[row][col] == 0) и тут же перезаписываешь matrix[0][col] = 0 и matrix[row][0] = 0.
         Из-за этого последующие итерации этого же цикла видят эти новые нули как "оригинальные" и начинают лавинообразно занулять другие
         маркеры.
      3. Третий блок (зануление внутренней матрицы): обход внутренних элементов. Это занимает O((M-1) * (N-1)), что эквивалентно O(M * N).
      4. Четвертый блок (финальное зануление первой строки/колонки): занимает O(M + N).
      Итог по времени: O(M + N) + O(M * N) + O(M * N) + O(M + N) = O(M*N).

    2. Пространственная сложность (Space Complexity): O(1)
       Используем подход in-place (прямо в памяти существующей матрицы).
       - Выделяем всего две переменные типа boolean (isFirstRowZero и isFirstColumnZero).
       - Дополнительные массивы не создаются.
       - Объем памяти не растет в зависимости от размеров матрицы M и N.
      Итог по памяти: O(1) (константная память).
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
