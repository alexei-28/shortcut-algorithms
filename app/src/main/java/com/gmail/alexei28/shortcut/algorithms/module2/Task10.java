package com.gmail.alexei28.shortcut.algorithms.module2;

/*
    Задание 10: Longest Common Prefix [Easy]
    Источник: https://leetcode.com/problems/longest-common-prefix/description/
    Напишите функцию для поиска самого длинного общего префикса среди массива строк. Если общего префикса нет, верните пустую строку.
    Примеры:
    Вход: strs = ["flower","flow","flight"], Выход: "fl"
    Вход: strs = ["dog","racecar","car"], Выход: "" (нет общего префикса)
    Вход: strs = ["cir","car"], Выход: "c"

    Требования:
    - Сложность: O(n*m), где n — количество строк, m — длина самой короткой строки
    - Память: O(1)

    Подсказка: Возьмите первую строку как образец префикса.
    Сравнивайте её с каждой следующей строкой и укорачивайте префикс, пока он не станет общим для всех.

    Решение:
    1. Временная сложность (Time Complexity)
        Обозначим:
          - n — количество строк
          - m — длина первой строки (firstString.length())
        Тогда:
          - внешний цикл проходит n - 1 раз
          - внутренний цикл в худшем случае проходит m раз
        Получаем:
           O(n*m)
        Почему именно так:
          В худшем случае все строки одинаковые:
           ["flower", "flower", "flower"]
          Тогда для каждой строки проходим весь префикс полностью.
     2. Пространственная сложность (Space Complexity)
        Пространственная сложность составляет O(1) (константная).
        - Почему так: Не создается никаких дополнительных структур данных (массивов, списков или деревьев),
          размер которых рос бы в зависимости от входных данных.
        - Используется только несколько переменных примитивных типов (largerstIndex, currentIndex, i, j).
*/
public class Task10 {

    public String longestCommonPrefix(String[] strs) {
        String firstString = strs[0];
        int largerstIndex = firstString.length();
        int currentIndex;
        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            currentIndex = 0;
            for (int j = 0; j < firstString.length(); j++) {
                char firstStringChar = firstString.charAt(j);
                if (j < currentString.length()) {
                    char currentStringChar = currentString.charAt(j);
                    if (firstStringChar == currentStringChar) {
                        currentIndex++;
                    } else {
                        break;
                    }
                }
            }
            if (currentIndex < largerstIndex) {
                largerstIndex = currentIndex;
            }
        }
        return firstString.substring(0, largerstIndex);
    }
}
