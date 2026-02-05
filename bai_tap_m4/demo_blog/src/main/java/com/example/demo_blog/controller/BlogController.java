package com.example.demo_blog.controller;

import com.example.demo_blog.entity.Blog;
import com.example.demo_blog.entity.Category;
import com.example.demo_blog.service.IBlogService;
import com.example.demo_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
   public String list(@RequestParam(name = "page",defaultValue = "0") int page,
                      @RequestParam(name = "searchTitle", defaultValue = "")  String searchTitle,
                      Model model) {
        Sort sort = Sort.by("title").descending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Blog> blogPage;
        if (searchTitle.isEmpty()){
            blogPage = blogService.findByTitleContaining("",pageable);
        }else {
            blogPage = blogService.searchTitle(searchTitle,pageable);
        }
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/list";
    }
    @GetMapping("/save")
    public String showFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/save";
    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute Blog blog,
                           RedirectAttributes redirectAttributes) {
        blog.setCreateAt(LocalDateTime.now());
        Category category = categoryService.findById(blog.getCategory().getId());
        blog.setCategory(category);
        boolean isSuccess = blogService.save(blog);
        redirectAttributes.addFlashAttribute("isSuccess", isSuccess ? "save success" : "save fail");
        return "redirect:/blogs";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
       model.addAttribute("blog", blogService.findById(id));
       return "blog/detail";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id,
                         RedirectAttributes redirectAttributes) {
        boolean isSuccess = blogService.delete(id);
        redirectAttributes.addFlashAttribute("isSuccess", isSuccess ? "delete success" : "delete fail");
        return "redirect:/blogs";
    }

}
