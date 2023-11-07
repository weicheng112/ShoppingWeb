package com.shoppingWeb.shoppingWeb.service;

import com.shoppingWeb.shoppingWeb.entity.Cart;
import com.shoppingWeb.shoppingWeb.entity.CartVO;

import java.util.List;

public interface CartService {



    void AddToCart(Integer uid, String username, Integer pid, Integer amount);


    List<CartVO> GetByUid(Integer uid);

    String AddNum(Integer cid, Integer uid, String username);

    void DeleteByCid(Integer cid);
//    double calculateTotalAmount(List<CartVO> cartItems);
}
