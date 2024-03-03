package com.tuling.jvm.day06;

public class JITDemo {

    private int add(int x){
        return x++;
    }

    public static void main(String[] args) {
        int number = 0;
        JITDemo jitDemo = new JITDemo();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            jitDemo.add(number);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行使用的毫秒数为:" + (end - start));
    }
}
