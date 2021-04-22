package com.hs.customerInfo.mapper;

import com.hs.entity.BookInfo;
import com.hs.entity.BookOrder;
import com.hs.entity.CustomerInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Huasheng
 * @Date 2021/04/16/8:58
 * @Description
 */

@Mapper
public interface CustomerInfoMapper {

    @Insert("insert into customer_info (create_date) values (#{createDate})")
    public void addCustomerInfo(CustomerInfo customerInfo);

    @Select("select * from customer_info")
    public CustomerInfo findAll();

    @Select("SELECT * FROM book_info UNION ALL SELECT * FROM book_storage")
    public List<Map<BookInfo, BookOrder>> findAnd();
}
