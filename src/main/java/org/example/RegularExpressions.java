package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static boolean task1(String s) {
        return s.matches("^automation_\\d{8}_(.){6}@solvd.com");
    }

    private static Matcher createMatcher(String regex, String s) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(s);
    }

    public static List<String> task2(String s) {
        String replacedCharsStr = s.replaceAll("[+() -]", "");
        Matcher matcher = createMatcher("1\\d{10}", replacedCharsStr);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(replacedCharsStr.substring(matcher.start(), matcher.end()));
        }
        return list;
    }

    public static String task3(String s, String key) {
        Matcher matcher = createMatcher("(?<=\"" + key + "\":).*?(?=[,}])", s);
        if (matcher.find()) {
            return s.substring(matcher.start(), matcher.end()).trim().replaceAll("'", "");
        }
        return "";
    }

    public static String task4(String s) {
        Matcher matcher = createMatcher("\\[.+\\]", s);
        if (matcher.find()) {
            return s.substring(matcher.start() + 1, matcher.end() - 1);
        }
        return "";
    }

    public static String task5(String s) {
        s = s.toLowerCase();
        Matcher matcher = createMatcher("(.)\\1*", s);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group(1));
        }
        return stringBuilder.toString();
    }
}