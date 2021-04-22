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
public class CustomerOrder implements Serializable {

    private Integer id;

    private Long customerId;

    private Integer orderId;

    private String bookName;

    private Integer bookPrice;

    private Integer orderPrice;

    private Date orderTime;

    private Integer orderState;
}
