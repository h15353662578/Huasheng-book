package com.hs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/04/12/17:29
 * @Description
 */

public class Customer implements Serializable {

    private Long customerId;

    private String customerName;

    private String customerUserName;

    private String customerPassword;

    private String customerRole;

    private String customerHeader;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public String getCustomerHeader() {
        return customerHeader;
    }

    public void setCustomerHeader(String customerHeader) {
        this.customerHeader = customerHeader;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerUserName='" + customerUserName + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerRole='" + customerRole + '\'' +
                ", customerHeader='" + customerHeader + '\'' +
                '}';
    }
}
