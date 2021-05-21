package com.hs.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huasheng
 * @Date 2021/05/21/11:39
 * @Description
 */

@Data
public class Invocation implements Serializable {

    private String className;

    private String methodName;

    private Class<?>[] paramTypes;

    private Object[] paramValues;
}
