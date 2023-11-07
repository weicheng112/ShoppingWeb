package com.shoppingWeb.shoppingWeb.mapper;

import com.shoppingWeb.shoppingWeb.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {

        Product product=new Product();
        product.setId(resultSet.getInt("id"));
        product.setCategoryId(resultSet.getInt("categoryId"));
        product.setType(resultSet.getString("type"));
        product.setTitle(resultSet.getString("title"));
        product.setPrice(resultSet.getInt("price"));
        product.setNum(resultSet.getInt("num"));
        product.setImagepath(resultSet.getString("imagepath"));
        product.setStatus(resultSet.getInt("status"));
        product.setPriority(resultSet.getInt("priority"));
        product.setCreated_user(resultSet.getString("created_user"));
        product.setCreated_time(resultSet.getDate("created_time"));
        product.setModified_user(resultSet.getString("modified_user"));
        product.setModified_time(resultSet.getDate("modified_time"));
        return product;
    }

}
