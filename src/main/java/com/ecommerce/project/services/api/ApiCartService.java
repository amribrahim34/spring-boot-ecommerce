package com.ecommerce.project.services.api;

import com.ecommerce.project.entities.Cart;
import com.ecommerce.project.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiCartService {

    private CartRepository cartRepository;

    @Autowired
    public ApiCartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

//    public Cart getCart(){
//        return cartRepository.findAll();
//    }
}
