package com.gmail.alexei28.shortcut.algorithms.module3.twopointers;

/*
    392. Is Subsequence [Easy]
    https://leetcode.com/problems/is-subsequence/description/

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false

    Временная сложность: O(N)
    Пространственная сложность: O(1)
*/
public class Task392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            char itemS = s.charAt(index);
            char itemT = t.charAt(i);
            if (itemT == itemS) {
                index++;
                if (index > s.length() -1) {
                    break;
                }
            }
        }
        return index == s.length();
    }
}
