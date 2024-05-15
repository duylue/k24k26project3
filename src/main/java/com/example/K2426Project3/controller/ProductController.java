package com.example.K2426Project3.controller;

import com.example.K2426Project3.model.Category;
import com.example.K2426Project3.model.Customer;
import com.example.K2426Project3.model.Product;
import com.example.K2426Project3.model.Zone;
import com.example.K2426Project3.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String get(Model model) {
        List<Product> list = productService.list();
        model.addAttribute("list", list);
        return "product/list";
    }

    @GetMapping("/find")
    public String find(Model model, @RequestParam String pname, @RequestParam int price) {
        List<Product> list = productService.findByPnameAndPrice(pname, price);
        model.addAttribute("list", list);
        return "product/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<Category> categories = productService.categoryList();
        model.addAttribute("product",new Product());
        model.addAttribute("listCategory" ,categories);
        return "product/save";
    }

    @GetMapping("/edit")
    public String edit(Model model,@RequestParam int pid){
        List<Category> categories = productService.categoryList();
        Product product = productService.findById(pid);
        model.addAttribute("product",product);
        model.addAttribute("listCategory" ,categories);
        return "product/save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/profile")
    public String profile(Model model, @RequestParam int pid){
        Product product = productService.findById(pid);
        model.addAttribute("pro",product);
        return "product/profile";
    }
    @GetMapping("/delete")
    public String delete(Model model, @RequestParam int pid){
        productService.delete(pid);
        return "product/delete";
    }
}
