package com.example.demo_form.controller;

import com.example.demo_form.entity.User;
import com.example.demo_form.service.IUserService;
import com.example.demo_form.util.Validate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private Validate validate;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "user/list";
    }

    @GetMapping("/save")
    public String showSaveForm(Model model) {
        model.addAttribute("user", new User());
        return "user/save";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        validate.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/save";
        }
        boolean isSuccess = userService.save(user);
        redirectAttributes.addFlashAttribute("isSuccess", isSuccess ? "save success" : "save fail");
        return "redirect:/users";
    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id,
                             RedirectAttributes redirectAttributes) {
        boolean isSuccess = userService.delete(id);
       redirectAttributes.addFlashAttribute("isSuccess", isSuccess ? "delete success" : "delete fail");
        return "redirect:/users";
    }
}
