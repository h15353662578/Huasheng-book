package com.hs.config;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.hs.entity.Test;
import com.hs.service.TestService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.*;

/**
 * @author Huasheng
 * @Date 2021/04/29/16:20
 * @Description
 */
public class BuLongTest {

    @Resource
    private TestService testService;

    private static final int ins = 100000;     //设置十万位

    /***
     * 初始化一个类型为String的布隆过滤器 初始化大小为一万
     * 默认误判率为0.03
     * @param args
     */
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(Charsets.UTF_8), ins);

        //用于存放所有的实际存在的key 判断是否存在
        Set<String> sets = new HashSet<>(ins);

        //存放所有实际存在的key 取出使用
        List<String> lists = new ArrayList<String>(ins);

        //向三个容器初始化十万个随机且唯一的字符串
        for (int i = 0; i < ins; i++) {
            String id = UUID.randomUUID().toString();
            bloomFilter.put(id);
            sets.add(id);
            lists.add(id);
        }

        int y = 0;
        int n = 0;

        for (int i = 0; i < 10000; i++) {
            //可以被100整除的时候去一个存在的数 否则随机生成id
            //0~10000之间 可以被100整除的数有100个
            String data = i % 100 == 0 ? lists.get(i / 100) : UUID.randomUUID().toString();

            //如果数据存在则y(存在个数)自增
            if (bloomFilter.mightContain(data)) {
                if (sets.contains(data)) {
                    y++;
                    continue;
                }
                //判断不存在时n(不存在个数)自增
                n++;
            }
        }
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);//UI大小鼠位数
        float percent = (float) n / 9900;
        float bingo = (float) (9900 - n) / 9900;
        System.out.println("布隆过滤器认为存在的" + y);
        System.out.println("误认为存在的" + n);
        System.out.println("命中率" + percentFormat.format(bingo) + "误判率" + percentFormat.format(percent));
    }

}

