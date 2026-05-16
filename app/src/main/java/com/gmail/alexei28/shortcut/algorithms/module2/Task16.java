package com.gmail.alexei28.shortcut.algorithms.module2;

/*
Задание 16: String to Integer (atoi) [Medium]
Источник: https://leetcode.com/problems/string-to-integer-atoi/description/
Реализуйте функцию atoi, которая преобразует строку в 32-битное целое число со следующими правилами:
1. Пропустите ведущие пробелы
2. Проверьте знак (+ или -)
3. Читайте цифры до первой нецифры
4. Преобразуйте в число, учитывая переполнение 32-битного int (-2,147,483,648 - 2,147,483,647)

Примеры:
Вход: "42", Выход: 42
Вход: "   -42", Выход: -42
Вход: "4193 with words", Выход: 4193
Вход: "words and 987", Выход: 0 (нет цифр в начале)
Вход: "-91283472332", Выход: -2147483648 (переполнение) (Integer.MIN_VLAUE)

Требования:
- Сложность: O(n)
- Память: O(1)

Решение:
    1. Временная сложность (Time Complexity): O(N)
       Где N — это длина строки s.
       - Почему так: В коде используется один цикл for, который итерируется по строке
         от начала до конца (index < s.length()).
       - Что внутри цикла: Все операции внутри цикла (проверки условий if-else, получение символа charAt, арифметические операции
         и присваивания) выполняются за константное время O(1).
       - Ранний выход: В коде есть операторы break, которые могут завершить цикл раньше (например, если встретился недопустимый
         символ после цифр). В лучшем случае (например, строка начинается с буквы) алгоритм отработает за O(1).
         Но в худшем случае (когда вся строка состоит из цифр) цикл пройдется по всем $N$ символам.Поэтому общая временная сложность
         в худшем случае составляет O(N).
     2. Пространственная сложность (Space Complexity): O(1)
       - Почему так: Твой алгоритм является in-place (выполняется по месту). Мы не создаем никаких дополнительных структур данных (массивов,
         списков, строк), размер которых зависел бы от длины входной строки s.
       - Используемая память: Выделяется фиксированное количество
         памяти под переменные примитивных типов: result (long), isPositive (boolean), prevChar (char), isPrevCharNumber (boolean)
         и индекс цикла index (int). Количество этой памяти всегда одинаково, независимо от того, передали на вход строку из 5 символов
         или из 5 000.
         Поэтому пространственная сложность — константная, то есть O(1).
*/
public class Task16 {

    public int myAtoi(String s) {
        long result = 0;
        boolean isPositive = true;
        char prevChar = ' ';
        boolean isPrevCharNumber = false;
        for (int index = 0; index < s.length(); index++) {
            char currentChar = s.charAt(index);
            if (index > 0) {
                prevChar = s.charAt(index - 1);
            }
            if (currentChar >= '0' && currentChar <= '9') {
                isPrevCharNumber = true;
                if (result == 0) {
                    result = Character.getNumericValue(currentChar);
                } else {
                    result = result * 10;
                    result = result + Character.getNumericValue(currentChar);
                    if (isPositive && result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else { // non digit
                if (isPrevCharNumber) {
                    break;
                }
                if ((prevChar == '+' || prevChar == '-') && currentChar == ' ') {
                    return 0;
                }
                if ((currentChar == '-' || currentChar == '+') && index > 0 && prevChar != ' ') {
                    return 0;
                }
                if (currentChar == '-') {
                    isPositive = false;
                    continue;
                }
                if (currentChar == ' ' || currentChar == '+') {
                    continue;
                }
                break;
            }
        }
        if (!isPositive) {
            if (result > 0) {
                result = result * -1;
            }
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) result;
    }
}
