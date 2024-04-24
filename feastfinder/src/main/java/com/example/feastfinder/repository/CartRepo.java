package com.example.feastfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.feastfinder.model.Cart;



@Repository
public interface CartRepo extends JpaRepository <Cart,Integer>{
    
}
