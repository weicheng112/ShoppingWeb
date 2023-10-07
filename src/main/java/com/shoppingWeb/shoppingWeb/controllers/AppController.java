package com.shoppingWeb.shoppingWeb.controllers;


import com.shoppingWeb.shoppingWeb.User;
import com.shoppingWeb.shoppingWeb.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("")
    public String viewHomePage(){return "index";}

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping("/sparkle")
    public String homepage(Principal principal,Model model) {
        String username = principal.getName();
        model.addAttribute("username",username);
        return "sparkle";
    }



    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

}
