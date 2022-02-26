package com.example.shoppingapp.entities;

import javax.persistence.*;

@Entity
public class BillAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String province;
    public String district;
    private int zipCode;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    public BillAddress() {
    }

    public BillAddress(String province, String district, int zipCode, User user) {
        this.province = province;
        this.district = district;
        this.zipCode = zipCode;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
