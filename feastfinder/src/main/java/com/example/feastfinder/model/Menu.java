package com.example.feastfinder.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    
    @Id
    private int foodId;
    private String foodName;
    private String quantityAvailable;
    private int price;
    @OneToOne
    private Signup signup;

    @OneToMany(mappedBy = "menu",cascade= CascadeType.REMOVE)
    
    private List<Cart> Cart;
}
