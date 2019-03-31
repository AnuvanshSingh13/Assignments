package com.example.databindingandviewholder;

public class DataModal {
private String name;
private String email;
private int phoneNo;
 public DataModal(String name,String email,int phoneNo){
     this.name=name;
     this.email=email;
     this.phoneNo=phoneNo;
 }

    public DataModal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
}
