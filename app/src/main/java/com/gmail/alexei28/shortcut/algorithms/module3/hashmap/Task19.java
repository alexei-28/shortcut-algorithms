package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
    136. Single Number [Easy]
    Source: https://leetcode.com/problems/single-number/description/
    Паттерн "Частотный анализ" (HashMap).
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1

    Решение:
    1. Временная сложность (Time Complexity): O(N)
    2. Пространственная сложность (Space Complexity): O(N)
*/
public class Task19 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}
