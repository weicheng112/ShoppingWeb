package com.shoppingWeb.shoppingWeb.controllers;

import com.shoppingWeb.shoppingWeb.entity.Cart;
import com.shoppingWeb.shoppingWeb.entity.CartVO;
import com.shoppingWeb.shoppingWeb.entity.Product;
import com.shoppingWeb.shoppingWeb.service.CartService;
import com.shoppingWeb.shoppingWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

//    @PostMapping("/checkout")
//    public String processCheckout() {
//        // Implement your checkout logic here
//
//        return "redirect:/checkout/success"; // Redirect to a success page
//    }
//    @GetMapping("/shipping-info")
//    public String showShippingInfoPage() {
//        return "shipping_info"; // Return the shipping_info
//    }
//    @PostMapping("/addcart")
//    public String AddToCart(Integer pid, Integer amount, HttpSession session){
//        Integer uid =(int) session.getAttribute("uid");
//        String username =(String) session.getAttribute("username");
//        cartService.AddToCart(uid, username, pid, amount);
//        return "shopping cart modification success!";
//    }
    @PostMapping("/addcart")
    public ResponseEntity<Map<String, String>> AddToCart(Integer pid, Integer amount, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        String username = (String) session.getAttribute("username");

        try {
            // Call cartService method to add the item to the cart
            cartService.AddToCart(uid, username, pid, amount);


            // Return a success response
            Map<String, String> response = new HashMap<>();
            response.put("status", "200");
            response.put("message", "Add to cart successful");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return an error response
            Map<String, String> response = new HashMap<>();
            response.put("status", "500");
            response.put("message", "Failed to add item to the cart");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/")
    public List<CartVO> getByUid(HttpSession session) {

        //Using session to check the uid (user id)
        Integer uid =(int) session.getAttribute("uid");

        return cartService.GetByUid(uid);
    }


    @PostMapping("{cid}/num/add")
    public String addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer uid =(int) session.getAttribute("uid");
        String username =(String) session.getAttribute("username");
        return cartService.AddNum(cid, uid, username);
    }

    @DeleteMapping("/{cid}")
    public String deleteCartItem(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer uid = (int) session.getAttribute("uid");
        String username = (String) session.getAttribute("username");

        cartService.DeleteByCid(cid); // Use the CartService to delete the cart item

        return "Cart item deleted successfully!";
    }

}