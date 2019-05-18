package com.luluya.designPatterns.controller;

import java.util.ArrayList;

/**
 * 原型模式
 * @author jairy
 * @date 2019/5/18
 */
public class Clone {
}
/*
 * 书本类型，扮演的是ConcretePrototype角色，而Cloneable扮演Prototype角色
 */
class Book implements Cloneable {

    private String title;// 标题
    private ArrayList<String> image = new ArrayList<String>();// 图片名列表

    public Book() {
        super();
    }

    /**
     * 重写拷贝方法
     */
    @Override
    protected Book clone() {
        try {
            Book book = (Book) super.clone();//浅拷贝，默认是浅拷贝
            book.image=(ArrayList<String>)this.image.clone();//深复制
            return book;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void addImage(String img) {
        this.image.add(img);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 打印内容
     */
    public void showBook() {
        System.out.println("----------------------Start----------------------");

        System.out.println("title：" + title);
        for (String img : image) {
            System.out.println("image name:" + img);
        }

        System.out.println("----------------------End----------------------");
    }
}

class Client02 {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("书1");
        book1.addImage("图1");
        book1.showBook();
        //以原型方式拷貝一份
        Book book2 = book1.clone();
        book2.showBook();
        book2.setTitle("书2");
        book2.addImage("圖2");
        book2.showBook();
        //再次还原打印书本
        book1.showBook();
    }
}