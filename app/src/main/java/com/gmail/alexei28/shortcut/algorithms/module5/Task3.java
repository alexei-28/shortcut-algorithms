package com.gmail.alexei28.shortcut.algorithms.module5;

/*
    69. Sqrt(x)
    https://leetcode.com/problems/sqrtx/description/
    Given a non-negative integer x, return the square root of x rounded down to the integer.
    The returned integer should be non-negative as well.
    You must not use any built-in exponent function or operator.
    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

    Example 1:
    Input: x = 4
    Output: 2
    Explanation: The square root of 4 is 2, so we return 2.

    Example 2:
    Input: x = 8
    Output: 2
*/
public class Task3 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        int result = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow of integer
            // To avoid integer overflow, compare mid with x / mid instead of calculating mid * mid <= x.
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
