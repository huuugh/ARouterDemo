package com.zje.data_moudle;

/**
 * Created by Hugh on 2018/7/9.
 *
 */
public class User{

    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
