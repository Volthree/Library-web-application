package com.example.services;

import com.example.models.Book;
import com.example.models.Human;
import com.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void setFreeBook(int id) {
        Book b = bookRepository.findById(id).orElse(null);
        assert b != null;
        b.setHumanKey(null);
        bookRepository.save(b);
    }

    @Transactional
    public void updateBook(int id, Book book) {
        book.setId(id);
        Book b = bookRepository.findById(id).orElse(null);
        assert b != null;
        book.setHumanKey(b.getHumanKey());
        bookRepository.save(book);
    }
    @Transactional
    public void assignBookToHuman(int id, Book book){
        Book b = bookRepository.findById(id).orElse(null);
        assert b != null;
        b.setHumanKey(book.getHumanKey());
        bookRepository.save(b);
    }
    public List<Book> findBooksByHumanId(Human human){
        return bookRepository.findBooksByHumanKey(human);
    }


}
