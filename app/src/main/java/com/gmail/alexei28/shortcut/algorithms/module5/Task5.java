package com.gmail.alexei28.shortcut.algorithms.module5;

/*
    34. Find First and Last Position of Element in Sorted Array [Medium]
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Example 3:
    Input: nums = [], target = 0
    Output: [-1,-1]

    Временная сложность: O(log n) + O(log n) = O(2 log n) = O(log n)
    Пространственная сложность: O(1)
*/
public class Task5 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;

        // Ищем первое вхождение
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid integer overflow
            if (nums[mid] == target) {
                result[0] = mid;
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        // Ищем последнее вхождение
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid integer overflow
            if (nums[mid] == target) {
                result[1] = mid;
                left = mid + 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return result;
    }
}
