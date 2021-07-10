package com.project.bean;

public class Order {
    private int id;
    private String buyname;
    private String  salername;
    private String name;
    private int count;
    private double prise;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyname() {
        return buyname;
    }

    public void setBuyname(String buyname) {
        this.buyname = buyname;
    }

    public String getSalername() {
        return salername;
    }

    public void setSalername(String salername) {
        this.salername = salername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int  getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyname='" + buyname + '\'' +
                ", salername='" + salername + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", prise=" + prise +
                '}';
    }
}
