package com.shoppingWeb.shoppingWeb.dao;

import com.shoppingWeb.shoppingWeb.entity.Cart;
import com.shoppingWeb.shoppingWeb.entity.CartVO;

import java.util.Date;
import java.util.List;

public interface CartDao {

    Integer CreateCart(Cart cart);


    List<Cart> FindByUidandPid(Integer uid,Integer pid);


    Integer UpdateNumByCid(Integer cid, Integer num, String modified_user, Date modified_time);

    List<CartVO> FindByUid(Integer uid);


    Cart FindByCid(Integer cid);

    Integer DeleteByCid(Integer cid);


}