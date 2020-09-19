package com.example.astc.bean;

/**
 * 金币对象类
 * 2020-02-03
 *
 * @author
 */
public class GoldBean {
    private int number;
    private String name;

    public GoldBean(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
