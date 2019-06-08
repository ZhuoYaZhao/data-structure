package main.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TimerUtil<T> {

    public void getTime(Object... args) {
        // 获取当前类型名字
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("current className(expected): " + className);
        try {
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                // 判断该方法是否包含Timer注解
                if (m.isAnnotationPresent(RunTime.class)) {
                    m.setAccessible(true);
                    long start = System.currentTimeMillis();
                    // 执行该方法
                    Object result = m.invoke(obj,args);
                    long end = System.currentTimeMillis();

                    Type[] genericParameterTypes = m.getGenericParameterTypes();
                    String types = "";
                    for (Type genericParameterType : genericParameterTypes) {
                        types += genericParameterType.getTypeName();
                    }
                    System.out.println(m.getName() + "(" + types + ") time consumed: " + String.valueOf(end - start) + "ms");
                    if (result != null) {

                        System.out.println(result);
                    }

                    System.out.println("======================");

                }
            }
        } catch (IllegalAccessException | ClassNotFoundException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}