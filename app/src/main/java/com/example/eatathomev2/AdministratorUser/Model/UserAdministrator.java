package com.example.eatathomev2.AdministratorUser.Model;

public class UserAdministrator {
    private String name;
    private String password;
    private String phone;
    private String isstaff;
    private String isadmin;

    public UserAdministrator() {
    }

    public UserAdministrator(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.isstaff = "false";
        this.isadmin = "false";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsstaff() {
        return isstaff;
    }

    public void setIsstaff(String isstaff) {
        this.isstaff = isstaff;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }
}
