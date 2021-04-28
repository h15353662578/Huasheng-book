package com.hs.controller;

import com.hs.config.DistributedRedisLock;
import com.hs.config.RedissonLock;
import com.hs.entity.Test;
import com.hs.service.TestService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/28/9:35
 * @Description
 */
@RestController
@RequestMapping("/Test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/TestSelect")
    public List<Test> selectById(String id,Integer stock){
        return testService.selectById(id, stock);
    }

    @Transactional(rollbackFor = Exception.class)
    @RedissonLock(lockIndex = 0)
    @GetMapping("/TestUpdate")
    public Integer update(String id){
        int stock = testService.select(id);
        System.out.println("-----库存-----"+stock);
        if (stock >0){
            return testService.update(id);
        }else {
            return null;
        }
    }
//    @GetMapping("TestUpdate")
//    public Integer update(String id){
//        int stock = testService.select(id);
//        System.out.println("-------------|"+stock);
//        if (stock >0){
//            String key = "test1";
//            DistributedRedisLock.acquire(key);
//            int a=testService.update(id);
//            DistributedRedisLock.release(key);
//            return a;
//        }else {
//            return null;
//        }
//    }

    @GetMapping("TestS")
    public int select(String id){
        return testService.select(id);
    }
}
