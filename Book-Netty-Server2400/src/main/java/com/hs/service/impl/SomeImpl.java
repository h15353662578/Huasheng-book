package com.hs.service.impl;

import com.hs.service.Some;

/**
 * @author Huasheng
 * @Date 2021/05/21/11:12
 * @Description
 */
public class SomeImpl implements Some  {
    @Override
    public String hello(String name) {
        return "Huasheng"+name;
    }
}
