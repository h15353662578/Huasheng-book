package com.hs.order.mapper;

import com.hs.entity.BookOrder;
import com.hs.entity.CustomerOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Huasheng
 * @Date 2021/04/19/11:49
 * @Description
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into book_order(customer_id,book_id,count,money,status) values (#{customerId},#{bookId},#{count},#{money},0)")
    int create(BookOrder bookOrder);

    @Update("update book_order set status =1 where customer_id =#{customerId} and status=#{status}")
    int update(@Param("customerId") Long customerId, @Param("status") Integer status);

}
