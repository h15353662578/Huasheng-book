package com.hs.customerAccount.controller;

import com.hs.config.CommonResult;
import com.hs.customerAccount.service.CustomerAccountService;
import com.hs.entity.CustomerAccount;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:56
 * @Description
 */

@RestController
@RequestMapping("/CustomerAccount")
public class CustomerAccountController {

    @Resource
    private CustomerAccountService customerAccountService;

    @GetMapping("/addCustomerAccount")
    public void addCustomerAccount(){
         customerAccountService.addCustomerAccount();
    }

    @GetMapping("/findAll")
    public CommonResult findAll(){
        return CommonResult.success(customerAccountService.findAll());
    }

    @GetMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("customerId") Long customerId, @RequestParam("money") BigDecimal money) {
        Boolean a=customerAccountService.decrease(customerId, money);
        if (a){
            return CommonResult.success(200);
        }else {
            return CommonResult.error();
        }
    }
}
