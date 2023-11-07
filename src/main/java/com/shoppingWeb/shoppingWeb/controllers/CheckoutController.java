package com.shoppingWeb.shoppingWeb.controllers;

import com.shoppingWeb.shoppingWeb.entity.CartVO;
import com.shoppingWeb.shoppingWeb.entity.ShippingInfo;
import com.shoppingWeb.shoppingWeb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller
@CrossOrigin(origins = "*")
public class CheckoutController {

    @Autowired
    private CartService cartService;


    @GetMapping("/checkout")
    public String displayCheckoutPage(Model model, HttpSession session) {
        // Retrieve the user's cart items from the session



        // Calculate the total order amount based on cart items
//        double totalAmount = cartService.calculateTotalAmount(cartItems);
//
//        model.addAttribute("cartItems", cartItems);
//        model.addAttribute("totalAmount", totalAmount);

        return "/checkout";
    }


//    @PostMapping("/process")
//    public String processCheckout(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpSession session) {
//        // Validate shipping information
//
//        // Retrieve cart items from the session
//        List<CartVO> cartItems = (List<CartVO>) session.getAttribute("cartItems");
//
//        // Create an order or invoice object
//        Order order = new Order();
//        order.setShippingInfo(shippingInfo);
//        order.setOrderItems(cartItems);
//        order.setTotalAmount(cartService.calculateTotalAmount(cartItems));
//
//        // Save the order to the database (You should have an OrderService for this)
//        orderService.saveOrder(order);
//
//        // Update inventory (You should have a ProductService for this)
//        productService.updateInventory(cartItems);
//
//        // Remove items from the user's cart
//        session.removeAttribute("cartItems");
//
//        // Redirect to a confirmation page
//        return "confirmation";
//    }
}