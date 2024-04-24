package com.example.feastfinder.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feastfinder.model.Cart;
import com.example.feastfinder.service.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/showall")
    public List<Cart> showAll() {
        return cartService.getAllItems();
    }

    @PostMapping ("/additem")
    public Cart addItem(@RequestBody Cart cart){
        return cartService.addItem(cart);
    }

    @GetMapping ("/getitem/{id}")
    public Cart getItemById(@PathVariable ("id") int id){
        return cartService.getItemById(id);
    }

    @DeleteMapping ("/deleteitem/{id}")
    public String deleteItemById(@PathVariable ("id") int id){
        Cart cartItemExists = cartService.getItemById(id);
        if(cartItemExists != null){
            cartService.deleteItem(id);
            return "Cart Item deleted Successfully";
        }
        return "Cart Item not found";
    }

    @PutMapping ("/update/{id}")
    public String updateItem(@PathVariable ("id") int id, @RequestBody Cart newCart){
        Cart oldCart = cartService.getItemById(id);
        if(oldCart != null){
            String newName = newCart.getFoodName();
            int newQuantity = newCart.getQuantity();
            int newPrice = newCart.getPrice();

            oldCart.setFoodName(newName);
            oldCart.setPrice(newPrice);
            oldCart.setQuantity(newQuantity);

            cartService.addItem(oldCart);
            return "Cart Item updated Successfully";
        }
        return "Item not found, Cannot be updated";
    }

    
}
