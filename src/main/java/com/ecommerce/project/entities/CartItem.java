package com.ecommerce.project.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long cart_id;
    public Long product_id;
    public int quantity;
    @CreationTimestamp
    public Date created_at;
    @UpdateTimestamp
    public Date updated_at;
}
