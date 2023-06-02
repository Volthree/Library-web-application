package com.example.dao;

import com.example.models.Book;
import com.example.models.Human;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;
import java.util.List;

@Component
public class BookDAO {


    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Transactional
    public List<Book> showAllBooks() {
        //return jdbcTemplate.query("select * from books", new BookMapper());
        Session session = sessionFactory.getCurrentSession();
        List<Book> lb = session.createQuery("select bb from Book bb", Book.class).getResultList();
        return lb;
    }

    public void addNewBook(Book book) {
//        jdbcTemplate.update("insert into books(humanid, bookname, author, releaseDate) values(null, ?, ?, ?)",
//                book.getBookName(), book.getAuthor(), book.getReleaseDate());
    }

    public Book getCurrentBook(int id) {
        //return showAllBooks().stream().filter(Book->Book.getId()==id).findAny().orElse(null);
        return null;
    }

    public Book getCurrentBook(String book) {
//        return jdbcTemplate.query("select * from books where bookName=?", new Object[]{book},
//                new BookMapper()).stream().findAny().orElse(null);
        return null;
    }

    public void pathBook(int id, Book book) {
//        jdbcTemplate.update("update books set bookname=?, author=?, releaseDate=? where id=?",
//                book.getBookName(), book.getAuthor(), book.getReleaseDate(), id);
    }

    public Human getOwner(int id) {
//        return jdbcTemplate.query("select human.id, human.name, human.birthday from human " +
//                "inner join books on human.id=books.humanid " +
//                "where books.id=?", new Object[]{id}, new HumanMapper()).stream().findAny().orElse(null);
        return null;
    }

    public List<Human> getAllHumans() {
//        return jdbcTemplate.query("select * from human", new HumanMapper());
        return null;
    }

    public void setFreeBook(int id) {
//        jdbcTemplate.update("update books set humanid=null where id=?", id);
    }

    public void patchHuman(int id, Book book) {
//        jdbcTemplate.update("update books set humanid=? where id=?", book.getHumanid(), id);
    }
}
