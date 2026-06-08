package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
    Задание 11: Subarray Sum Equals K [Medium]
    Источник: https://leetcode.com/problems/subarray-sum-equals-k/
    Дан массив целых чисел и целевое значение k. Найдите общее количество подмассивов, сумма которых равна k.
    A subarray is a contiguous non-empty sequence of elements within an array.
    Пример:
    Вход: nums = [1, 1, 1], k = 2
    Выход: 2 (подмассивы: [1,1] с индексами 0-1 и [1,1] с индексами 1-2)

    Вход: nums = [1, 2, 3], k = 3
    Выход: 2 (подмассивы: [1,2] и [3])

    Требования:
    - Временная сложность: O(n)

    Массив может содержать отрицательные числа

    Подсказка:
    Используйте префиксные суммы (prefix sum) и HashMap для хранения частот префиксных сумм.
    Для каждой текущей суммы проверяйте, была ли раньше сумма current_sum — k.
    Сумма от индекса L до R = prefix_sum[R] - prefix_sum[L-1].

    Решение:
    1. Временная сложность (Time Complexity): O(N)
    2. Пространственная сложность (Space Complexity): O(N)
*/
public class Task11 {
    public int subarraySum(int[] nums, int k) {
        // Количество найденных подмассивов
        int count = 0;
        // Текущая префиксная сумма
        int currentSum = 0;

        // HashMap для хранения: Ключ = префиксная сумма, Значение = сколько раз она встретилась
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();

        // Базовый случай: префиксная сумма 0 встретилась 1 раз (для подмассивов, начинающихся с 0 индекса)
        prefixSumCounts.put(0, 1);

        for (int num : nums) {
            // Обновляем текущую префиксную сумму
            currentSum += num;

            // Проверяем, была ли в прошлом сумма, которая в разности с currentSum даст k
            int targetSum = currentSum - k;
            if (prefixSumCounts.containsKey(targetSum)) {
                count += prefixSumCounts.get(targetSum);
            }

            // Сохраняем текущую префиксную сумму в HashMap
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
