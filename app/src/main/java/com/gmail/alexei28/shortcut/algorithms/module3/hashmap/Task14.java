package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

/*
    Задание 14: Longest Consecutive Sequence [Medium]

    Источник: https://leetcode.com/problems/longest-consecutive-sequence/

    Дан несортированный массив целых чисел. Найдите длину самой длинной последовательности подряд идущих чисел.

    Пример:

    Вход: [100, 4, 200, 1, 3, 2]
    Выход: 4 (последовательность: 1, 2, 3, 4)
    Вход: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    Выход: 9 (последовательность: 0, 1, 2, 3, 4, 5, 6, 7, 8)

    Требования:
    - Временная сложность: O(n)
    - Пространственная сложность: O(n)

    Подсказка
    Используйте HashSet для хранения всех чисел массива.
    Для каждого числа проверяйте, есть ли num-1, num-2 и продолжайте последовательность в обе стороны.

    Решение:
    1. Временная сложность (Time Complexity): O(n)
    2. Пространственная сложность (Space Complexity): O(n)
*/

import java.util.HashSet;
import java.util.Set;

public class Task14 {
    public int longestConsecutive(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all elements to a HashSet to eliminate duplicates
        // and allow O(1) time complexity lookups.
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through the elements to find sequences
        // Crucial optimization: Iterate through the SET, not the array,
        // to avoid wasting time on duplicate numbers.
        for (int num : set) {

            // Check if the current number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand the sequence forward
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the maximum sequence length found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
