package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static boolean task1(String s) {
        return s.matches("^automation_\\d{8}_(.){6}@solvd.com");
    }

    public static List<String> task2(String s) {
        String replacedCharsStr = s.replaceAll("[+() -]", "");
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(replacedCharsStr);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(replacedCharsStr.substring(matcher.start(), matcher.end()));
        }
        return list;
    }

    public static String task4(String s) {
        Pattern pattern = Pattern.compile("\\[.+\\]");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return s.substring(matcher.start() + 1, matcher.end() - 1);
        }
        return "";
    }

    public static String task3(String s, String key) {
        Pattern pattern = Pattern.compile("(?<=\""+key+"\":).*?(?=[,}])");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return s.substring(matcher.start(), matcher.end()).trim().replaceAll("'","");
        }
        return "";
    }
}