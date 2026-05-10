package com.gmail.alexei28.shortcut.algorithms.module2;

/*
    Задание 12: Plus One [Easy]
    Источник: https://leetcode.com/problems/plus-one/

    Дано целое неотрицательное число, представленное в виде массива цифр digits, где каждая цифра находится на своей позиции
    (самая значимая цифра — по индексу 0). Прибавьте к этому числу единицу. Измените массив digits in-place и верните его.
    Цифры хранятся так, что старшая цифра находится в начале списка, и каждая цифра в массиве является одной цифрой числа (0−9).
    Примеры:
        Вход: digits = [1,2,3], Выход: [1,2,4] (123 + 1 = 124)
        Вход: digits = [4,3,2,1], Выход: [4,3,2,2] (4321 + 1 = 4322)
        Вход: digits = [9], Выход: [1,0] (9 + 1 = 10)
        Вход: digits = [9,9], Выход: [1,0,0] (99 + 1 = 100)

    Требования:
    - Сложность: O(n)
    - Память: O(1)

    Constraints:
      1 <= digits.length <= 100
      0 <= digits[i] <= 9
      digits does not contain any leading 0's.
*/
public class Task12 {

    public int[] plusOne(int[] digits) {
        int number = 0;
        for (int index = digits.length; index > 0; index--) {
            int digit = digits[index];
            if (digit < 9) {
                digit++;
            }

        }
        return new int[]{};
    }
}
