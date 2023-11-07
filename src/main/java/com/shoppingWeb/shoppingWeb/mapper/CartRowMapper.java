package com.shoppingWeb.shoppingWeb.mapper;


import com.shoppingWeb.shoppingWeb.entity.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet resultSet, int i) throws SQLException {

        Cart cart=new Cart();
        cart.setCid(resultSet.getInt("cid"));
        cart.setUid(resultSet.getInt("uid"));
        cart.setPid(resultSet.getInt("pid"));
        cart.setNum(resultSet.getInt("num"));
        cart.setPrice(resultSet.getInt("price"));
        cart.setCreated_user(resultSet.getString("created_user"));
        cart.setCreated_time(resultSet.getDate("created_time"));
        cart.setModified_user(resultSet.getString("modified_user"));
        cart.setModified_time(resultSet.getDate("modified_time"));

        return cart;
    }
}
