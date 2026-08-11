package com.gmail.alexei28.shortcut.algorithms.strings;

/*
    Find a correct mirror string
    AspPSa – valid
    aspPSA – valid
    Ajsldfjl - invalid

    Временная сложность: O(N)
    Пространственная сложность: O(1)
*/

public class Task1 {
    public boolean isMirror(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        if (text.length() % 2 != 0) {
            return false;
        }

        int leftIndex = 0;
        int rightIndex = text.length() - 1;
        boolean result = false;
        while (leftIndex < rightIndex) {
            String firstChar = String.valueOf(text.charAt(leftIndex));
            String secondChar = String.valueOf(text.charAt(rightIndex));
            if (!firstChar.equals(secondChar) && firstChar.equalsIgnoreCase(secondChar)) {
                result = true;
            } else {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return result;
    }
}
