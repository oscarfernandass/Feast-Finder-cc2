package com.example.feastfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feastfinder.model.Cart;
import com.example.feastfinder.repository.CartRepo;



@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    public Cart addItem(Cart cart){
        return cartRepo.save(cart);
    }

    public void deleteItem(int id){
        cartRepo.deleteById(id);
    }

    public List<Cart> getAllItems(){
        return cartRepo.findAll();
    }

    public Cart getItemById(int id){
        return cartRepo.findById(id).orElse(null);
    }

}