package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.*;

/*
    Задание 10: Group Anagrams [Medium]
    Паттерн: Группировка по ключу (HashMap для группировки элементов)
    Пример из лекции: Сгруппировать слова по длине
    Задача встречается на собеседованиях в Яндекс
    Сгруппируйте слова-анаграммы вместе.
    Источник: https://leetcode.com/problems/group-anagrams/

    Пример:
    Вход: ["eat", "tea", "tan", "ate", "nat", "bat"]
    Выход: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]] (порядок не важен)

    Требования:
    - Временная сложность: O(n·k·log k), где n — количество слов, k — средняя длина слова

    Подсказка
    Отсортируйте символы в каждом слове и используйте отсортированную строку как ключ в HashMap. Все слова с одинаковым ключом — анаграммы.

    Решение:
    Для оценки введем две переменные:
    N — количество строк в массиве strs.
    K — максимальная длина одной строки.
    1. Временная сложность (Time Complexity): O(N * K * log K)
       - Основное время тратится внутри цикла for, который обходит каждую из N строк.
         Вот что происходит на каждой итерации:Преобразование строки в массив символов и создание новой строки: Занимает время O(K).
       - Сортировка массива символов Arrays.sort(chars): Так как длина строки равна K, сортировка (обычно Dual-Pivot Quicksort
         или Timsort для символов) занимает O(K log K) операций.
       - Операции с HashMap (get и put): В среднем работают за O(1) (в худшем случае из-за коллизий может быть O(K) для сравнения строк-ключей,
         но на практике мы ориентируемся на среднее время). Временем вычисления хэш-функции от строки длины K можно считать O(K),
         но оно поглощается более тяжелой сортировкой.
      Второй цикл for, который переносит списки из map в result, суммарно делает N итераций
      (так как общее количество элементов во всех списках хэш-таблицы равно N), что дает O(N).

      Итог: Мы делаем N раз операцию сортировки строки длины K. Общая временная сложность: O(N * K * log K).

      2. Пространственная сложность (Space Complexity): O(N * K)
*/
public class Task10 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            List<String> list = map.get(sorted);
            if (list != null) {
                list.add(str);
            } else {
                List<String> initList = new ArrayList<>();
                initList.add(str);
                map.put(sorted, initList);
            }
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }
}