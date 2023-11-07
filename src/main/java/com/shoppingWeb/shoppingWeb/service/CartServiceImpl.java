package com.shoppingWeb.shoppingWeb.service;

import com.shoppingWeb.shoppingWeb.dao.CartDao;
import com.shoppingWeb.shoppingWeb.entity.Cart;
import com.shoppingWeb.shoppingWeb.entity.CartVO;
import com.shoppingWeb.shoppingWeb.entity.Product;
import com.shoppingWeb.shoppingWeb.exception.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductService productService;



    private void Create(Cart cart) {
        Integer rows = cartDao.CreateCart(cart);
        if (rows != 1) {
            throw new RuntimeException("");
        }
    }


    private List<Cart> findByUidAndPid(Integer uid, Integer pid) {

        return cartDao.FindByUidandPid(uid,pid);
    }


    private void UpdateNumByCid(Integer cid, Integer num, String modified_user, Date modified_time) {

        Integer rows = cartDao.UpdateNumByCid(cid, num, modified_user, modified_time);
        if (rows != 1) {
            throw new RuntimeException("");
        }
    }

    @Override
    public List<CartVO> GetByUid(Integer uid) {
        return FindByUid(uid);
    }

    private List<CartVO> FindByUid(Integer uid) {
        return cartDao.FindByUid(uid);
    }


    @Override
    public void AddToCart(Integer uid, String username, Integer pid, Integer amount) {


        Date now = new Date();

        List<Cart> list = new ArrayList<>();
        list=findByUidAndPid(uid, pid);


        if (list == null) {
            // need to create new shopping cart

            //get id
            Product product = productService.ReadById(pid);
            //create new cart
            Cart cart = new Cart();

            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            cart.setPrice(product.getPrice());
            cart.setCreated_user(username);
            cart.setCreated_time(now);
            cart.setModified_user(username);
            cart.setModified_time(now);


            Create(cart);
        } else {
            // no, means the product is in the cart
            Integer cid = list.get(0).getCid();
            // change the num of product
            Integer num = list.get(0).getNum() + amount;
            // update!!!
            UpdateNumByCid(cid, num, username, now);
        }


    }

    @Override
    public String AddNum(Integer cid, Integer uid, String username) {
        //find the cart information
        Cart result = FindByCid(cid);

        if (result == null) {

            throw new CartNotFoundException("cart is not exist!");
        }

        // if user id is not the same as required, fail
        if (!result.getUid().equals(uid)) {
            throw new CartNotFoundException("couldn't do such require, uid is not allowable");
        }


        Integer newNum = result.getNum() + 1;
        UpdateNumByCid(cid, newNum, username, new Date());

        return "Add Success!";
    }

    @Override
    public void DeleteByCid(Integer cid) {
        Integer rows = cartDao.DeleteByCid(cid);

        if (rows != 1) {
            throw new RuntimeException("Failed to delete the cart item.");
        }
    }

//    @Override
//    public double calculateTotalAmount(Integer pid,Integer amount) {
//        double totalAmount = 0.0;
//
//
//        Product product = productService.ReadById(pid);
//        totalAmount += product.getPrice()*amount;
//
//
//        return totalAmount;
//    }


    private Cart FindByCid(Integer cid) {
        return cartDao.FindByCid(cid);
    }

}