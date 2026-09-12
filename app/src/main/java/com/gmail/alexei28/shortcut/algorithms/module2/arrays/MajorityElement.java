package com.gmail.alexei28.shortcut.algorithms.module2.arrays;

import java.util.HashMap;
import java.util.Map;

/*
    169. Majority Element [Easy]
    https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=array

    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n/2⌋ times.
    You may assume that the majority element always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Constraints:
    n == nums.length
    1 <= n <= 5 * 10^4
    -10^9 <= nums[i] <= 10^9
    The input is generated such that a majority element will exist in the array.

    Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            if (map.containsKey(item)) {
                int count = map.get(item);
                map.put(item, ++count);
            } else {
                map.put(item, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > nums.length/2) {
                majorityElement = key;
                break;
            }
        }
        return majorityElement;
    }
}
