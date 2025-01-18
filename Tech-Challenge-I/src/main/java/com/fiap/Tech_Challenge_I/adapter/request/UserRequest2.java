package com.fiap.Tech_Challenge_I.adapter.request;

import com.fiap.Tech_Challenge_I.core.domain.Role.UserRoleEnum;
import com.fiap.Tech_Challenge_I.core.domain.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest2 {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean admin;
    private UserTypeEnum tipoUsuario;
    private String doc;

    private String login;
    private String password;
    private UserRoleEnum role;

    public UserRequest2(int id) {
        this.id = id;
    }

    public UserRequest2(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = UserRoleEnum.customer;
    }

    public UserRequest2(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = UserRoleEnum.valueOf(role);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc.replaceAll("[^a-zA-Z0-9]", "");
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
        return tipoUsuario;
    }

    public void setUserType(UserTypeEnum userType) {
        this.tipoUsuario = userType;
    }
}
