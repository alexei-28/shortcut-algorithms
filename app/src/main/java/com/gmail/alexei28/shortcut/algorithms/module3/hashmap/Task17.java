package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.HashMap;
import java.util.Map;

/*

    383. Ransom Note [Easy]
    Source: https://leetcode.com/problems/ransom-note/description/
    Паттерн "Частотный анализ" (HashMap).
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine
    and false otherwise. Each letter in magazine can only be used once in ransomNote.

    Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

    Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

    Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true

    Решение:
    1. Временная сложность (Time Complexity): O(M + N)
    2. Пространственная сложность (Space Complexity): O(1) (константная)
*/
public class Task17 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        for (char item : magazine.toCharArray()) {
            int value = map.getOrDefault(item, 0);
            map.put(item, value + 1);
        }

        for (char item : ransomNote.toCharArray()) {
            int count = map.getOrDefault(item, 0);
            if (count == 0) {
                return false;
            }
            map.put(item, count - 1);
        }
        return true;
    }
}
