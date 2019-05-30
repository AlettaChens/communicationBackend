package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.apache.ibatis.annotations.Mapper
public interface BookMapper {
    @Insert("insert into t_book(title,description,price,phone,date,book_url,userId)values(#{title},#{description},#{price},#{phone},#{date},#{book_url},#{userId})")
    int publish(@Param(value = "title") String title, @Param(value = "description") String description, @Param(value = "price") float price, @Param(value = "phone") String phone, @Param(value = "date") String date, @Param(value = "book_url") String book_url,@Param(value = "userId") Integer userId);

    @Select("select * from t_book")
    List<Book> searchAll();

    @Select("select * from t_book limit #{offset},#{pagesize}")
    List<Book> getBookByPage(@Param(value = "offset") Integer offset, @Param(value = "pagesize") Integer pagesize);

    @Select("select * from t_book where userId=#{userId}")
    List<Book> getBookInfoByUserId(@Param(value = "userId") Integer userId);

    @Select("select count(*) from t_book")
    int getBookCount();

    @Delete("delete from t_book where bookId=#{bookId}")
    int deleteBookById(@Param(value = "bookId") Integer bookId);

    @Update("update t_book set book_url=#{book_url}where bookId=#{bookId}")
    int updateUrl(@Param(value = "book_url") String book_url, @Param(value = "bookId") Integer bookId);

    @Update("update t_book set title=#{title},description=#{description}，price=#{price}，phone=#{phone}，date=#{date}，book_url=#{book_url}where bookId=#{bookId}")
    int updateBook(@Param(value = "title") String title, @Param(value = "description") String description, @Param(value = "price") float price, @Param(value = "phone") String phone, @Param(value = "date") String date, @Param(value = "book_url") String book_url, @Param(value = "bookId") Integer bookId);

    @Update("update t_book set title=#{title},description=#{description},price=#{price},phone=#{phone},date=#{date} where bookId=#{bookId}")
    int updateBookAdmin(@Param(value = "title") String title, @Param(value = "description") String description, @Param(value = "price") float price, @Param(value = "phone") String phone, @Param(value = "date") String date, @Param(value = "bookId") Integer bookId);
}
