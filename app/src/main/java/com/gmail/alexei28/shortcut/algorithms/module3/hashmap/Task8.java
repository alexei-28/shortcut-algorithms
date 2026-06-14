package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
    Задание 8: Valid Anagram [Easy]
    Паттерн: Частотный анализ (HashMap для сравнения частот)
    Пример из лекции:Проверить, являются ли две строки анаграммами.
    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    using all the original letters exactly once.

    Проверьте, являются ли две строки анаграммами.
    Источник: https://leetcode.com/problems/valid-anagram/

    Примеры:
    is_anagram("anagram", "nagaram") → True
    is_anagram("rat", "cat") → False

    Требования:
    - Временная сложность: O(n)

    Решение:
    1. Временная сложность (Time Complexity): O(N)
       Где N — это длина строки s (или t, так как в самом начале ты проверяешь, что их длины равны).
       Код состоит из трех последовательных циклов:
       - Первый цикл проходит по строке s длиной N. Операции внутри (map.put, map.get) в среднем занимают O(1). Итого: O(N).
       - Второй цикл (for по строке t). Итого для второго цикла: O(n).
       - Третий цикл (for по строке s). Итого для третьего цикла: O(n).

       Общая временная сложность: O(n) + O(n) + O(n) = O(3n) -> O(n)
       В нотации «О-большое» константы отбрасываются, поэтому финальная временная сложность — O(N). Это отличный, линейный результат.

    2. Пространственная сложность (Space Complexity): O(1) (или O(K))
*/
public class Task8 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            Character item = s.charAt(index);
            int count = 1;
            if (map.get(item) != null) {
                count = map.get(item);
                count++;
            }
            map.put(item, count);
        }

        for (int index = 0; index < t.length(); index++) {
            Character item = t.charAt(index);
            if (map.get(item) == null) {
                return false;
            }
            int count = map.get(item);
            map.put(item, --count);
        }

        for (int index = 0; index < s.length(); index++) {
            Character item = s.charAt(index);
            int count = map.get(item);
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
