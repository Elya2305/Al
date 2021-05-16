package com.company.data_structure.string;

public class OneAway {

    public static void main(String[] args) {
        System.out.println(checkInsertOrDeleteOrUpdate("pale", "bale"));

    }

    private static boolean checkInsertOrDeleteOrUpdate(String val1, String val2) {
        if (Math.abs(val1.length() - val2.length()) > 1) return false;

        if (val1.length() < val2.length()) {
            String temp = val1;
            val1 = val2;
            val2 = temp;
        }

        int index1 = 0;
        int index2 = 0;

        boolean deleted = false;
        boolean changed = false;

        while (index1 < val1.length() && index2 < val2.length()) {
            if (val1.charAt(index1) != val2.charAt(index2)) {
                if (val1.length() == val2.length()) {
                    if (changed) return false;
                    changed = true;
                } else {
                    if (deleted) return false;
                    deleted = true;
                    index1++;
                    continue;
                }
            }
            index1++;
            index2++;
        }
        return true;
    }
}
