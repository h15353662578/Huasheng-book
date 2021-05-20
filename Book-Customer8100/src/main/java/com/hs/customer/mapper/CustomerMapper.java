package com.hs.customer.mapper;

import com.hs.entity.Customer;
import com.hs.entity.CustomerInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/14/16:59
 * @Description
 */
@Mapper
public interface CustomerMapper {


    @Select("select customer_id,customer_name,customer_username,customer_password,customer_ROLE,customer_header from customer")
    public List<Customer> findAllCustomer();

    @Insert("insert into customer (customer_name,customer_username,customer_password) values (#{customerName},#{customerUserName},#{customerPassword})")
    public void addCustomer(Customer customer);
}
