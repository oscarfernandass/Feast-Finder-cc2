package com.example.feastfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.feastfinder.model.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Integer>{
    Menu findByFoodName(String foodName);
    @Query("select m from Menu m where m.price=?1")
    List<Menu> findByPriceGreaterThan(int price);
}
