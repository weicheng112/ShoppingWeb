package com.shoppingWeb.shoppingWeb.service;

import com.shoppingWeb.shoppingWeb.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.util.List;


public interface UserService {


    String CreateUser(User user);

    List<User> ReadByUsername(String username);

    // login
    List<User> login(String username,String password);
    // modified
    String UpdateByUid(Integer uid,User user);
}