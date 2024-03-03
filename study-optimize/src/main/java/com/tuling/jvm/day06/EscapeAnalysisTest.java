package com.tuling.jvm.day06;

public class EscapeAnalysisTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            allocate();
        }
        System.out.println("运行耗时："+(System.currentTimeMillis()-start));
        Thread.sleep(6000000);
    }

    static void allocate(){
        MyObject myObject = new MyObject(2024,2024.6);
    }

    static class MyObject {
        int a;
        double b;

        MyObject(int a,double b){
            this.a = a;
            this.b = b;
        }
    }
}
