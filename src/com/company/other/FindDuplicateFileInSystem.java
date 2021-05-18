package com.company.other;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDuplicateFileInSystem {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        String CONTENT_REGEXP = "(\\([a-z]+\\))";
        Pattern pattern = Pattern.compile(CONTENT_REGEXP);

        Map<String, List<String>> mem = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String dir = files[0];
            if (files.length == 1) continue;
            for (int i = 1; i < files.length; i++) {
                String file = files[i];
                Matcher matcher = pattern.matcher(file);
                if (matcher.find()) {
                    String content = matcher.group(0);
                    List<String> byContent = mem.getOrDefault(content, new ArrayList<>());
                    byContent.add(dir + "/" + file.replaceAll(CONTENT_REGEXP, ""));
                    mem.put(content, byContent);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();

        for (Collection<String> files : mem.values()) {
            if (files.size() > 1) {
                res.add(new ArrayList<>(files));
            }
        }
        return res;
    }
}
