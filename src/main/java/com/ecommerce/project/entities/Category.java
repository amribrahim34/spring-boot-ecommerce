package com.ecommerce.project.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@SoftDelete
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name_ar;
    String name_en;
    String image_url;
//    Long category_id;
    @CreationTimestamp
    public LocalDateTime created_at;
    @UpdateTimestamp
    public LocalDateTime updated_at;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category parent;
//    @OneToMany(mappedBy = "parent")
//    private List<Category> children ;
//    = new ArrayList<>()

    public Category(String name_ar, String name_en, String image_url,  Category parent) {
        this.name_ar = name_ar;
        this.name_en = name_en;
        this.image_url = image_url;
        this.parent = parent;
    }
    public Category(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public void addChild(Category child) {
//        children.add(child);
//        child.setParent(this);
//    }
//
//    public void removeChild(Category child) {
//        children.remove(child);
//        child.setParent(null);
//    }

    public Category getParent() { return parent; }
    public void setParent(Category parent) { this.parent = parent; }
//    public List<Category> getChildren() { return children; }
//    public void setChildren(List<Category> children) { this.children = children; }
}
