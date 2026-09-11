package com.gmail.alexei28.shortcut.algorithms.module4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
    71. Simplify Path [Medium]
    https://leetcode.com/problems/simplify-path/description/

    You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
    Your task is to transform this absolute path into its simplified canonical path.

    The rules of a Unix-style file system are as follows:
    A single period '.' represents the current directory.
    A double period '..' represents the previous/parent directory.
    Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    Any sequence of periods that does not match the rules above should be treated as a valid directory or file name.
    For example, '...' and '....' are valid directory or file names.
    The simplified canonical path should follow these rules:

    The path must start with a single slash '/'.
    Directories within the path must be separated by exactly one slash '/'.
    The path must not end with a slash '/', unless it is the root directory.
    The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
    Return the simplified canonical path.

    Example 1:
    Input: path = "/home/"
    Output: "/home"

    Explanation:
    The trailing slash should be removed.

    Example 2:
    Input: path = "/home//foo/"
    Output: "/home/foo"

    Explanation:
    Multiple consecutive slashes are replaced by a single one.

    Example 3:
    Input: path = "/home/user/Documents/../Pictures"
    Output: "/home/user/Pictures"

    Explanation:
    A double period ".." refers to the directory up a level (the parent directory).

    Example 4:
    Input: path = "/../"
    Output: "/"

    Explanation:
    Going one level up from the root directory is not possible.

    Example 5:
    Input: path = "/.../a/../b/c/../d/./"
    Output: "/.../b/d"

    Explanation:
    "..." is a valid name for a directory in this problem.

    Complexity:
    Time complexity of this solution is O(N), where N is the length of the input path string.
*/
public class Task7 {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = path.split("/");
        for (String currentItem : tokens) {
            if (currentItem.isEmpty() || currentItem.equals(".")) {
                continue;
            }
            if (currentItem.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push("/" + currentItem);
            }
        }

        if (stack.isEmpty()) {
            return "/"; // Going one level up from the root directory is not possible.
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int index = 0; index < size; index++) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
