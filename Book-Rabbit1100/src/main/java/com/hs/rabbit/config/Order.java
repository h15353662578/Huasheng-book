package com.hs.rabbit.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/05/13/9:42
 * @Description
 */

@Data
public class Order implements Serializable {
    private int id;
    private String name;
    private String messageId;
}
