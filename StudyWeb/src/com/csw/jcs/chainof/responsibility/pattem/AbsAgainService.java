package com.csw.jcs.chainof.responsibility.pattem;

public abstract class AbsAgainService {

    private static int SUCCESS = 0;
    private static int NET_FAIL = -1;
    private static int SEND_FAIL = -2;


    abstract protected void sendBack(String message);

}
