package com.design.pattern;

/**
 * @author monkjavaer
 * @date 2022/3/12
 */
class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     *
     * 输出结果
     * 例如：
     *  "cm"  true
     *  "ccm"  false
     *  "cmccmcmcmcmmccmmccccmccmcmccmmcmcccmmmmmmmm"  false
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean magicString(String s) {
        // write code here
        if (s == null || "".equals(s)) {
            return true;
        }
        String flag = "cm";
        int index = s.indexOf(flag);
        if (index == -1 || s.length() == 1) {
            return false;
        }
        String pre = s.substring(0, index);
        String next = s.substring(index + flag.length());
        String newString = pre + next;
        if ("".equals(newString) || newString.contains(flag)) {
             return magicString(newString);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(magicString("c"));
    }
}
