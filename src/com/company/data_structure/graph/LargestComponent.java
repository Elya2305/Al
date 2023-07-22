package com.company.data_structure.graph;

import java.util.*;

public class LargestComponent {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(8, 1, 5));
        graph.put(1, List.of(0));
        graph.put(5, List.of(0, 8));
        graph.put(8, List.of(0, 5));
        graph.put(2, List.of(3, 4));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(2, 3));

        System.out.println(largestComponentSize(graph));
    }


    public static int largestComponentSize(Map<Integer, List<Integer>> graph) {

        HashSet<Integer> visited = new HashSet<>();
        int maxComponentSize = 0;

        for (Integer node : graph.keySet()) {
            int traverseCount = traverse(graph, node, visited);
            maxComponentSize = Math.max(maxComponentSize, traverseCount);
        }

        return maxComponentSize;
    }

    public static int traverse(Map<Integer, List<Integer>> graph, Integer source, Set<Integer> visited) {
        if (visited.contains(source)) return 0;
        visited.add(source);

        int result = 1;
        for (Integer node : graph.get(source)) {
            result += traverse(graph, node, visited);
        }

        return result;
    }
}
