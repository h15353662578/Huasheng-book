package com.hs.book.service;

import com.hs.entity.BookInfo;
import com.hs.entity.BookInfoVo;

import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:46
 * @Description
 */
public interface BookService {

    public List<BookInfoVo> findAllBook();

    public Integer addBook(BookInfo bookInfo);

    public Integer editBook(BookInfo bookInfo);

    public List<BookInfo> findAnd();
}
