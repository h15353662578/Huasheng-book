package com.hs.customer.service;

import com.hs.entity.Customer;
import com.hs.entity.CustomerInfo;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/14/16:58
 * @Description
 */
public interface CustomerService {

    public List<Customer> findAllCustomer();

    public void addCustomer(Customer customer);

}
