package com.ecommerce.project.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name_ar;
    public String name_en;
    public String description_ar;
    public String description_en;
    public BigDecimal price;
    public boolean is_active;
    @CreationTimestamp
    public Date created_at;
    @UpdateTimestamp
    public Date updated_at;
    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    public Product(Long id ,String name_ar, String name_en, String description_ar, String description_en, BigDecimal price, boolean is_active, Date created_at, Date updated_at , Category category) {
        this.id = id;
        this.name_ar = name_ar;
        this.name_en = name_en;
        this.description_ar = description_ar;
        this.description_en = description_en;
        this.price = price;
        this.category = category;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id=id;}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getDescription_ar() {
        return description_ar;
    }

    public void setDescription_ar(String description_ar) {
        this.description_ar = description_ar;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
