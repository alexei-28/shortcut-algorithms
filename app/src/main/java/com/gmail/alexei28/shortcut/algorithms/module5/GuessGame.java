package com.gmail.alexei28.shortcut.algorithms.module5;

public class GuessGame {
    int pick = 10;

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    public int guess(int num) {
        if (num == pick) {
            return 0;
        }
        if (num > pick) {
             return -1; // num is higher than the picked number
         } else {
            return 1; // num is lower than the picked number
        }
     }
}
