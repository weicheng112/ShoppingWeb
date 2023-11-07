package com.shoppingWeb.shoppingWeb.mapper;

import com.shoppingWeb.shoppingWeb.entity.CartVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartVORowMapper implements RowMapper<CartVO> {

    @Override
    public CartVO mapRow(ResultSet resultSet, int i) throws SQLException {

        CartVO cartVO=new CartVO();
        cartVO.setCid(resultSet.getInt("cid"));
        cartVO.setUid(resultSet.getInt("uid"));
        cartVO.setPid(resultSet.getInt("pid"));
        cartVO.setNum(resultSet.getInt("num"));
        cartVO.setPrice(resultSet.getInt("price"));
        cartVO.setTitle(resultSet.getString("title"));
        cartVO.setRealPrice(resultSet.getInt("realPrice"));


        return cartVO;
    }
}
