package com.example.demo.service.imp;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Component
public class Bookimpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date=df.format(new Date());

    @Override
    public int publish(String title, String description, float price, String phone, String book_url, Integer userId) {
        return bookMapper.publish(title,description,price,phone,date,book_url,userId);
    }

    @Override
    public List<Book> searchAll() {
        return bookMapper.searchAll();
    }

    @Override
    public List<Book> getBookByPage(Integer page, Integer pagesize) {
        return bookMapper.getBookByPage((page-1)*pagesize,pagesize);
    }

    @Override
    public List<Book> getBookInfoById(Integer userId) {
        return bookMapper.getBookInfoByUserId(userId);
    }

    @Override
    public int getBookCount() {
        return bookMapper.getBookCount();
    }

    @Override
    public int deleteBookById(Integer bookId) {
        return bookMapper.deleteBookById(bookId);
    }

    @Override
    public int updateBook(String title, String description, float price, String phone, String book_url, Integer bookId) {
        return bookMapper.updateBook(title,description,price,phone,date,book_url,bookId);
    }

    @Override
    public int updateBookAdmin(String title, String description, float price, String phone, Integer bookId) {
        return bookMapper.updateBookAdmin(title,description,price,phone,date,bookId);
    }

    @Override
    public int updateBookUrl(String url, Integer bookId) {
        return bookMapper.updateUrl(url,bookId);
    }
}
