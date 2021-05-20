package com.hs.book.service;

import com.hs.book.mapper.BookMapper;
import com.hs.entity.BookInfo;
import com.hs.entity.BookInfoVo;
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
    public List<BookInfoVo> findAllBook(){
        System.out.println(""+bookMapper.findAllBook());
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
