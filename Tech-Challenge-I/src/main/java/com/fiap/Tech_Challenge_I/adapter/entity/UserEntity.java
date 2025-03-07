package com.fiap.Tech_Challenge_I.adapter.entity;

import com.fiap.Tech_Challenge_I.core.domain.UserTypeEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TCDB_USER")
public class UserEntity {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAdmin;
    private UserTypeEnum userType;
    private String doc;

    private String username;
    private String password;
    private boolean enabled;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public UserEntity() {
    }

    public UserEntity(int id) {
        this.id = id;
    }

    public UserEntity(int id, String firstName, String lastName, String email, boolean admin, UserTypeEnum tipoUsuario, String doc, String username, boolean enabled, String role, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isAdmin = admin;
        this.userType = tipoUsuario;
        this.doc = doc;
        this.username = username;
        this.enabled = enabled;
        this.role = role;
        this.password = password;
    }

    public UserEntity(int id, String firstName, String lastName, String email, boolean admin, UserTypeEnum tipoUsuario, String doc, List<OrderEntity> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isAdmin = admin;
        this.userType = tipoUsuario;
        this.doc = doc;
        this.orders = orders;
    }

    public UserEntity(String username, boolean enabled, String password, String role) {
        this.username = username;
        this.enabled = enabled;
        this.password = password;
        this.role = role;
    }



    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc.replaceAll("[^a-zA-Z0-9]", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }
}
