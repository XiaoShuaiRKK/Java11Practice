package com.Comparable.POJO;

public class Account implements Comparable<Account> {
    private String name;
    private int age;
    private int money;

    public Account(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("Account[Name : %s,Age : %d,Money : %d]",getName(),getAge(),getMoney());
    }

    @Override
    public int compareTo(Account account) {
        System.out.println(this.name + " 和 " + account.name + "比较");
        int tmp = this.getAge() - account.getAge();
        if(tmp == 0)
            return this.getMoney() - account.getMoney();
        return tmp;
    }
}
