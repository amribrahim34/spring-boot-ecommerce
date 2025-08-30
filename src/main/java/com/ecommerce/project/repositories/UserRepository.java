package com.ecommerce.project.repositories;


import com.ecommerce.project.entities.User;
import org.springframework.stereotype.Repository;

public interface UserRepository extends Repository{
    User save(User user);

}
