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


    //用戶註冊
    @PostMapping("/register")
    public String create(@RequestBody User user){
        return userService.CreateUser(user);
    }

    //用戶登入
    @PostMapping("/userlogin")
    public List<User> userlogin(HttpSession session, @RequestBody User user){
        List<User> list =new ArrayList<>();
        System.out.println(user.getUsername()+"------"+user.getPassword());
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        list =userService.login(user.getUsername(),user.getPassword());
        //登入成功後設置session的值
        session.setAttribute("uid",list.get(0).getUid());
        session.setAttribute("username",list.get(0).getUsername());

        return (list);
    }

    @PutMapping("users/{uid}") //根據帳號做修改
    public String update(@PathVariable Integer uid,@RequestBody User user){ //@Path用來取得url路徑的值

        return userService.UpdateByUid(uid,user);
    }

    @GetMapping("users/{username}")
    public List<User> read(@PathVariable String username){ //@Path用來取得url路徑的值

        return userService.ReadByUsername(username);
    }



    //用來獲取session中的username，在前端某些需要的地方會用到。
    @GetMapping("users/session-username")
    public  String getsessionusername(HttpSession session){ //@Path用來取得url路徑的值
        return (String)session.getAttribute("username");
    }

    //用戶登出
    @GetMapping("/sign_out")
    public String signout(HttpSession session){
        //銷毀session中的KV
        session.removeAttribute("uid");
        session.removeAttribute("username");
        return "登出成功";
    }



}