package com.company.data_structure.graph;

import java.util.*;

import static java.lang.Integer.parseInt;

// O(n) (number of nodes)

public class ShortestPath {
    public static void main(String[] args) {
        String[][] edges = new String[][]{{"w", "x"}, {"x", "y"}, {"z", "y"}, {"z", "v"}, {"w", "v"}};
        Map<String, List<String>> graph = convertToGraph(edges);
        System.out.println(shortestPath(graph, "w", "z"));
    }

    // bfs
    public static int shortestPath(Map<String, List<String>> graph, String source, String destination) {
        Queue<String[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new String[]{source, "0"});

        while (!queue.isEmpty()) {
            String[] nodeWithDistance = queue.poll();
            String current = nodeWithDistance[0];
            if (current.equals(destination)) {
                return parseInt(nodeWithDistance[1]);
            }
            if (visited.contains(current)) continue;
            visited.add(current);
            for (String node : graph.get(current)) {
                queue.add(new String[]{node, String.valueOf(parseInt(nodeWithDistance[1]) + 1)});
            }
        }
        return -1;
    }

    private static Map<String, List<String>> convertToGraph(String[][] edges) {
        Map<String, List<String>> map = new HashMap();
        for (String[] edge : edges) {
            List<String> lst1 = map.getOrDefault(edge[0], new ArrayList<>());
            lst1.add(edge[1]);
            List<String> lst2 = map.getOrDefault(edge[1], new ArrayList<>());
            lst2.add(edge[0]);
            map.put(edge[0], lst1);
            map.put(edge[1], lst2);
        }
        return map;
    }
}
