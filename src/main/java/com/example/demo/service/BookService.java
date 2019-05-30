package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    int publish(String title, String description, float price, String phone, String book_url,Integer useId);


    List<Book> searchAll();

    List<Book> getBookByPage(Integer page, Integer pagesize);

    List<Book> getBookInfoById(Integer userId);

    int getBookCount();

    int deleteBookById(Integer bookId);

    int updateBook(String title, String description, float price, String phone,String book_url, Integer bookId);

    int updateBookUrl(String url,Integer bookId);

    int updateBookAdmin(String title, String description, float price, String phone,  Integer bookId);


}
