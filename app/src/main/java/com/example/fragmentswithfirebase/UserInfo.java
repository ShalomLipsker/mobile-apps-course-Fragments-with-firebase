package com.example.fragmentswithfirebase;

public class UserInfo {
    private String email;
    private String id;
    private String phone;
    private String address;


    public UserInfo() {
    }

    public UserInfo(String email, String id, String phone, String address) {
        this.email = email;
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "email: '" + email + '\'' +
                "\nid: '" + id + '\'' +
                "\nphone: '" + phone + '\'' +
                "\naddress: '" + address + '\'';
    }
}
