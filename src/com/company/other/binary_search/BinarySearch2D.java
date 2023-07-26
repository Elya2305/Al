package com.company.other.binary_search;

public class BinarySearch2D {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1},
                {3},
        };
        searchMatrix(arr, 1);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = findPotentialRow(matrix, target);
        return binarySearchInColumn(matrix, target, rowIdx);
    }

    private static int findPotentialRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    private static boolean binarySearchInColumn(int[][] matrix, int target, int rowIdx) {
        int[] arr = matrix[rowIdx];
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchMatrixWow(int[][] matrix, int target) {
        int rows = matrix.length,
                cols = matrix[0].length,
                row = 0, col = cols - 1;

        while (row < rows && col > -1) {
            int cur = matrix[row][col];
            if (cur == target) return true;
            if (target > cur) row++;
            else col--;
        }

        return false;
    }
}

