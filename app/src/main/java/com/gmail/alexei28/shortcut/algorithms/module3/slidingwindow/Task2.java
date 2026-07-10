package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

/*
    Maximum Average Subarray I [Easy]
    Source: https://leetcode.com/problems/maximum-average-subarray-i/
    You are given an integer array nums consisting of n elements, and an integer k.
    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    Any answer with a calculation error less than 10^-5 will be accepted.

    Example 1:
    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

    Example 2:
    Input: nums = [5], k = 1
    Output: 5.00000

    Constraints:
    n == nums.length
    1 <= k <= n <= 10^5
    -10^4 <= nums[i] <= 10^4

    Решение:
    Используем скользящее окно фиксированного размера k. Вычисляем сумму первого окна из k элементов.
    Затем для каждого следующего окна вычитаем элемент, который выходит из окна, и прибавляем элемент, который входит.
    Это даёт сумму нового окна за O(1) — мы просто обновляем сумму, поддерживая агрегат. Среднее значение вычисляем как сумма / k.

    Общая сложность O(n).
    1. Временная сложность (Time Complexity): O(n) - проходим массив один раз.
       Где n — это количество элементов в массиве nums.
       - Первый цикл for выполняется ровно k раз, чтобы посчитать сумму начального окна.
       - Второй цикл for продолжается от индекса k до конца массива (то есть выполняется n - k раз).
         Внутри этого цикла все операции (вычитание, сложение и поиск максимума через Math.max) занимают константное время O(1).
       - Суммарно код делает k + (n - k) = n итераций. Таким образом, сложность линейная — алгоритм проходит по массиву ровно один раз.

    2. Пространственная сложность (Space Complexity): O(1) - используем только сумму и максимум.
       - Алгоритм использует только фиксированное количество дополнительных переменных (windowSum, maxSum, right, i),
         которые занимают память типа int.
       - Вы не создаете новых массивов или других структур данных, размер которых зависел бы от размера входного массива nums.
         Память остается константной независимо от того, передали вам 10 элементов или 10 миллионов.
*/
public class Task2 {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        // Сумма первого окна
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        // Сдвигаем окно
        for (int right = k; right < nums.length; right++) {
            windowSum = windowSum - nums[right - k] + nums[right];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum / k;
    }
}
