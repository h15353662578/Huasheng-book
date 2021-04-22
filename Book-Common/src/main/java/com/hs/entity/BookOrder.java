package com.hs.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:26
 * @Description
 */
@Data
public class BookOrder implements Serializable {

    private Long orderId ;

    private Long bookId;

    private Long customerId;

    private Integer count;

    private BigDecimal money;

    private Integer status;
}
