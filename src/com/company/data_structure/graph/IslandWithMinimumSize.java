package com.company.data_structure.graph;

public class IslandWithMinimumSize {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '1', '0'},
                {'1', '1', '0', '0', '1', '0'},
                {'0', '1', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1', '0'},
                {'0', '0', '0', '1', '1', '0'},
                {'0', '0', '0', '0', '0', '0'},
        };

        System.out.println(minimumSize(grid));
    }

    public static int minimumSize(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int min = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    int islandCount = countIsland(grid, i, j, visited);
                    if (islandCount > 0) {
                        if (min == -1) {
                            min = islandCount;
                        } else {
                            min = Math.min(min, islandCount);
                        }
                    }
                }
            }
        }

        return min;
    }

    private static int countIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return 0;
        }
        if (grid[i][j] == '0') return 0;
        if (visited[i][j]) return 0;
        visited[i][j] = true;

        int size = 1;
        size += countIsland(grid, i - 1, j, visited);
        size += countIsland(grid, i + 1, j, visited);
        size += countIsland(grid, i, j + 1, visited);
        size += countIsland(grid, i, j - 1, visited);
        return size;
    }
}
