package com.hs.book.mapper;

import com.hs.entity.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:47
 * @Description
 */

@Mapper
public interface BookMapper {

    @Select("select * from book_info")
    public List<BookInfo> findAllBook();

    @Insert("insert into book_info(book_name,book_price,book_type,book_state,book_stock)values" +
            "(#{bookName},#{bookPrice},#{bookType},#{bookState},#{bookStock})")
    public Integer addBook(BookInfo bookInfo);

    @Update("update book_info set book_id = #{bookId},book_name = #{bookName}, book_price = #{bookPrice}")
    public Integer editBook(BookInfo bookInfo);

    @Select("SELECT * FROM book_storage INNER JOIN book_info ON book_storage.book_id = book_info.book_id;")
    public List<BookInfo> findAnd();
}
