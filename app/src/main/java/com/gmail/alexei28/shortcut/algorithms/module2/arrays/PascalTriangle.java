package com.gmail.alexei28.shortcut.algorithms.module2.arrays;

import java.util.ArrayList;
import java.util.List;

/*
    118. Pascal's Triangle [Easy]
    https://leetcode.com/problems/pascals-triangle/description/?envType=problem-list-v2&envId=array

    Given an integer numRows, return the first numRows of Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

              1
             1 1
            1 2 1
           1 3 3 1
          1 4 6 4 1

    Example 2:
    Input: numRows = 1
    Output: [[1]]
*/
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(
                        result.get(i - 1).get(j - 1)
                                + result.get(i - 1).get(j)
                );
            }

            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }
        return result;
    }
}
