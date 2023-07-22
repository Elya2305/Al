package com.company.data_structure.graph;

import java.util.*;

/**
* uses queue
* */
public class BreathFirstTraversal {
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

        bft(graph, "a");
    }

    public static void bft(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);
            for (String node : graph.get(current)) {
                queue.add(node);
            }
        }
    }
}
