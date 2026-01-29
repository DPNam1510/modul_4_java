package com.example.demo_caculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/")
    public String home() {
        return "calculator";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(name = "num1", required = false) Double num1,
                             @RequestParam(name = "num2", required = false) Double num2,
                             @RequestParam(name = "action",required = false) String action,
                       Model model) {

        if (num1 == null || num2 == null || action == null) {
            return "calculator";
        }

        switch (action) {
            case "sum":
                model.addAttribute("result", num1 + num2);
                break;
            case "sub":
                model.addAttribute("result", num1 - num2);
                break;
            case "mul":
                model.addAttribute("result", num1 * num2);
                break;
            case "div":
                if (num2 == 0) {
                    model.addAttribute("result", "!!!");
                    model.addAttribute("mess", "mẫu số phải khác 0");
                } else {
                    model.addAttribute("result", num1 / num2);
                }
                break;
            default:
        }

        return "calculator";
    }
}
