package com.shoppingWeb.shoppingWeb.service;


import com.shoppingWeb.shoppingWeb.dao.ProductDao;
import com.shoppingWeb.shoppingWeb.entity.Product;
import com.shoppingWeb.shoppingWeb.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getHostList() {
        List<Product> products = findHostList();

        return products;
    }

    @Override
    public Product ReadById(Integer id) {

        Product product=findById(id);
        if(product == null){
            throw new ProductNotFoundException("couldn't find certain product info");
        }
        return product;
    }

    private List<Product> findHostList() {
        return productDao.findHostList();
    }

    private Product findById(Integer id){
        return productDao.ReadById(id);
    }
}