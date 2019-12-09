package com.csw.jcs.observable;

public class Rabbit extends Observer{


    public Rabbit(Subject subject) {
        this.subject = subject;
        subject.attchObserver(this);
    }

    @Override
    void updateAge(int age) {
        System.out.println(age+"周年店庆欢迎大家前来选购!!!");
    }

    public static void main(String[] args) {
        //1.创建被观察者
        Subject subject = new Subject();

        //2.创建观察者 并 订阅被观察者
        new Rabbit(subject);

        //3.模拟数据变更
        subject.setAge(10);

    }

}
