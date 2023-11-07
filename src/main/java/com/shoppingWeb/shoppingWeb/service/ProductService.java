package com.shoppingWeb.shoppingWeb.service;

import com.shoppingWeb.shoppingWeb.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getHostList();


    Product ReadById(Integer id);

}
