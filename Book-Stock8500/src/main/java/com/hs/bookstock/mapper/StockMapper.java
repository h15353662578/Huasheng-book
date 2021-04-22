package com.hs.bookstock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Huasheng
 * @Date 2021/04/19/14:16
 * @Description
 */
@Mapper
public interface StockMapper {

    @Update("update book_storage set used = used + #{count},residue = residue - #{count} where book_id = #{bookId}")
    void decrease(@Param("bookId") Long bookId, @Param("count") Integer count);
}
