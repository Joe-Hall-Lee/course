package com.powernode.bank.mvc;

/*
 * 账户实体类：封装账户信息的。
 * 一般是一张表一个。
 * pojo 对象。
 * 有的人也会把这种专门封装数据的对象，称为 bean 对象。（javabean: 咖啡豆）
 * 有的人也会把这种专门封装数据的对象，称为领域模型对象。domain 对象。
 * 不同的程序员有不同的习惯。
 *
 * pojo、bean、domain...
 * */
public class Account { // 这种普通简单的对象被称为 pojo 对象。
    /*
     * 主键
     * */
    // 一般这种属性不建议设计为基本数据类型，建议使用包装类，防止 null 带来的问题。
    // private long id;
    private Long id;

    /*
     * 账号
     * */
    private String actno;

    /*
     * 余额
     * */
    // private double balance;
    private Double balance;

    public Account() {
    }

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
