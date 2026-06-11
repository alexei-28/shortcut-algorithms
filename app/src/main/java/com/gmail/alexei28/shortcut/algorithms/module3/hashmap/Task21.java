package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

import java.util.*;

/*
    290. Word Pattern [Easy]
    Source: https://leetcode.com/problems/word-pattern/description/
    Given a pattern and a string 's', find if 's' follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in 's'.
    Specifically:
    - Each letter in pattern maps to exactly one unique word in 's'.
    - Each unique word in 's' maps to exactly one letter in pattern.
    - No two letters map to the same word, and no two words map to the same letter.

    Example 1:
    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true
    Explanation:
    The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".

    Example 2:
    Input: pattern = "abba", s = "dog cat cat fish"
    Output: false

    Example 3:
    Input: pattern = "aaaa", s = "dog cat cat dog"
    Output: false

    Example 4:
    Input: pattern = "aba", s = "dog cat cat"
    Output: false

    Constraints:
    1 <= pattern.length <= 300
    pattern contains only lower-case English letters.
    1 <= s.length <= 3000
    s contains only lowercase English letters and spaces ' '.
    s does not contain any leading or trailing spaces.
    All the words in s are separated by a single space.

    Решение:
    1. Временная сложность (Time Complexity):
       O(N), где N — это количество символов в строке s (или общая длина всех слов плюс пробелы).

    2. Пространственная сложность (Space Complexity): O(N)
*/
public class Task21 {
    public boolean wordPattern(String pattern, String s) {
        String[] arrStrings = s.split(" ");
        if (pattern.length() != arrStrings.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        for (int index =0; index < chars.length; index++) {
            char currentPattern = chars[index];
            if (map.containsKey(currentPattern)) {
                String currentWord = map.get(currentPattern);
                if (!currentWord.equals(arrStrings[index])) {
                    return false;
                }
            } else {
                if (map.containsValue(arrStrings[index])) {
                    return false;
                }
                map.put(currentPattern, arrStrings[index]);
            }
        }
        return true;
    }
}
