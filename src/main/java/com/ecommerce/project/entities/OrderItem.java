package com.ecommerce.project.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long order_id;
    public Long product_id;
    public int quantity;
    public BigDecimal unit_price;
    public BigDecimal total_price;
    @CreationTimestamp
    public Date created_at;
    @UpdateTimestamp
    public Date updated_at;
}
