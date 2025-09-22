package com.ecommerce.project.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.CredentialsContainer;

import java.util.Date;

@Entity
@Table(name = "users")
public class User implements CredentialsContainer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String name;
    String username;
    String email;
    String password;
    boolean enabled;
    @CreationTimestamp
    public Date created_at;
    @UpdateTimestamp
    public Date updated_at;

    public User(String name, String email, String password,String username,boolean enabled) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.enabled= enabled;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}
