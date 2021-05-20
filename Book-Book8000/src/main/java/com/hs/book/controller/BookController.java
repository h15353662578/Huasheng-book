package com.hs.book.controller;

import com.hs.book.service.BookService;
import com.hs.config.CommonResult;
import com.hs.entity.BookInfo;
import com.hs.entity.BookInfoVo;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huasheng
 * @Date 2021/04/13/9:47
 * @Description
 */

@RestController
@RequestMapping("/Book")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/findAllBook")
    public List<BookInfoVo> findAllBook(){
        System.out.println(""+bookService.findAllBook());
        return bookService.findAllBook();
    }

    @GetMapping("/addBook")
    public CommonResult addBook(@Param("BookInfo") BookInfo bookInfo){
        return CommonResult.success(bookService.addBook(bookInfo));
    }

    @PostMapping("/editBook")
    public CommonResult editBook(BookInfo bookInfo){
        return CommonResult.success(bookService.editBook(bookInfo));
    }

    @GetMapping("/findAnd")
    public List<BookInfo> findAnd(){
       return bookService.findAnd();
    }
}
