package com.company.data_structure.graph;

import java.util.*;

public class ConnectedComponentCount {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(3, List.of());
        graph.put(4, List.of(6));
        graph.put(6, List.of(4, 5, 7, 8));
        graph.put(8, List.of(6));
        graph.put(7, List.of(6));
        graph.put(5, List.of(6));
        graph.put(1, List.of(2));
        graph.put(2, List.of(1));

        System.out.println(countConnectedComponents(graph));
    }

    public static int countConnectedComponents(Map<Integer, List<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        int components = 0;

        for (Integer node : graph.keySet()) {
            if(traverse(graph, node, visited)) components++;
        }

        return components;
    }

    public static boolean traverse(Map<Integer, List<Integer>> graph, Integer source, Set<Integer> visited) {
        if (visited.contains(source)) return false;
        visited.add(source);

        for (Integer node : graph.get(source)) {
            traverse(graph, node, visited);
        }

        return true;
    }


    /// todo
//    public static void traverse(Map<Integer, List<Integer>> graph, Integer source, Set<Integer> visited) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(source);
//
//        while (!stack.empty()) {
//            Integer current = stack.pop();
//            if(visited.contains(current)) continue;
//            System.out.println(current);
//            for (Integer node : graph.get(current)) {
//                stack.push(node);
//            }
//        }
//    }


}
