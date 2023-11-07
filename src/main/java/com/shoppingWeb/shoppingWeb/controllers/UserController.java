package com.shoppingWeb.shoppingWeb.controllers;

import com.shoppingWeb.shoppingWeb.entity.User;
import com.shoppingWeb.shoppingWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping("/register")
    public String create(@RequestBody User user){
        return userService.CreateUser(user);
    }


    @PostMapping("/userlogin")
    public List<User> userlogin(HttpSession session, @RequestBody User user){
        List<User> list =new ArrayList<>();
        System.out.println(user.getUsername()+"------"+user.getPassword());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        list =userService.login(user.getUsername(),user.getPassword());
        //after login, store to session
        session.setAttribute("uid",list.get(0).getUid());
        session.setAttribute("username",list.get(0).getUsername());

        return (list);
    }

    @PutMapping("users/{uid}")
    public String update(@PathVariable Integer uid,@RequestBody User user){
        // using parameter to store uid
        return userService.UpdateByUid(uid,user);
    }

    @GetMapping("users/{username}")
    public List<User> read(@PathVariable String username){
        // using parameter to store username

        return userService.ReadByUsername(username);
    }




    @GetMapping("users/session-username")
    public  String getsessionusername(HttpSession session){ //@Path用來取得url路徑的值
        return (String)session.getAttribute("username");
    }


    @GetMapping("/sign_out")
    public String signout(HttpSession session){
        //destroy the session
        session.removeAttribute("uid");
        session.removeAttribute("username");
        return "logout success!";
    }



}