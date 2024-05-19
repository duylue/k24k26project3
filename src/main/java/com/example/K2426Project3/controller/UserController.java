package com.example.K2426Project3.controller;

import com.example.K2426Project3.model.User;
import com.example.K2426Project3.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/login")
    public String login(Model model, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String mess = "";
        Integer check = (Integer) session.getAttribute("checkLogin");
        if (check == null || check == 2) {
            mess = "Tai khoan hoac mat khau khong dung";
        }
        session.setAttribute("checkLogin", 1);
        model.addAttribute("mes", mess);

        return "user/login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, @RequestParam String username,
                            @RequestParam String password, HttpServletResponse response, HttpServletRequest request) {
        User user = service.findByUsernameAndPass(username, password);
        HttpSession session = request.getSession();
        if (user == null) {
            session.setAttribute("checkLogin", 2);
            return "redirect:/login";
        }
        session.setAttribute("name",user.getName());
        session.setMaxInactiveInterval(20);
        return "redirect:/product";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @GetMapping("/notifyRegister")
    public String notifyRegister() {
        return "user/notifyRegister";
    }
    @GetMapping("/logout")
    public String logout( HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        return "user/logout";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute User user) {
        try {
            service.register(user);
        } catch (Exception e) {
            return "redirect:/notifyRegister";
        }

        return "redirect:/login";
    }
}
