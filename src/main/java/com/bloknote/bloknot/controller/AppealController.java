package com.bloknote.bloknot.controller;

import com.bloknote.bloknot.model.Appeal;
import com.bloknote.bloknot.service.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppealController {

    private final AppealService appealService;

    @Autowired
    public AppealController(AppealService appealService) {
        this.appealService = appealService;
    }

    @GetMapping("/appeals")
    public String findAll(Model model){
        List<Appeal> appeals = appealService.findAll();
        model.addAttribute("appeals", appeals);
        return "appeal-list";
    }

    @GetMapping("/appeal-create")
    public String createAppealForm(Appeal appeal){
        return "appeal-create";
    }

    @PostMapping("/appeal-create")
    public String createAppeal(Appeal appeal){
        appealService.saveAppeal(appeal);
        return "redirect:/appeals";
    }

    @GetMapping("/appeal-delete/{id}")
    public String deleteAppeal(@PathVariable("id") Long id){
        appealService.deleteById(id);
        return "redirect:/appeals";
    }
}
