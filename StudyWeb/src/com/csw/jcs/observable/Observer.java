package com.csw.jcs.observable;

/**
 * dingyue
 */
public abstract class Observer {

    protected Subject subject;

    abstract void updateAge(int age);

}
