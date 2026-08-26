package com.gmail.alexei28.shortcut.algorithms.module4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
    https://leetcode.com/problems/backspace-string-compare/description/
    844. Backspace String Compare [Easy]
    Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    '#' means a backspace character.
    Note that after backspacing an empty text, the text will continue empty.

    Example 1:
    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".

    Example 2:
    Input: s = "ab##", t = "c#d#"
    Output: true
    Explanation: Both s and t become "".

    Example 3:
    Input: s = "a#c", t = "b"
    Output: false
    Explanation: s becomes "c" while t becomes "b".

    The overall time complexity is O(N + M), where N is the length of string s and M is the length of string t.
*/
public class Task3 {

    public boolean backspaceCompare(String s, String t) {
        Deque<Character> dequeS = new ArrayDeque<>();
        Deque<Character> dequeT = new ArrayDeque<>();

        for (int index = 0; index < s.length(); index++) {
            char currentChar = s.charAt(index);
            if (currentChar != '#') {
                dequeS.push(currentChar);
            } else {
                if (!dequeS.isEmpty()) {
                    dequeS.pop();
                }
            }
        }

        for (int index = 0; index < t.length(); index++) {
            char currentChar = t.charAt(index);
            if (currentChar != '#') {
                dequeT.push(currentChar);
            } else {
                if (!dequeT.isEmpty()) {
                    dequeT.pop();
                }
            }
        }
        return new ArrayList<>(dequeS).equals(new ArrayList<>(dequeT));
    }
}
