package com.csw.jcs.bean;

public class UserBean {

    private int id;
    private String username;
    private String userpwd;
    private String did;

    public int getId() {
        return id;
    }

    public UserBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return username;
    }

    public UserBean setUserName(String username) {
        this.username = username;
        return this;
    }


    public String getUserpwd() {
        return userpwd;
    }

    public UserBean setUserpwd(String userpwd) {
        this.userpwd = userpwd;
        return this;
    }

    public String getDid() {
        return did;
    }

    public UserBean setDid(String did) {
        this.did = did;
        return this;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", did='" + did + '\'' +
                '}';
    }
}
