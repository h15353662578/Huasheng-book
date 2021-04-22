package com.hs.customerAccount.service;

import com.hs.entity.CustomerAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:55
 * @Description
 */
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
