package com.company.data_structure.string;

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(rotateString("", ""));
    }
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;

        StringBuilder sB = new StringBuilder(s);
        StringBuilder goalB = new StringBuilder(goal);

        for (int i = 0; i < s.length(); i++) {
            sB.append(sB.charAt(0));
            sB.delete(0, 1);
            if (sB.toString().equals(goalB.toString())) return true;
        }
        return false;
    }
}
