package com.shoppingWeb.shoppingWeb.entity;

import lombok.Data;

@Data
public class Cart extends BaseEntity {

    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Integer num;
    private Integer price;

}