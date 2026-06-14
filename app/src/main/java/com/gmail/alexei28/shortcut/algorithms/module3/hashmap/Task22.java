package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
    205. Isomorphic Strings [Easy]
    Source: https://leetcode.com/problems/isomorphic-strings/
    Given two strings 's' and 't', determine if they are isomorphic.
    Two strings 's' and 't' are isomorphic if the characters in 's' can be replaced to get 't'.
    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.

    Example 1:
    Input: s = "egg", t = "add"
    Output: true
    Explanation:
    The strings s and t can be made identical by:
    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

    Example 2:
    Input: s = "f11", t = "b23"
    Output: false
    Explanation:
    The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

    Example 3:
    Input: s = "paper", t = "title"
    Output: true

    Constraints:
    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.

    Решение:
    1. Временная сложность (Time Complexity): O(N * M) в худшем случае или O(N) в среднем.
    2. Пространственная сложность (Space Complexity): O(M)

    Comment:
    Лучше доп структура
*/
public class Task22 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char currentKey = s.charAt(index);
            char currentValue = t.charAt(index);
            if (map.containsKey(currentKey)) {
                if (map.get(currentKey) != currentValue) {
                    return false;
                }
            } else {
                if (map.containsValue(currentValue)) {
                    return false;
                }
                map.put(currentKey, currentValue);
            }
        }
        return true;
    }
}
