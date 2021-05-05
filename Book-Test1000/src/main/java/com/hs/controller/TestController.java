package com.hs.controller;

import com.hs.config.RedissonLock;
import com.hs.entity.Test;
//import com.hs.service.BloomFilterService;
import com.hs.service.TestService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private RedissonClient redissonClient;

//    @Resource
//    private BloomFilterService bloomFilterService;


    @GetMapping("/TestSelect")
    public List<Test> selectById(String id, Integer stock) {
        return testService.selectById(id, stock);
    }

    @Transactional(rollbackFor = Exception.class)
    @RedissonLock(lockIndex = 0)
    @GetMapping("/TestUpdate")
    public void update(String id) {
        int stock = testService.select(id);
        if (stock > 0) {
            testService.update(id);
            System.out.println("库存还有:" + (stock - 1) + "个");
        } else {
            System.out.println("库存不足");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @RedissonLock(lockIndex = 0)
    @GetMapping("/TestUpdate2")
    public void update2(String id) {
        int s,v;
        Test test = new Test();
        while (true) {
//            testService.selectAll(id);
            List<Test> stock = testService.selectAll(id);
            for (int i=0;i<stock.size();i++){
                test=stock.get(i);
            }
            s=test.getStock();
            v=test.getVersion();
            if (s <= 0) {
                System.out.println("库存不足");
            } else if(v == 0){
                testService.update2(id);
                testService.selectAll(id);
                System.out.println("库存还有:" + (s - 1) + "个");
                testService.result(id);
            }else {
                System.out.println("进程被占用 等待解锁");
            }
            return;
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/Gong")
    public Integer Gong(String id){
        Random  r = new Random(100);
        RLock Lock = redissonClient.getFairLock("anyLock");
        Lock.lock(r.nextLong(), TimeUnit.SECONDS);
        System.out.println("添加锁");
        System.out.println("过期时间"+r+"秒");
        testService.update(id);
        Lock.unlock();
        System.out.println("释放锁");
        return 0;
    }
    @RequestMapping("/bloom")
    public boolean ifUser(int id){
        return testService.userIdExists(id);
    }

    @RequestMapping("/long")
    @Transactional(rollbackFor = Exception.class)
    public Object testB(int id){
       boolean x = testService.userIdExists(id);
       if (x == true){
          return testService.update3(id);
       } else {
           return "消费失败 该商品不存在";
       }
    }

    @GetMapping("/insert")
    public void insert(Test test){
        testService.insert(test);
    }
}

