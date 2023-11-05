package com.shoppingWeb.shoppingWeb.dao;

import com.shoppingWeb.shoppingWeb.entity.User;

import java.util.List;

public interface UserDao {
    //create user
    String CreateUser(User user);

    //using username to query
    List<User> ReadByUsername(String username);
    //using uid to query
    List<User> ReadByUid(Integer uid);
    //using uid to modify the data
    String UpdateByUid(Integer uid,User user);
}
