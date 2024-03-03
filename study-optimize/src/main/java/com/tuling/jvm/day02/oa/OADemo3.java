package com.tuling.jvm.day02.oa;

import com.tuling.jvm.day02.cl.SalaryClassLoader;

import java.lang.reflect.InvocationTargetException;

public class OADemo3 {

    public static void main(String[] args) throws InterruptedException {
        Double salary = 15000.00;
        Double money = 0.00;

        String path = "G:/IDEs/ideaIU-2023.3.3/workspaces/tulingstudy/salaryCaler/target/classes/";
        SalaryClassLoader salaryClassLoader = new SalaryClassLoader(path);

        //模拟不停机状态
        while (true) {
            try {
                money = calSalary(salary, salaryClassLoader);
                System.out.println("实际到手Money:" + money);
            }catch(Exception e) {
                System.out.println("加载出现异常 ："+e.getMessage());
            }
            Thread.sleep(5000);
        }
    }

    private static double calSalary(double salery, ClassLoader classLoader) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = classLoader.loadClass("com.tuling.jvm.day02.SalaryCaler"); //
        if (null != aClass) {
            Object o = aClass.newInstance();
            return (Double)aClass.getMethod("cal", Double.class).invoke(o, salery);
        }
        return -1;
    }
}
