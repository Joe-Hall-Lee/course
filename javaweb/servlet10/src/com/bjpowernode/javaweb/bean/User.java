package com.bjpowernode.javaweb.bean;

import java.io.Serializable;
import java.util.Objects;

/*
* 1. 一个普通的 javabean
* 2. 什么是 javabean？
*  java 是咖啡
*  bean 是豆子。
*  javabean: 咖啡豆。
*  咖啡是由咖啡豆研磨而成，寓意是 Java 程序是由一个一个的 Javabean 组成的。
* 3. 一个 JavaBean 一般是由规范的：
*      有无参数的构造方法
*      属性私有化
*      对外提供 setter 和 getter 方法
*      重写 toString()
*      重写 hashcode + equals
*      实现 java.io.Serializable 接口。
* */
public class User implements Serializable {
    private String id;
    private String name;

    public User() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
