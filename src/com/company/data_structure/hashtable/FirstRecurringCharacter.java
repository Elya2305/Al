package com.company.data_structure.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {
    public static void main(String[] args) {
         System.out.println(firstRecurring(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
    }

    public static int firstRecurring(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : arr) {
            if (map.get(num) != null) return num;
            map.put(num, true);
        }
        return -1; // O(n)
    }
}
