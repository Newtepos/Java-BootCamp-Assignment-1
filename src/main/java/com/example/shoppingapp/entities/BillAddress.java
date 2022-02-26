package com.example.shoppingapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String province;
    public String district;
    private int zipCode;

    public BillAddress() {
    }

    public BillAddress(String province, String district, int zipCode) {
        this.province = province;
        this.district = district;
        this.zipCode = zipCode;
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
}
