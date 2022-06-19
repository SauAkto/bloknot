package com.bloknote.bloknot.controller;

import com.bloknote.bloknot.model.Appeal;
import com.bloknote.bloknot.model.Zapiska;
import com.bloknote.bloknot.service.AppealService;
import com.bloknote.bloknot.service.ZapiskaService;
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
    private final ZapiskaService zapiskaService;

    @Autowired
    public AppealController(AppealService appealService, ZapiskaService zapiskaService) {
        this.appealService = appealService;
        this.zapiskaService = zapiskaService;
    }

    @GetMapping("/appeals")
    public String findAll(Model model){
        List<Appeal> appeals = appealService.findAll();
        Zapiska zapiskas = zapiskaService.getZapiska(1l);
        model.addAttribute("appeals", appeals);
        model.addAttribute("zapiskas", zapiskas);
        return "appeal-list";
    }
    @PostMapping("/appeals")
    public String saveZaAppealsCreate(Zapiska zapiska){
        zapiska.setId(1l);
        zapiskaService.saveZapiska(zapiska);
        return "appeal-create";
    }

    @PostMapping("/appeals/{ind}/{id}")
    public String saveZaAppealsUpdate(@PathVariable("id") Long id, @PathVariable("ind") String ind, Zapiska zapiska){
        zapiska.setId(1l);
        zapiskaService.saveZapiska(zapiska);
        String urlAdr = "";
        String idi = Long.toString(id);
        if(ind == "1"){
            urlAdr = "appeal-update/"+idi; }
        if(ind == "2"){
            urlAdr = "appeal-delete/"+idi; }
        return urlAdr;
        }

    @GetMapping("/appeal-create")
    public String createAppealForm(Model model){
        Zapiska zapiska = zapiskaService.getZapiska(1l);
        model.addAttribute("zapiska", zapiska);
        return "appeal-create";
    }

    @PostMapping("/appeal-create")
    public String createAppeal(Appeal appeal, Zapiska zapiska){
        zapiska.setId(1l);
        zapiskaService.saveZapiska(zapiska);
        appealService.saveAppeal(appeal);
        return "redirect:/appeals";
    }

    @GetMapping("/appeal-delete/{id}")
    public String deleteAppeal(@PathVariable("id") Long id){
        appealService.deleteById(id);
        return "redirect:/appeals";
    }

    @GetMapping("/appeal-update/{id}")
    public String updateAppealsForm(@PathVariable("id") Long id, Model model){
        Appeal appeal = appealService.findById(id);
        model.addAttribute("appeal", appeal);
        return "appeal-update";
    }

    @PostMapping("appeal-update")
    public String updateAppeal(Appeal appeal){
        appealService.saveAppeal(appeal);
        return "redirect:/appeals";
    }
}
