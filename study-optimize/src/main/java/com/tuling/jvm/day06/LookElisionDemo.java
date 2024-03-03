package com.tuling.jvm.day06;

public class LookElisionDemo {

    public static String BufferString(String s1,String s2){
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

    public static String BuilderString(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            BufferString("aaaaa","bbbbbb");
        }
        System.out.println("StringBuffer耗时："+(System.currentTimeMillis()-startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            BuilderString("aaaaa","bbbbbb");
        }
        System.out.println("StringBuilder耗时："+(System.currentTimeMillis()-startTime2));
    }
}
