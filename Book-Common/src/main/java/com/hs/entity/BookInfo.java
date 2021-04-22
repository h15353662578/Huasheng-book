package com.hs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:25
 * @Description
 */

@Data
public class BookInfo implements Serializable {

    private Integer bookId;

    private String bookName;

    private Integer bookPrice;

    private String bookType;

    private Integer total;

    private Integer bookState;

    private Integer used;

    private Integer residue;

    private BookOrder bookOrder;
}
