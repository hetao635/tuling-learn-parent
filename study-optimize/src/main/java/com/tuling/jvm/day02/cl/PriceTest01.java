package com.tuling.jvm.day02.cl;

class Apple {
    /*static Apple apple = new Apple(10);
    static double price = 20.00;*/

/*    static Apple apple = new Apple(10);
    final static double price = 20.00;*/

    static double price = 20;

    static Apple apple = new Apple(10);
    double totalpay;

    public Apple (double discount) {
        System.out.println("===="+price);
        totalpay = price - discount;
    }
}

public class PriceTest01 {
    public static void main(String[] args) {
        System.out.println(Apple.apple.totalpay);
    }
}
