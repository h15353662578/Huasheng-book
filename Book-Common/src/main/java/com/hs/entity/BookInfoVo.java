package com.hs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/05/17/9:34
 * @Description
 */

@Data
public class BookInfoVo implements Serializable {

    private String name;

    private Long value;
}
