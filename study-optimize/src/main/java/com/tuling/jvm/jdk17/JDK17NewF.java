package com.tuling.jvm.jdk17;

import java.util.Arrays;

public class JDK17NewF {

    private static String sql = """
            SELECT T.* FROM SYS_USER T WHERE \
            T.USERID =\s'123123123'\s\
            AND T.USERCODE = '\s'
            """;

    private static void swithTest(String subject){
        switch (subject) {
            case "java", "php","C++" -> System.out.println(subject + "是开发语言");
            case "英语", "数学", "劳动" -> System.out.println(subject + "是学习学习科目");
            default -> System.out.println("其他科目");
        }
    }

    private static void instanceofTest(Object message){
        if (message instanceof String s && s.length() > 0) {
            System.out.println(message + "是字符串");
        } else if(message instanceof Integer i && i > 0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(sql);
        swithTest("杨");
        instanceofTest("杨晓宇");
        var array = new int[]{1,2,3,4,55,6,7,8};
        var sum = Arrays.stream(array).sum();
        System.out.println("数组的和为：" + sum);
    }
}
