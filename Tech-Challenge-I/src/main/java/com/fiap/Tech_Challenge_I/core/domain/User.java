package com.fiap.Tech_Challenge_I.core.domain;

public class User{

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean admin;
    private UserTypeEnum tipoUsuario;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.admin = false;
    }

    public User(String firstName, String lastName, String email, boolean admin, UserTypeEnum tipoUsuario) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.admin = admin;
        this.tipoUsuario = tipoUsuario;
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
        return tipoUsuario;
    }

    public void setTipoUsuario(UserTypeEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
