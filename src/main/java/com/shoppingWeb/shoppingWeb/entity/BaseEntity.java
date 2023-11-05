package com.shoppingWeb.shoppingWeb.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private String created_user ;
    private Date created_time;
    private String modified_user;
    private Date modified_time;
}
