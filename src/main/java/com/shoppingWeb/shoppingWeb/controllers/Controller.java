package com.shoppingWeb.shoppingWeb.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class Controller {



    @GetMapping("/login")
    public String loginpage(Model model)
    {
        return "login";
    }


    @GetMapping("/login_success")
    public String successpage(Model model)
    {
        return "/login_success";
    }


    @GetMapping("/")
    public String index(Model model)
    {
        return "/index";
    }


    @GetMapping("/register")
    public String register(Model model){ return  "/register";}

    //user modified page
    @GetMapping("/users/@{username}")
    public String usermodified(Model model){ return  "/user_modified";}

    //product page
    @GetMapping("/product")
    public String products(Model model){ return  "/product";}



    @GetMapping("/mycarts")
    public String mycarts(Model model){ return  "/mycarts";}

//    @GetMapping("/checkout")
//    public String checkout(Model model){ return  "/checkout";}

    // Let the image successfully appear on the page
    @GetMapping("/pic/{imagePath:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String imagePath) {
        // Construct the resource path based on the image path
        Resource resource = new FileSystemResource("src/main/resources/static/pic/" + imagePath);
//        System.out.println(resource);
        if (resource.exists() && resource.isReadable()) {
            // If the resource exists and is readable, return it
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                    .body(resource);
        } else {
            // If the resource is not found, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }


}
