package com.hs.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.hs.config.RedissonLock;
import com.hs.entity.Test;
import com.hs.mapper.TestMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/28/9:30
 * @Description
 */
@Service
public class TestServiceImpl implements TestService, ApplicationRunner {

    @Resource
    private TestMapper testMapper;

    private BloomFilter<Integer> bf;

//    @Resource
//    private BloomFilter<Integer> bf;

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

    @Override
    public Integer update2(String id) {
        return testMapper.update2(id);
    }

    public List<Test> selectAll(String id){
         return testMapper.selectAll(id);
    }

    public Integer result(String id){
        return testMapper.result(id);
    }

    @Override
    public List<Integer> findAll(){
        return testMapper.findAll();
    }

    @Override
    @RedissonLock(lockIndex = 0)
    public Integer update3(int id){
        int s,v;
        testMapper.select2(id);
        Test test = new Test();
        List<Test> stock = testMapper.select2(id);
        for(int i=0;i<stock.size();i++){
            test=stock.get(i);
        }
        s=test.getStock();
        v=test.getVersion();
        if (s<=0){
            System.out.println("库存不足");
        } else if (v == 0){
            testMapper.update3(id);
            System.out.println("库存还有"+(s-1)+"个");
            testMapper.result3(id);
        }else {
            System.out.println("进程被占用");
        }
        return (s-1);
    }

    @Override
    public String insert(Test test) {
        testMapper.insert(test);
        String s = test.getId();
        int x = Integer.parseInt(s);
        System.out.println("这是一个sout方法"+x+""+s);
        bf.put(x);
        return s;
    }

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
