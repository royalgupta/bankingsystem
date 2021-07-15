package com.example.basicbankingsystem.model;

public class model {
    String name,contact,email,accno,amt;

    public model() {
    }

  /* public model(String name, String contact,String amt) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.accno = accno;
        this.amt = amt;
    }*/

    public model(String name, String contact, String email, String accno) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.accno = accno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String amt) {
        this.accno = accno;
    }

}
