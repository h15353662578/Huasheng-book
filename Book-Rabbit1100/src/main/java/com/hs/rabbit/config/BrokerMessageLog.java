package com.hs.rabbit.config;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Huasheng
 * @Date 2021/05/13/9:43
 * @Description
 */
@Data
public class BrokerMessageLog implements Serializable {

    private String messageId;

    private String message;

    private Integer tryCount;

    private String status;

    private Date nextRetry;

    private Date createTime;

    private Date updateTime;

}
