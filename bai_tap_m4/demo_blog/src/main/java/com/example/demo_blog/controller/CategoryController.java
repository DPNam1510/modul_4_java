package com.example.demo_blog.controller;

import com.example.demo_blog.entity.Category;
import com.example.demo_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/list";
    }
    @GetMapping("/save")
    public String showFormSave(Model model) {
        model.addAttribute("category", new Category());
        return "category/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean IsSuccess = categoryService.delete(id);
        redirectAttributes.addFlashAttribute("IsSuccess", IsSuccess ? "delete success" : "delete fail");
        return "redirect:/categories";
    }
}
