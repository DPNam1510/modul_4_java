package com.example.dictionary.controller;
import com.example.dictionary.entity.Dictionary;
import com.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/Dictionary")
    public String addDictionary(@RequestParam("english") String english, Model model) {
        String meaning = dictionaryService.getDictionary(english);
        if (meaning == null) {
            model.addAttribute("error", "No dictionary found");
        }else  {
            model.addAttribute("result", meaning);
        }
        model.addAttribute("english", english);
        return "home";
    }
}
