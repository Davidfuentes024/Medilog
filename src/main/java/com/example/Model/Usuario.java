package com.example.Model;

public class Usuario {

    private String username;
    private String password;
    private int rol;

    public Usuario(String username, String password, int rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public boolean autenticar() {
        return false;
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

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    };

}
