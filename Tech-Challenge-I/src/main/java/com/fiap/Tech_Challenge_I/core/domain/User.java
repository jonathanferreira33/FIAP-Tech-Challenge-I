package com.fiap.Tech_Challenge_I.core.domain;

import com.fiap.Tech_Challenge_I.core.domain.Role.UserRoleEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class User{

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean admin;
    private UserTypeEnum userType;
    private String doc;
    private List<Order> orders;

    private String userName;
    private String password;
    private Set<UserRoleEnum> role;
    private boolean enabled;


    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.role = Collections.singleton(UserRoleEnum.guest);
    }

    public User(String userName, String password, UserRoleEnum role) {
        this.userName = userName;
        this.password = password;
        this.role = Collections.singleton(role);
    }

    public User(String firstName, String lastName, String email, String doc) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.doc = doc;
        this.admin = false;
        this.userType = UserTypeEnum.customer;
        this.orders = new ArrayList<>();
        this.role = Collections.singleton(UserRoleEnum.guest);
    }

    public User(int id, String firstName, String lastName, String email, boolean admin, UserTypeEnum userType, String doc, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.admin = admin;
        this.userType = userType;
        this.doc = doc;
        this.orders = orders;
        this.role = Collections.singleton(UserRoleEnum.guest);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRoleEnum> getRoles() {
        return role;
    }

    public void setRoles(Set<UserRoleEnum> roles) {
        this.role = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
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
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public UserTypeEnum getTipoUsuario() {
        return userType;
    }

    public void setTipoUsuario(UserTypeEnum userType) {
        this.userType = userType;
    }
}
