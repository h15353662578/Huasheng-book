package com.hs.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:26
 * @Description
 */
@Data
public class CustomerInfo implements Serializable {

    private Long customerId;

    private Integer sex;

    private Integer age;

    private String phone;

    private String address;

    private Date createDate;

    private String customerName;
}
