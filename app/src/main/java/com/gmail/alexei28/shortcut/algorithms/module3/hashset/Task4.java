package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    Задание 4: Find All Disappeared Numbers in an Array [Easy]
    Паттерн: Удаление дубликатов (HashSet для работы с уникальными элементами)
    Пример из лекции: Убрать дубликаты из массива, оставить только уникальные.

    Пусть задан массив nums, состоящий из n целых чисел, где nums[index] находится в диапазоне [1, n].
    Верните массив всех целых чисел в диапазоне [1, n], которые не встречаются в массиве nums.
    Источник: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    Пример 1:
    Вход: [4, 3, 2, 7, 8, 2, 3, 1]
    Выход: [5, 6] (числа от 1 до 8, отсутствуют 5 и 6)

    Пример 2:
    Вход: [1, 1]
    Выход: [2] (числа от 1 до 2, отсутствует 2)

    Требования:
    - Временная сложность: O(n)
    - Массив может содержать дубликаты

    Решение:
    - Временная сложность: O(n)
      Здесь n — это длина исходного массива nums.
      1. Первый цикл "for" итерируется по всем n элементам массива и добавляет их в HashSet.
         Операция добавления (add) в хэш-таблицу в среднем выполняется за константное время O(1). Итого на первый цикл уходит O(n) времени.
      2. Второй цикл "for" всегда выполняется ровно n раз (от 1 до nums.length). Операция проверки наличия элемента (contains) в HashSet
         в среднем занимает O(1). Итого на второй цикл также уходит O(n) времени.
      Суммарное время: O(n) + O(n) = O(2n), что в нотации «О» большое упрощается до O(n).
    - Пространственная сложность: O(n)
      В худшем случае (когда в массиве nums все элементы уникальны, например [1, 2, 3]), ваш HashSet сохранит ровно n элементов.
      Память, занимаемая хэш-таблицей, растет линейно в зависимости от размера входных данных.
*/
public class Task4 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int num = 1; num <= nums.length; num++) {
            if (!hashSet.contains(num)) {
                result.add(num);
            }
        }
        return  result;
    }
}
