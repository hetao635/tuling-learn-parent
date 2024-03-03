package com.atguigu.algorithm.basic;

public class StringDemo {

    private static String str1 = "尚硅谷你好鬼谷上尚硅谷尚硅谷你硅谷硅谷鬼谷鬼谷你好";

    private static String str2 = "硅谷鬼谷鬼谷你好";

    public static void main(String[] args) {
        int result = -1;
        for (int index = 0; index <= str1.length() - str2.length(); index++) {
            if (str1.substring(index, index + str2.length()).equals(str2)) {
                result = index;
                break;
            }
        }
        System.out.println(result);
    }
}
