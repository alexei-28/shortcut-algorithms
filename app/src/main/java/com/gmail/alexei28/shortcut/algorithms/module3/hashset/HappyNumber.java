package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import java.util.HashSet;
import java.util.Set;

/*
    202. Happy Number [Easy]
    https://leetcode.com/problems/happy-number/description/?envType=problem-list-v2&envId=hash-table

    Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:
    - Starting with any positive integer, replace the number by the sum of the squares of its digits.
    - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    - Those numbers for which this process ends in 1 are happy.

    Return true if n is a happy number, and false if not.

    Example 1:
    Input: n = 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

    Example 2:
    Input: n = 2
    Output: false
*/
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // Helper function to calculate the sum of squares of digits
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;  // последняя цифра
            sum += digit * digit;
            n = n / 10;  // убираем последнюю цифру
        }
        return sum;
    }
}
