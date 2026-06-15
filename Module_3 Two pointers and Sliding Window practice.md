## Упражнения к лекции 3: Два указателя и скользящее окно

### Модуль 3
- Теория: https://web.shortcut.education/lms/algo/lecture_03/two_pointers_sliding_window/
- Практика: https://web.shortcut.education/lms/algo/lecture_03/two_pointers_sliding_window_practice/

## Two pointers

### 125. Valid Palindrome [Easy]

Source https://leetcode.com/problems/valid-palindrome/description/

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

````
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
````
Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

Решение:

Solution: [Task1.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/twopointers/Task1.java)

Tests: [Task1Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/twopointers/Task1Test.java)
