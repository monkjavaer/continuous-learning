package com.leetcode;


/**
 * @author monkjavaer
 * @date 2021/3/22
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(zipString("aabccccaaa"));
    }

    public static String zipString(String input) {
        if (input == null || input.equals("")) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char tmp = input.charAt(0);
        int cout = 1;
        for(int i = 1; i< input.length();i++) {
            char comparable = input.charAt(i);
            if (tmp == input.charAt(i)) {
                cout++;
            }else {
                if (cout > 1) {
                    sb.append(tmp).append(cout);
                    cout = 1;
                }else {
                    sb.append(tmp);
                }
                tmp = comparable;
            }
        }
        sb.append(tmp);
        if (cout > 1) {
            sb.append(cout);
        }
        return sb.toString();
    }
}
