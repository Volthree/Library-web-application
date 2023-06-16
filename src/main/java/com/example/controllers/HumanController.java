package com.example.controllers;

import com.example.dao.HumanDAO;
import com.example.models.Book;
import com.example.models.Human;
import com.example.util.HumanValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


// This class is a good candidate to write unit tests for.
// There's no a single test in the project, it's good to have some


@Controller
@RequestMapping("/human")
public class HumanController {
    private final HumanDAO  humanDAO;
    private final HumanValidator humanValidator;

    @Autowired
    public HumanController(HumanDAO humanDAO, HumanValidator humanValidator) {
        this.humanDAO = humanDAO;
        this.humanValidator = humanValidator;
    }

    @GetMapping()
    public String getAllHuman(Model model) {
        model.addAttribute("allHuman", humanDAO.showAllHumans());
        return "human/showHuman";
    }

    @GetMapping("/newhuman")
    public String createNewHuman(Model model) {
        model.addAttribute("newHuman", new Human());
        return "human/createNewHuman";
    }

    @PostMapping()
    public String addNewHuman(@ModelAttribute("newHuman") @Valid Human human, BindingResult bindingResult) {
        humanValidator.validate(human, bindingResult);
        if(bindingResult.hasErrors()) return "human/createNewHuman";
        humanDAO.addNewHuman(human);
        return "redirect:/human";
    }

    @GetMapping("/{id}/edit")
    public String editHuman(@PathVariable("id") int id, Model model) {
        Human human = humanDAO.getCurrentHuman(id);
        model.addAttribute("updatedHuman", human);
        return "/human/editHuman";
    }

    @PatchMapping("/{id}")
    public String patchHuman(@PathVariable("id") int id, @ModelAttribute("updatedHuman") @Valid Human human,
                             BindingResult bindingResult) {
        humanValidator.validate(human, bindingResult);
        if(bindingResult.hasErrors()) return "/human/editHuman";
        humanDAO.patchHuman(id, human);
        return "redirect:/human";
    }
    @GetMapping("/{id}")
    public String showHuman(@PathVariable("id") int id, Model model){
        Human human = humanDAO.getCurrentHuman(id);
        model.addAttribute("currenthuman", human);
        List<Book> lb = humanDAO.showBooks(id);
        model.addAttribute("books", lb);
        return "human/page";
    }
    @DeleteMapping("/{id}")
    public String deleteHuman(@PathVariable("id") int id){
        humanDAO.deleteHuman(id);
        return "redirect:/human";
    }

}
