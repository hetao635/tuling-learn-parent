package com.tuling.jvm.day02.oa;

import org.yaml.snakeyaml.DumperOptions;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class OADemo2 {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        Double salary = 15000.00;
        Double money = 0.00;


        URL path = new URL("file:D:/ideaIU-2023.3.3/IntelliJ IDEA 2023.3.3/workspaces/tulingstudy/out/artifacts/salaryCaler_jar/salaryCaler.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{path});

        //模拟不停机状态
        while (true) {
            try {
                money = calSalary(salary, urlClassLoader);
                System.out.println("实际到手Money:" + money);
            }catch(Exception e) {
                System.out.println("加载出现异常 ："+e.getMessage());
            }
            Thread.sleep(5000);
        }
    }

    private static double calSalary(double salery, URLClassLoader urlClassLoader) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = urlClassLoader.loadClass("com.tuling.jvm.day02.SalaryCaler");
        if (null != aClass) {
            Object o = aClass.newInstance();
            return (Double)aClass.getMethod("cal", Double.class).invoke(o, salery);
        }
        return -1;
    }
}
