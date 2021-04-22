package com.hs.customer.service.impl;

import com.hs.customer.mapper.CustomerMapper;
import com.hs.customer.service.CustomerService;
import com.hs.customerAccount.service.CustomerAccountService;
import com.hs.customerInfo.service.CustomerInfoService;
import com.hs.entity.Customer;
import com.hs.entity.CustomerAccount;
import com.hs.entity.CustomerInfo;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.transaction.Propagation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/14/16:59
 * @Description
 */
@Slf4j
@Service(timeout = 10000,group = "customer-service")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Reference(group = "customer-account-service")
    CustomerAccountService customerAccountService;

    @Reference(group = "customer-info-service")
    CustomerInfoService customerInfoService;

    @Override
    public List<Customer> findAllCustomer(){
        return customerMapper.findAllCustomer();
    }

    @Override
    @GlobalTransactional(name = "customer-account-service",rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void addCustomer(@RequestBody Customer customer){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        customer.setCustomerPassword(bCryptPasswordEncoder.encode(customer.getCustomerPassword()));
        //新建用户
        log.info("------开始新建用户------");
        customerMapper.addCustomer(customer);

        log.info("------开始创建用户账户表------");
        customerAccountService.addCustomerAccount();

        log.info("------开始创建用户信息表------");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfoService.addCustomerInfo(customerInfo);

        log.info("------用户信息创建完成------");
    }

}