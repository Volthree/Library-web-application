package com.example.controllers;

import com.example.models.Book;
import com.example.models.Human;
import com.example.services.BookService;
import com.example.services.HumanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/human")
public class HumanController {
    private final HumanService humanService;
    private final BookService bookService;

    @Autowired
    public HumanController(HumanService humanService, BookService bookService) {

        this.humanService = humanService;
        this.bookService = bookService;
    }

    @GetMapping()
    public String getAllHuman(Model model) {
        model.addAttribute("allHuman", humanService.getAllHuman());
        return "human/showHuman";
    }

    @GetMapping("/newhuman")
    public String createNewHuman(Model model) {
        model.addAttribute("newHuman", new Human());
        return "human/createNewHuman";
    }

    @PostMapping()
    public String addNewHuman(@ModelAttribute("newHuman") @Valid Human human, BindingResult bindingResult) {
//        humanValidator.validate(human, bindingResult);
        if (bindingResult.hasErrors()) return "human/createNewHuman";
        humanService.addNewHuman(human);
        return "redirect:/human";
    }

    @GetMapping("/{id}/edit")
    public String editHuman(@PathVariable("id") int id, Model model) {

        model.addAttribute("updatedHuman", humanService.getHumanById(id));
        return "/human/editHuman";
    }

    @PatchMapping("/{id}")
    public String patchHuman(@PathVariable("id") int id, @ModelAttribute("updatedHuman") @Valid Human human,
                             BindingResult bindingResult) {
//        humanValidator.validate(human, bindingResult);
        if (bindingResult.hasErrors()) return "/human/editHuman";
        humanService.patchHuman(id, human);
        return "redirect:/human";
    }

    @GetMapping("/{id}")
    public String showHuman(@PathVariable("id") int id, Model model) {

       model.addAttribute("currenthuman", humanService.getHumanById(id));
       model.addAttribute("books",
               bookService.findBooksByHumanId(humanService.getHumanById(id)));

        return "human/page";
    }

    @DeleteMapping("/{id}")
    public String deleteHuman(@PathVariable("id") int id) {
        humanService.deleteHuman(id);
        return "redirect:/human";
    }

}
