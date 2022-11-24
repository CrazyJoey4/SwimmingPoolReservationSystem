package com.example.swimmingpool_rs;

public class Profile {
    private int User_ID;
    private String Username;
    private String User_fullname;
    private String User_dob;
    private String User_gender;
    private String User_email;
    private String User_contact;

    private String User_pwd;

    public Profile() {
        this.User_ID = 0;
        this.Username = "";
        this.User_fullname = "";
        this.User_dob = null;
        this.User_gender = null;
        this.User_email = null;
        this.User_contact = null;
        this.User_pwd = null;
    }

    public Profile(int announcementId, String title, String content, String datetime) {
        this.User_ID = User_ID;
        this.Username = Username;
        this.User_fullname = User_fullname;
        this.User_dob = User_dob;
        this.User_gender = User_gender;
        this.User_email = User_email;
        this.User_contact = User_contact;
        this.User_pwd = User_contact;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUser_fullname() {
        return User_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        User_fullname = user_fullname;
    }

    public String getUser_dob() {
        return User_dob;
    }

    public void setUser_dob(String user_dob) {
        User_dob = user_dob;
    }

    public String getUser_gender() {
        return User_gender;
    }

    public void setUser_gender(String user_gender) {
        User_gender = user_gender;
    }

    public String getUser_email() {
        return User_email;
    }

    public void setUser_email(String user_email) {
        User_email = user_email;
    }

    public String getUser_contact() {
        return User_contact;
    }

    public void setUser_contact(String user_contact) {
        User_contact = user_contact;
    }

    public String getUser_pwd() {
        return User_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        User_pwd = user_pwd;
    }

}
