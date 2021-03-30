package com.filtertest.demo.filter;

//判断字符串和pattern是否匹配
public class URLPatternMatcher  {
    private static final URLPatternMatcher INSTANCE = new URLPatternMatcher();

    public URLPatternMatcher() {
    }

    public static URLPatternMatcher getInstance() {
        return INSTANCE;
    }

    //匹配源地址和pattern是否匹配
    //返回:true:匹配 ,false:不匹配
    public boolean matches(String pattern, String source) {
        if (pattern != null && source != null) {
            pattern = pattern.trim();
            source = source.trim();
            int start;
            if (pattern.endsWith("*")) {
                start = pattern.length() - 1;
                if (source.length() >= start && pattern.substring(0, start).equals(source.substring(0, start))) {
                    return true;
                }
            } else if (pattern.startsWith("*")) {
                start = pattern.length() - 1;
                if (source.length() >= start && source.endsWith(pattern.substring(1))) {
                    return true;
                }
            } else if (pattern.contains("*")) {
                start = pattern.indexOf("*");
                int end = pattern.lastIndexOf("*");
                if (source.startsWith(pattern.substring(0, start)) && source.endsWith(pattern.substring(end + 1))) {
                    return true;
                }
            } else if (pattern.equals(source)) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
