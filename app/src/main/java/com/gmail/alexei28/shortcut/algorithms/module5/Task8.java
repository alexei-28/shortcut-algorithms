package com.gmail.alexei28.shortcut.algorithms.module5;

/*
    875. Koko Eating Bananas
    https://leetcode.com/problems/koko-eating-bananas/description/
    Koko loves to eat bananas. There are n piles of bananas, the i-th pile has piles[i] bananas.
    The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    Return the minimum integer k such that she can eat all the bananas within h hours.

    Example 1:
    Input: piles = [3,6,7,11], h = 8
    Output: 4

    Example 2:
    Input: piles = [30,11,23,4,20], h = 5
    Output: 30

    Example 3:
    Input: piles = [30,11,23,4,20], h = 6
    Output: 23

    Паттерн:
    Бинарный поиск по ответу
*/
public class Task8 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Find the maximum pile size to set the upper bound of binary search
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                result = mid; // Record the valid speed
                right = mid - 1; // Try to find a smaller speed
            } else {
                left = mid + 1; // Speed is too slow, increase it
            }
        }

        return result;
    }

    // Helper function to check if Koko can finish all piles within h hours at speed k
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; // Use long to prevent potential overflow
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / k)
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
}
