package com.ecommerce.project.entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long user_id;
    public Date created_at;
    public Date updated_at;
}
