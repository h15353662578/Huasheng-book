package com.hs.customerAccount.mapper;

import com.hs.entity.CustomerAccount;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:56
 * @Description
 */
@Mapper
public interface CustomerAccountMapper {

    @Insert("insert into customer_account set residue=0")
    public void addCustomerAccount();

    @Select("select * from customer_account")
    public CustomerAccount findAll();

    @Update("update customer_account set used = used + #{money}, residue = residue - #{money} where customer_id = #{customerId}")
    void decrease(@Param("customerId") Long customerId, @Param("money") BigDecimal money);


}
