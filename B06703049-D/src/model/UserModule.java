package model;

import java.io.Serializable;
import java.util.*;

public class UserModule implements Serializable {
    private String username;
    private Date date;
    private String title;
    private String txt;

    public UserModule() {
    }

    public UserModule(String username, Date date, String title, String txt) {
        this.username = username;
        this.date = date;
        this.title = title;
        this.txt = txt;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public String getTxt() {
        return txt;
    }

    public String getTitle() {
        return title;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

}
