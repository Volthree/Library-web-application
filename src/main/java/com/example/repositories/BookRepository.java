package com.example.repositories;

import com.example.models.Book;
import com.example.models.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByHumanKey(Human human);
    List<Book> findBooksByAuthorStartingWith(String ls);
}
