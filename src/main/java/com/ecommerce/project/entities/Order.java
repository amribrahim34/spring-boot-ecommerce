package com.ecommerce.project.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long user_id;
    public BigDecimal total;
    @CreationTimestamp
    public Date created_at;
    @UpdateTimestamp
    public Date updated_at;

}
