package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

/*
    125. Valid Palindrome [Easy]
    Source: https://leetcode.com/problems/valid-palindrome/description/

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
    it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.

    Constraints:
    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.

    Решение:
    Использование паттерна два указателя (two pointers).

    Сложность:
    Время: O(n) — проходим строку от обоих концов к центру
    Память: O(1) — используем только два указателя
*/
public class Task1 {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Пропускаем неалфавитные символы слева
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Пропускаем неалфавитные символы справа
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
