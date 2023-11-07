package com.shoppingWeb.shoppingWeb.service;

import com.mysql.cj.exceptions.PasswordExpiredException;
import com.shoppingWeb.shoppingWeb.dao.UserDao;
import com.shoppingWeb.shoppingWeb.entity.User;
import com.shoppingWeb.shoppingWeb.utils.MD5util;
import com.shoppingWeb.shoppingWeb.utils.UUIDutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String CreateUser(User user) {
        // check if the user is duplicate
        String username =user.getUsername();

        if(userDao.ReadByUsername(username) != null){

            throw new IllegalArgumentException("用戶名稱重複");
        }

        Date now =new Date();

        // Password encryption
        String salt = UUIDutil.uuid();
        user.setSalt(salt);
        String md5Password = MD5util.md5(user.getPassword(),salt);
        user.setPassword(md5Password);

        user.setIsDelete(0);
        user.setCreated_user(username);
        user.setCreated_time(now);
        user.setModified_user(username);
        user.setModified_time(now);

        return userDao.CreateUser(user);
    }

    @Override
    public List<User> login(String username, String password) {


        //using dao to find is the data is in our database
        List<User> list=new ArrayList<>();
        list=userDao.ReadByUsername(username);
        // since there must be only one user (we couldn't create duplicate username)

        User user= list.get(0);

        if(userDao.ReadByUsername(username)== null){

            throw new IllegalArgumentException("account not found!");
        }

        if(user.getIsDelete()==1){
            throw new IllegalArgumentException("account is deleted!!");
        }

        String salt = user.getSalt();
        String md5Password = MD5util.md5(password,salt);
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        if(!user.getPassword().equals(md5Password)){
            throw new PasswordExpiredException("wrong password, try again!");
        }

        return list;
    }

    @Override
    public List<User> ReadByUsername(String username) {
        return userDao.ReadByUsername(username);
    }

    @Override
    public String UpdateByUid(Integer uid, User user) {

        if(userDao.ReadByUid(uid)== null){

            throw new IllegalArgumentException("");
        }
        //using dao to find is the data is in our database
        List<User> list=new ArrayList<>();
        list=userDao.ReadByUid(uid);

        User olduser= list.get(0);

        if(olduser.getIsDelete()==1){
            throw new IllegalArgumentException("account is deleted!!");
        }

        olduser.setEmail(user.getEmail());
        olduser.setPhone(user.getPhone());
        olduser.setGender(user.getGender());
        olduser.setModified_time(new Date());
        olduser.setModified_user(user.getModified_user());

        return userDao.UpdateByUid(uid,olduser);
    }
}
