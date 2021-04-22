package com.hs.customerAccount.service.impl;

import com.hs.customerAccount.mapper.CustomerAccountMapper;
import com.hs.customerAccount.service.CustomerAccountService;
import com.hs.entity.CustomerAccount;
import io.seata.spring.annotation.GlobalTransactional;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:56
 * @Description
 */
@Slf4j
@Service(timeout = 10000,group = "customer-account-service")
public class CustomerAccountServiceImpl implements CustomerAccountService{

    @Resource
    private CustomerAccountMapper customerAccountMapper;

    @Override
    @GlobalTransactional(name = "customer-service",rollbackFor = Exception.class)
    public void addCustomerAccount(){
          customerAccountMapper.addCustomerAccount();
    }

    @Override
    public CustomerAccount findAll(){
        return customerAccountMapper.findAll();
    }

    @Override
    @GlobalTransactional(name = "customer-account-service", rollbackFor = Exception.class)
    public Boolean decrease(Long customerId, BigDecimal money) {
        log.info("---> AccountService中扣减账户余额");
        customerAccountMapper.decrease(customerId, money);
        log.info("---> AccountService中扣减账户余额完成");
        return true;
    }
}
