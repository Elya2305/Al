package com.company.data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
//        int[][] result = setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        int[][] result = setZeroes(new int[][]{ {0, 1, 2, 0},
                                                {3, 4, 5, 2},
                                                {1, 3, 1, 5}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] setZeroes(int[][] matrix) {
        if (matrix.length == 0) return matrix;
        List<int[]> indexes = new ArrayList<>(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    indexes.add(new int[]{i, j});
                }
            }
        }
        for (int[] index : indexes) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][index[1]] = 0;
            }
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[index[0]][col] = 0;
            }
        }
        return matrix;
    }
}
