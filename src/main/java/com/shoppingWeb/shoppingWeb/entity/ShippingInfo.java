package com.shoppingWeb.shoppingWeb.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class ShippingInfo extends BaseEntity implements Serializable {
    private String name;
    private String address;
}
