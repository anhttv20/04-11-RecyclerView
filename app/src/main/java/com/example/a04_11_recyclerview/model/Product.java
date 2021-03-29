package com.example.a04_11_recyclerview.model;

public class Product {
    private int resouceImg;
    private String name;
    private double price;
    private String describe;

    public Product() {
    }

    public Product(int resouceImg, String name,
                   double price, String describe) {
        this.resouceImg = resouceImg;
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public int getResouceImg() {
        return resouceImg;
    }

    public void setResouceImg(int resouceImg) {
        this.resouceImg = resouceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String toString(){
        return name+" - "+price+" - "+describe;
    }
}
