package com.example.product_management.controller;

import com.example.product_management.entity.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping(value = "/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping(value = "/add")
    public String addProduct(@ModelAttribute Product product,
                             RedirectAttributes redirectAttributes) {
        product.setId((int)(Math.random()*1000));
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product has been added");
        return "redirect:/products/";
    }

    @GetMapping("{id}/update")
    public String updateProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes) {
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product has been updated");
        return "redirect:/products/";
    }

    @PostMapping("{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products/";
    }

    @GetMapping("{id}/detail")
    public String detailProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }

//    @GetMapping("/search")
//    public String searchProduct(@RequestParam String name, Model model) {
//        model.addAttribute("product", productService.searchByName(name));
//        return "product/search";
//    }
}
