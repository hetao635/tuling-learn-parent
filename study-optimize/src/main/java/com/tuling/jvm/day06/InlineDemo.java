package com.tuling.jvm.day06;

public class InlineDemo {

    public static void foo(Object obj){
        if(obj !=null){
            System.out.println("do something");
        }
    }
    //方法内联之后会继续进行无用代码消除
    public static void testInline(){
        Object obj= null;
        foo(obj);
    }
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            testInline();
        }
        System.out.println(">>>>>>>>"+(System.currentTimeMillis()-l));
    }
}
