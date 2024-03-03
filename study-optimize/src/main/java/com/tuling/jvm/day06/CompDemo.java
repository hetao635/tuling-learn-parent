package com.tuling.jvm.day06;

public class CompDemo {

    private int add1(int x1, int x2) {
        return x1 + x2;
    }

    private int add2(int x1 ,int x2, int x3, int x4) {
        return add1(x1,x2) + add1(x3, x4);
    }

    public static void main(String[] args) {
        CompDemo compDemo = new CompDemo();
        for (int i = 0; i < 100; i++) {
            compDemo.add2(1,2,3,4);
        }
    }
}
