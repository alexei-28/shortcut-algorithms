package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import java.util.HashSet;
import java.util.Set;

/*
    Задание 15: Contains Duplicate [Easy]
    Источник: https://leetcode.com/problems/contains-duplicate/description/

    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true

    Explanation:
    The element 1 occurs at the indices 0 and 3.

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation:
    All elements are distinct.

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Решение:
    1. Временная сложность (Time Complexity): O(n)
    2. Пространственная сложность (Space Complexity): O(n)
*/
public class Task15 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            if (set.contains(item)) {
                return true;
            }
            set.add(item);
        }
        return false;
    }
}
