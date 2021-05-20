package com.hs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:26
 * @Description
 */


public class CustomerAccount implements Serializable {

    private Long customerId;

    private Integer total;

    private Integer customerShopNum;

    private Integer customerState;

    private Integer used;

    private Integer residue;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCustomerShopNum() {
        return customerShopNum;
    }

    public void setCustomerShopNum(Integer customerShopNum) {
        this.customerShopNum = customerShopNum;
    }

    public Integer getCustomerState() {
        return customerState;
    }

    public void setCustomerState(Integer customerState) {
        this.customerState = customerState;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }
}
