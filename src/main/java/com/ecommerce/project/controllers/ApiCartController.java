package com.ecommerce.project.controllers;

import com.ecommerce.project.entities.Cart;
import com.ecommerce.project.services.api.ApiCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/carts")
public class ApiCartController {
    private final ApiCartService apiCartService;

    @Autowired
    public ApiCartController(ApiCartService apiCartService){
        this.apiCartService = apiCartService;
    }

    @GetMapping
    public Cart getCart(){
        return apiCartService.getCart();
    }
}
