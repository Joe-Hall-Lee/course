package com.bjpowernode.template2;

/*
 * Teacher 和 Student 都是 Person
 * 1. Person 就是模板方法设计模式当中的模板类。
 * 2. day() 方法就是模板方法设计模式当中的模板方法。
 * */
public abstract class Person { // 模板类通常是抽象类。
    // 模板方法
    // 添加了 final 之后，这个方法无法被覆盖，这样核心的算法也可以得到保护。
    // 模板方法。
    // 模板方法定义核心的算法骨架，具体的实现步骤可以延迟到子类当中去实现。
    // 核心方法一方面是得到了保护，不能被改变。另外一方面就是算法得到了重复使用。
    // 另外代码也得到了复用，因为算法中某些步骤的代码是固定的。这些固定的代码不会随着子类的变化而变换，这一部分代码可以写到模板类当中。
    public final void day() {
        // 第一步
        qiChuang();
        // 第二步
        xiShu();
        // 第三步
        chiZaoCan();
        // 第四步
        doSome();
        // 第五步
        chiWanFan();
        // 第六步
        shuiJiao();
    }

    // 其中的某些步骤，不会随着子类的变化而变化，这些代码可以写到父类中，得到代码复用。
    public void qiChuang() {
        System.out.println("起床");
    }

    public void xiShu() {
        System.out.println("洗漱");
    }

    // 这一步是要做，但是具体这一步怎么做，子类说了算。
    public void chiZaoCan() {
        System.out.println("吃早餐");
    }

    public abstract void doSome();

    public void chiWanFan() {
        System.out.println("吃晚饭");
    }

    public void shuiJiao() {
        System.out.println("睡觉");
    }
}
