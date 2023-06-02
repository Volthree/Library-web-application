package com.example.controllers;

import com.example.dao.BookDAO;
import com.example.models.Book;
import com.example.models.Human;
import com.example.util.BookValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    private final BookValidator bookValidator;

    public BookController(BookDAO bookDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String showBooks(Model model){
        model.addAttribute("booklist", bookDAO.showAllBooks());
        return "books/showBooks";
    }
    @GetMapping("/newbook")
    public String createNewBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "books/createNewBook";
    }
    @PostMapping()
    public String addNewBook(@ModelAttribute("newBook") @Valid Book book, BindingResult bindingResult) {
        bookValidator.validate(book, bindingResult);
        if(bindingResult.hasErrors()) return "books/createNewBook";
        bookDAO.addNewBook(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = bookDAO.getCurrentBook(id);
        model.addAttribute("booktoedit", book);
        return "books/editBook";
    }
    @GetMapping("/{id}")
    public String bookPage(@PathVariable("id") int id, Model model, @ModelAttribute("bo") Book bo){

        Book book = bookDAO.getCurrentBook(id);
        model.addAttribute("currentbook", book);
        bo.setId(888);
        Human human = bookDAO.getOwner(id);
        model.addAttribute("bookowner", human);
        List<Human> humanList = bookDAO.getAllHumans();
        model.addAttribute("allhuman", humanList);
        return "books/bookpage";
    }
    @PatchMapping("/{id}")
    public String changeBook(@PathVariable("id") int id, @ModelAttribute("booktoedit") @Valid Book book,
                             BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if(bindingResult.hasErrors()) return "books/editBook";
        bookDAO.pathBook(id, book);
        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookDAO.setFreeBook(id);
        return "redirect:/books";
    }
    @PatchMapping("/{id}/patch")
    public String assignBook(@PathVariable("id") int id, @ModelAttribute("bo") Book book){
        System.out.println(book.getId() + " " + book.getHumanid());
        bookDAO.patchHuman(id, book);
        return "redirect:/books";
    }

}
