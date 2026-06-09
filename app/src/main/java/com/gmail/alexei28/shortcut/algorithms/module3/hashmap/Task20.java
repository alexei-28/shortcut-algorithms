package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.*;

/*
    347. Top K Frequent Elements [Medium]
    Source: https://leetcode.com/problems/top-k-frequent-elements/description/
    Паттерн "Частотный анализ" (HashMap).
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Example 3:
    Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
    Output: [1,2]

    Решение:
    1. Временная сложность (Time Complexity)
        Итог по времени:Общая сложность складывается из: O(N) + O(U log U) + O(U * k).
        В худшем случае, когда все элементы уникальны (U = N), а k пропорционально N (например, k = N / 2),
        сложность O(U * k) превращается в O(N^2).
    2. Пространственная сложность (Space Complexity)
       В худшем случае (U = N) общая пространственная сложность составляет O(N).
*/
public class Task20 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Collections.reverseOrder());
        List<Integer> subValues = values.subList(0, k);
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (subValues.contains(value)) {
                result[index] = key;
                index++;
                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}
