package com.example.change_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @GetMapping(value = "")
    public String showForm() {
        return "index";
    }

    @PostMapping("/changeMoney")
    public String changeMoney(@RequestParam("amount") double amount, @RequestParam("rate") double rate,
                              @RequestParam("type") String type, Model model) {
        double result;
        String message;
        if ("UsdToVnd".equals(type)) {
            result = amount * rate;
            message = amount + "USD =" + result + "VND";
        } else{
            result = amount / rate;
            message = amount + "VND =" + result + "USD";
        }
        model.addAttribute("amount", amount);
        model.addAttribute("rate", rate);
        model.addAttribute("type", type);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "index";
    }
}
