package com.hs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:26
 * @Description
 */

@Data
public class CustomerAccount implements Serializable {

    private Long customerId;

    private Integer total;

    private Integer customerShopNum;

    private Integer customerState;

    private Integer used;

    private Integer residue;
}
