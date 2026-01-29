package com.example.demo_blog.controller;

import com.example.demo_blog.entity.Blog;
import com.example.demo_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blog/list";
    }

    @GetMapping("/save")
    public String showFormAdd(@ModelAttribute Blog blog,
                              RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        boolean isSuccess = blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", isSuccess ? "Blog saved successfully" : "Blog save failed");
        return "blog/save";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }
}
