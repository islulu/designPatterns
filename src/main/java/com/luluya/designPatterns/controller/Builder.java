package com.luluya.designPatterns.controller;

/**
 * 建造者模式
 * @author jairy
 * @date 2019/5/18
 */
public class Builder {
}
class Person {
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }
    public void setHead(String head) {
        this.head = head;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getFoot() {
        return foot;
    }
    public void setFoot(String foot) {
        this.foot = foot;
    }
}

/**
 * Builder（给出一个抽象接口，以规范产品对象的各个组成成分的建造。这个接口规定要实现复杂对象的哪些部分的创建，并不涉及具体的对象部件的创建）
 *
 * 规范各个组成成分的建造，不涉及具体对象的创建（制定规范
 */
interface PersonBuilder {
    void builderHead();
    void builderBody();
    void builderFoot();

    Person BuilderPersion(); //组装
}

/**
 * ConcreteBuilder（实现Builder接口，针对不同的商业逻辑，具体化复杂对象的各部分的创建。 在建造过程完成后，提供产品的实例）
 *
 * 根据不同需求 对于各部分构建对象，提供实例
 */
class ManBuilder implements PersonBuilder {
    private Person person;
    public ManBuilder() {
        person = new Person();//创建一个Person实例,用于调用set方法
    }
    @Override
    public void builderHead() {
        person.setHead("建造者头部分");
    }
    @Override
    public void builderBody() {
        person.setBody("建造者身体部分");
    }
    @Override
    public void builderFoot() {
        person.setFoot("建造者头四肢部分");
    }
    @Override
    public Person BuilderPersion() {
        return person;
    }
}

/**
 * Director（调用效率高用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建）
 *
 * 建造复杂对象，保证顺序
 */
class PersonDirector {

    public Person constructPerson(PersonBuilder pb) {
        pb.builderHead();
        pb.builderBody();
        pb.builderFoot();
        return pb.BuilderPersion();
    }

    public static void main(String[] args) {
        PersonDirector pb = new PersonDirector();
        Person person = pb.constructPerson(new ManBuilder());
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
    }
}