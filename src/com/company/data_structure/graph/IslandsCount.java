package com.company.data_structure.graph;

public class IslandsCount {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '1', '0'},
                {'1', '1', '0', '0', '1', '0'},
                {'0', '1', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '0'},
                {'0', '1', '0', '1', '1', '0'},
                {'0', '0', '0', '0', '0', '1'},
        };

        System.out.println(countIslands(grid));
    }

    public static int countIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (traverse(grid, i, j, visited)) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    private static boolean traverse(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return false;
        }
        if (grid[i][j] == '0') return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;

        traverse(grid, i - 1, j, visited);
        traverse(grid, i + 1, j, visited);
        traverse(grid, i, j + 1, visited);
        traverse(grid, i, j - 1, visited);

        return true;
    }
}
