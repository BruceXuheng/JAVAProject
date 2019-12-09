package com.csw.jcs.observable;


import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者模式
 */
public class Subject {

    private List<Observer> mList = new ArrayList<>();

    private int age;



    public void setAge(int age){
        this.age = age;
        updateAll();
    }

    public void attchObserver(Observer observer) {
        mList.add(observer);
    }

    private void updateAll() {
        for (Observer observer : mList) {
            observer.updateAge(age);
        }
    }


}
