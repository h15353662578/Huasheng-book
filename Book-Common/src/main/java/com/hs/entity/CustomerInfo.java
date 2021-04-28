package com.hs.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private String customerName;
}
