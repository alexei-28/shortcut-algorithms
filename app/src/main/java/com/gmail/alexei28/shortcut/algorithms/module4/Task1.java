package com.gmail.alexei28.shortcut.algorithms.module4;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    20. Valid Parentheses [Easy]
    https://leetcode.com/problems/valid-parentheses/description/

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false

    Example 4:
    Input: s = "([])"
    Output: true

    Example 5:
    Input: s = "([)]"
    Output: false

    Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

    Требования:
    Временная сложность: O(n), где n — длина строки
    Пространственная сложность: O(n) в худшем случае
*/
public class Task1 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // Открывающая скобка
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            // Закрывающая скобка
            if (stack.isEmpty()) {
                return false;
            }

            char open = stack.pop();
            if (c == ')' && open != '(') {
                return false;
            }

            if (c == ']' && open != '[') {
                return false;
            }

            if (c == '}' && open != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
