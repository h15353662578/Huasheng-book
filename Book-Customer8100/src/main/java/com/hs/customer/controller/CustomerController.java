package com.hs.customer.controller;

import com.hs.config.CommonResult;
import com.hs.customer.service.CustomerService;
import com.hs.entity.Customer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Huasheng
 * @Date 2021/04/14/16:58
 * @Description
 */
@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/findAll")
    public CommonResult findAllCustomer(){
        return CommonResult.success(customerService.findAllCustomer());
    }

    @GetMapping("/addCustomer")
    public void addCustomer(Customer customer){
         customerService.addCustomer(customer);
    }
}
