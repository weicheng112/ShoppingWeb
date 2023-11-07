package com.shoppingWeb.shoppingWeb.controllers;

import com.shoppingWeb.shoppingWeb.entity.Product;
import com.shoppingWeb.shoppingWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    //
    @GetMapping("/list/hot")
    public List<Product> getHostList(){
        return productService.getHostList();
    }

//    @GetMapping("/")
//    public List<Product> getHostList1(){
//        return productService.getHostList();
//    }
    @GetMapping
    public Product ReadById(@RequestParam Integer id){
        return productService.ReadById(id);
    }

    @GetMapping("/{imagePath:.+}")
    public ResponseEntity<Resource> serveImage(@PathVariable String imagePath) {
        // Construct the resource path based on the image path
        Resource resource = new FileSystemResource("src/main/resources/static" + imagePath);
        System.out.println(resource);
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
