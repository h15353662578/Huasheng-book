package com.hs.customer.service;

import com.hs.entity.CustomerAccount;
import org.springframework.cloud.openfeign.FeignClient;

import java.math.BigDecimal;

/**
 * @author Huasheng
 * @Date 2021/05/21/9:19
 * @Description
 */

@FeignClient("customer-account-service")
public interface CustomerAccountService {

    public void addCustomerAccount();

    public CustomerAccount findAll();

    /***
     *
     * @param customerId
     * @param money
     */
    Boolean decrease(Long customerId, BigDecimal money);
}
