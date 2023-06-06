package com.example.controllers;

import com.example.dao.BookDAO;
import com.example.models.Book;
import com.example.services.BookService;
import com.example.services.HumanService;
import com.example.util.BookValidator;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final HumanService humanService;

    public BookController(BookService bookService, HumanService humanService) {
        this.bookService = bookService;
        this.humanService = humanService;
    }

    @GetMapping()
    public String showBooks(@RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "book_per_page", required = false) Integer size,
                            Model model) {
        //model.addAttribute("booklist", bookService.findAll());
        model.addAttribute("pageNum", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("booklist", bookService.getPagenable(page,size));
        return "books/showBooks";
    }

    @GetMapping(value = "/newbook")
    public String createNewBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "books/createNewBook";
    }

    @PostMapping()
    public String addNewBook(@ModelAttribute("newBook") @Valid Book book, BindingResult bindingResult) {
        bookService.addBook(book);
        return "redirect:/books?page=1&book_per_page=5";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("booktoedit", bookService.findOne(id));
        return "books/editBook";
    }

    @GetMapping("/{id}")
    public String bookPage(@PathVariable("id") int id, Model model, @ModelAttribute("bo") Book bo) {

        Book book = bookService.findOne(id);
        model.addAttribute("currentbook", bookService.findOne(id));
        model.addAttribute("bookowner", humanService.getHumanByBook(book.getHumanKey()));
        model.addAttribute("allhuman", humanService.getAllHuman());
        return "books/bookpage";
    }

    @PatchMapping("/{id}")
    public String changeBook(@PathVariable("id") int id,
                             @ModelAttribute("booktoedit") @Valid Book book,
                             BindingResult bindingResult) {

        if(bindingResult.hasErrors()) return "books/editBook";
        bookService.updateBook(id, book);
        return "redirect:/books?page=1&book_per_page=5";
    }

    @DeleteMapping("/{id}")
    public String setFreeBook(@PathVariable("id") int id) {
        bookService.setFreeBook(id);
        return "redirect:/books?page=1&book_per_page=5";
    }

    @PatchMapping("/{id}/patch")
    public String assignBook(@PathVariable("id") int id, @ModelAttribute("bo") Book book) {
        bookService.assignBookToHuman(id, book);
        return "redirect:/books?page=1&book_per_page=5";
    }
    @GetMapping("/search")
    public String searchB(){
        return "books/search";
    }
    @PostMapping("/search")
    public String searchBook(@RequestParam("query") String ls, Model model){
        model.addAttribute("ls", ls);
        model.addAttribute("lb", bookService.searchBook(ls));
        return "books/search";
    }


}
