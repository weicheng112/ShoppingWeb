package com.shoppingWeb.shoppingWeb.dao;

import com.shoppingWeb.shoppingWeb.entity.Product;

import java.util.List;

public interface ProductDao {


    List<Product> findHostList();


    Product ReadById(Integer id);
}