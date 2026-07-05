package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
    Longest Substring Without Repeating Characters [Medium]
    Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

    Given a string s, find the length of the longest substring without duplicate characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Решение:
    Используем скользящее окно переменного размера. Левая граница (left) и правая граница (right) определяют
    окно без повторяющихся символов. Хеш-сет (HashSet) отслеживает символы в окне. Когда встречаем символ,
    который уже есть в окне, двигаем left вправо, пока не удалим этот символ из хеш-сета.
    На каждом шаге обновляем максимальную длину.
    Каждый символ добавляется и удаляется из хеш-сета максимум один раз, что даёт O(n).

    Сложность:
    Время: O(n) — каждый символ добавляется и удаляется максимум один раз
    Память: O(min(n, m)) — где m — размер алфавита

    Примечание по сложности:
    Обновление окна здесь занимает O(1) для проверки (contains) и O(1) для добавления/удаления (хеш-сет операции).
    Однако худший случай, когда каждый символ вызывает удаление (например, строка "aaaaa..."), может привести к O(n^2) по времени.
    В среднем же для случайных строк это O(n).
*/
public class Task3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);
            while (charSet.contains(charRight)) {
                char charLeft = s.charAt(left);
                charSet.remove(charLeft);
                left++;
            }

            charSet.add(charRight);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
