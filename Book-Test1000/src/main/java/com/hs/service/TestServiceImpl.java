package com.hs.service;

import com.hs.entity.Test;
import com.hs.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/28/9:30
 * @Description
 */
@Service
public class TestServiceImpl implements TestService{

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> selectById(String id,Integer stock){
        return testMapper.selectById(id,stock);
    }

    @Override
    public Integer   update(String id) {
        return testMapper.update(id);
    }

    @Override
    public int select(String id){
        return testMapper.Select(id);
    }
}
