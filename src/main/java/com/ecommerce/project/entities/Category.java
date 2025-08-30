package com.ecommerce.project.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name_ar;
    String name_en;
    String image_url;
    Long category_id;
    @CreationTimestamp
    public Date created_at;
    @UpdateTimestamp
    public Date updated_at;

    public Category(String name_ar, String name_en, String image_url, Long category_id) {
        this.name_ar = name_ar;
        this.name_en = name_en;
        this.image_url = image_url;
        this.category_id = category_id;
    }

    public Long getId() {
        return id;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
