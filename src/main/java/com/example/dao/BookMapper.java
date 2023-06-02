package com.example.dao;

import com.example.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getInt("id"));
        book.setHumanid(rs.getInt("humanid"));
        book.setBookName(rs.getString("bookName"));
        book.setAuthor(rs.getString("author"));
        book.setReleaseDate(rs.getInt("releaseDate"));
        return book;
    }
}
