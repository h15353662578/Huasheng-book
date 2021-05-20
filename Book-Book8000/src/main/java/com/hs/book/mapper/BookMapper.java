package com.hs.book.mapper;

import com.hs.entity.BookInfo;
import com.hs.entity.BookInfoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:47
 * @Description
 */

@Mapper
public interface BookMapper {

    @Select("select book_id as name,residue as value from book_storage")
    public List<BookInfoVo> findAllBook();

    @Insert("insert into book_info(book_name,book_price,book_type,book_state,book_stock)values" +
            "(#{bookName},#{bookPrice},#{bookType},#{bookState},#{bookStock})")
    public Integer addBook(BookInfo bookInfo);

    @Update("update book_info set book_id = #{bookId},book_name = #{bookName}, book_price = #{bookPrice}")
    public Integer editBook(BookInfo bookInfo);

    @Select("SELECT * FROM book_storage INNER JOIN book_info ON book_storage.book_id = book_info.book_id;")
    public List<BookInfo> findAnd();
}
