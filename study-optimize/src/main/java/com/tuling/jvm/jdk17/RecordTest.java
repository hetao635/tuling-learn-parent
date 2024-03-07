package com.tuling.jvm.jdk17;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RecordTest {

    @Test
    public void print(){
        Point point = new Point(10, 20);
        for (Method method : point.getClass().getMethods()) {
            System.out.println(method);
        }
        System.out.println("=====================================");
        for (Field field : point.getClass().getDeclaredFields()) {
            System.out.println(field);
        }
        System.out.println(point.x() +"\t" + point.y());
    }


}
