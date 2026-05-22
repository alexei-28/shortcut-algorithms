package com.gmail.alexei28.shortcut.algorithms.module2;

import jdk.jshell.Snippet;

/*
    Задание 18: Zigzag Conversion [Medium]
    Источник: https://leetcode.com/problems/zigzag-conversion/
    Запишите строку в zigzag-порядке (в виде «змейки») по заданному числу строк, затем прочитайте построчно.
    ZigZag мы пишем буквы именно так: вниз по вертикали, а затем вверх по диагонали.

    Примеры:
    Вход: s = "PAYPALISHIRING", numRows = 3
    Zigzag-форма:
    P   A   H   N
    A P L S I I G
    Y   I   R
    Читаем построчно: «PAHNAPLSIIGYIR»

    Example 2:
    Input: s = "PAYPALISHIRING", numRows = 4
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    Output: "PINALSIGYAHRPI"

    Требования:
    -Сложность: O(n)
    -Память: O(n)

    Решение:
    1. Временная сложность (Time Complexity): O(n)
       Где n — это длина строки s.
      - Инициализация: Создание массива StringBuilder занимает O(numRows).
        Поскольку в самом начале у нас есть проверка if (numRows >= s.length()) return s;, мы точно знаем, что numRows меньше n.
        Значит, этот шаг занимает $O(n)$ в худшем случае.
      - Основной цикл: Мы проходим по строке s ровно один раз символ за символом (for (char c : s.toCharArray())).
        Внутри цикла все операции (добавление в StringBuilder, проверка условий и изменение индекса) выполняются за константное время $O(1)$.
        Итого: O(n).
      - Сборка результата: В конце мы объединяем все строки из массива rows в один финальный StringBuilder.
        Суммарно во всех объектах StringBuilder находится ровно $n$ символов, поэтому цикл сборки и метод sb.toString() занимают $O(n)$.
        Итог: O(n) + O(n) + O(n) = O(n). Время выполнения растет строго линейно в зависимости от длины строки.

     2. Пространственная сложность (Space Complexity): O(n)
        Где n — это длина строки s.
       - Выделение памяти под строки: Мы распределяем все n символов исходной строки по разным объектам StringBuilder в массиве rows.
         В совокупности они хранят ровно n символов.
       - Финальный результат: Создание итогового StringBuilder sb и вызов sb.toString() требуют выделения памяти под новую строку длины n.
       - Массив символов: Метод s.toCharArray() в Java создает копию строки в виде массива символов, что также временно занимает O(n) памяти.
         Примечание: Память под сам массив StringBuilder[] составляет O(numRows), но так как по условиям задачи это значение ограничено
         сверху длиной строки n, доминирующей сложностью все равно остается O(n).
       - Итог: Потребление дополнительной памяти линейно зависит от длины входной строки.
*/
public class Task18 {

    public String convert(String s, int numRows) {
        // Edge case: If 1 row or string is shorter than rows, no zigzag happens
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean movingDown = false;

        // Iterate through the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction when hitting the top or bottom boundaries
            if (currentRow == 0 || currentRow == numRows - 1) {
                movingDown = !movingDown; // Flip the direction
            }

            // Move to the next row based on direction
            currentRow += movingDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
