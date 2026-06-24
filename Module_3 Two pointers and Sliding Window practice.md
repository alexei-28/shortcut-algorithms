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


### 141. Linked List Cycle [Easy]

Source: https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Решение:

Solution: [Task2.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/twopointers/Task2.java)

Tests: [Task2Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/twopointers/Task2Test.java)


### 19. Remove Nth Node From End of List [Easy]

Source: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Решение:

Solution: [Task3.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/twopointers/Task3.java)

Tests: [Task3Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/twopointers/Task3Test.java)
