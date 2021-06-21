package com.javaee.bookshop_book_provider.dao;

import com.javaee.bookshop_book_provider.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("bookDao")
public interface IBookDao {
    Book findById(Integer id);

    void addBook(Book book);

    List<Book> getBookList();

    void delBook(Integer id);
}