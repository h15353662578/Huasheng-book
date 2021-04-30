package com.hs.service;

/**
 * @author Huasheng
 * @Date 2021/04/29/17:27
 * @Description
 */

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.hs.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 启动时初始化布隆过滤器
 */
/**
 * 启动时初始化布隆过滤器
 */
@Service
public class BloomFilterService implements ApplicationRunner {

    @Autowired
    private TestMapper testMapper;

    private BloomFilter<Integer> bf;

    /**
     * 启动时将数据库中用户id加载到布隆过滤器中来
     * @param args
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(ApplicationArguments args) throws Exception {
        List<Integer> userIdList = testMapper.findAll();
        if (CollectionUtils.isEmpty(userIdList)) return;
        //创建布隆过滤器 误判率默认为3%
        bf = BloomFilter.create(Funnels.integerFunnel(),userIdList.size());
        for (Integer id : userIdList) {
            bf.put(id);
        }
        System.out.println("布隆过滤器"+userIdList);
    }

    /***
     * 判断id可能存在于布隆过滤器里面
     * @param id
     * @return
     */
    public boolean userIdExists(int id){
        return bf.mightContain(id);
    }
}
