package com.hs.service;

import com.hs.entity.Test;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/28/9:30
 * @Description
 */
public interface TestService {

    public List<Test> selectById(String id,Integer stock);

    public Integer update(String id);

    public int select(String id);

    public Integer update2(String id);

    public List<Test> selectAll(String id);

    public Integer result(String id);

    public List<Integer> findAll();
}
