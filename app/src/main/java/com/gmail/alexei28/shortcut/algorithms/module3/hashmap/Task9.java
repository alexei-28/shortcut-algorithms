package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
    Задание 9: First Unique Character [Easy]
    Паттерн: Частотный анализ (HashMap для подсчёта частот + два прохода)
    Пример из лекции: Проверить, являются ли две строки анаграммами
    Задача встречается на собеседованиях в Яндекс

    Найдите первый неповторяющийся символ в строке.
    Источник: https://leetcode.com/problems/first-unique-character-in-a-string/

    Примеры:
    first_unique("leetcode") → 0 (индекс 'l')
    first_unique("loveleetcode") → 2 (индекс 'v')
    first_unique("aabb") → -1 (нет уникальных)

    Требования:
    - Временная сложность: O(n)

    Верните индекс первого символа, который встречается только один раз

    Решение:
    1. Временная сложность (Time Complexity): O(N)
       Где N — это длина строки s.
       Твой алгоритм работает за линейное время, так как состоит из двух последовательных независимых циклов:
       - Первый цикл for проходится по всей строке длиной N. Внутри цикла выполняются операции map.get() и map.put().
         В HashMap (в среднем) поиск и вставка занимают O(1). Значит, весь первый цикл занимает O(N).
       - Второй цикл for в худшем случае снова проходится по всей строке длиной N (если уникальный символ в самом конце или его вообще нет).
         Операция map.get() снова занимает O(1). Итого: O(N).
       Итоговая временная сложность: O(N) + O(N) = O(2N), что в нотации Большого О сокращается до O(N).

     2. Пространственная сложность (Space Complexity): O(1)
*/
public class Task9 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index  < s.length(); index++) {
            Character item = s.charAt(index);
            int count = 1;
            if (map.get(item) != null) {
                count = map.get(item);
                count++;
            }
            map.put(item, count);
        }

        for (int index = 0; index  < s.length(); index++) {
            Character item = s.charAt(index);
            int count = map.get(item);
            if (count == 1) {
                return index;
            }
        }
        return -1;
    }
}
