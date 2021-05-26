package com.company.data_structure.array;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] result = rotateMatrixInPlace(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] rotateMatrixNotInPlace(int[][] array) {
        int[][] newArr = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                newArr[j][array.length - i - 1] = array[i][j];
            }
        }
        return newArr;
    }

    private static int[][] rotateMatrixInPlace(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return matrix;
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return matrix;
    }
}
