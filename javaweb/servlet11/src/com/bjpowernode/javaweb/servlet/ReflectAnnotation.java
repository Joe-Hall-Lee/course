package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        // 使用反射机制将类上面的注解进行解析。
        // 获取类 Class 对象
        Class<?> welcomeServletClass = Class.forName("com.bjpowernode.javaweb.servlet.WelcomeServlet");

        // 获取这个类上面的注解对象
        // 先判断这个类上面有没有这个注解对象，如果有这个注解对象，就获取该注解对象。
        // boolean annotationPresent = welcomeServletClass.isAnnotationPresent(WebServlet.class);
        // System.out.println(annotationPresent);

        if (welcomeServletClass.isAnnotationPresent(WebServlet.class)) {
            // 获取这个类上的注解对象
            WebServlet webServletAnnovation = welcomeServletClass.getAnnotation(WebServlet.class);
            // 获取注解的 value 属性值
            String[] value = webServletAnnovation.value();
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        }
    }
}
