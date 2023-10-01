package com.example.springhomework.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private List<Bill> billList;

    public Account(String name, String email, List<Bill> billList){
        this.name = name;
        this.email = email;
        this.billList = billList;
    }


    public Account() {
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
