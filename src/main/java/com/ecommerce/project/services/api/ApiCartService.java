package com.ecommerce.project.services.api;

import com.ecommerce.project.entities.Cart;
import com.ecommerce.project.entities.User;
import com.ecommerce.project.repositories.CartRepository;
import com.ecommerce.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiCartService {

    private CartRepository cartRepository;
    private UserRepository userRepository;

    @Autowired
    public ApiCartService(
            CartRepository cartRepository,
            UserRepository userRepository
    ){
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public Cart getCart(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);
        Long userId = user.get().getId();

        return cartRepository.findByUserId(userId)
                .orElseGet(() -> cartRepository.save(new Cart(userId)));
    }
}
