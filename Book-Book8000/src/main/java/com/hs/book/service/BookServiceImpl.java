package com.hs.book.service;

import com.hs.book.mapper.BookMapper;
import com.hs.entity.BookInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:46
 * @Description
 */

@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<BookInfo> findAllBook(){
        return bookMapper.findAllBook();
    }

    @Override
    public Integer addBook(BookInfo bookInfo){
        return bookMapper.addBook(bookInfo);
    }

    @Override
    public Integer editBook(BookInfo bookInfo){
        return bookMapper.editBook(bookInfo);
    }

    @Override
    public List<BookInfo> findAnd(){
        return bookMapper.findAnd();
    }
}
