package org.example;

public class RegularExpressions {
    public static boolean task1(String s) {
        return s.matches("^automation_[0-9]{8}_(.){6}@solvd.com");
    }
}