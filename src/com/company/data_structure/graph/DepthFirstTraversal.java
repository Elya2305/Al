package com.company.data_structure.graph;

import java.util.*;

/**
 * uses stack
 */
public class DepthFirstTraversal {
    public static void main(String[] args) {

/**
 a -> c
 |
 b ->d ....
 **/
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c"));
        graph.put("b", List.of("d"));
        graph.put("c", List.of("e"));
        graph.put("d", List.of("f"));
        graph.put("e", List.of());
        graph.put("f", List.of());
        graph.put("g", List.of());

        dft(graph, "a");
        System.out.println(hasPath(graph, "a", "d"));
        System.out.println(hasPath(graph, "a", "g"));
    }

    public static void dft(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while (!stack.empty()) {
            String current = stack.pop();
            System.out.println(current);
            for (String node : graph.get(current)) {
                stack.push(node);
            }
        }
    }

    public static boolean hasPath(Map<String, List<String>> graph, String source, String destination) {
        Stack<String> stack = new Stack<>();
        stack.push(source);

        while (!stack.empty()) {
            String current = stack.pop();
            if (Objects.equals(current, destination)) return true;
            for (String node : graph.get(current)) {
                stack.push(node);
            }
        }
        return false;
    }
}
