package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class User {

    String id;
    String username;
    String pwd;
    static int lastId;

    public User() {
        this.id = RandomUtils.getId();
    }

    public User(String username, String pwd) {
        this();
        this.setPwd(pwd);
        this.setUsername(username);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User [id = "+id+", username = " + username + ", pwd = " + pwd +"]";
    }

}