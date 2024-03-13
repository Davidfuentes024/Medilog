package com.example.Model;

import com.example.EstructurasDeDatos.ListaSimple;

public class SistemaGestionUsuario {
    private ListaSimple<Usuario> listaUsuarios;

    public SistemaGestionUsuario() {
        this.listaUsuarios = new ListaSimple<>();
    }

    // Métodos
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.append(usuario);
    }

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        int indice = 0;
        while (indice < listaUsuarios.size()) {
            Usuario usuario = listaUsuarios.getElementAt(indice);
            if (usuario.getUsername().equals(nombreUsuario) && usuario.getPassword().equals(contraseña)) {
                return true;
            }
            indice++;
        }
        return false;
    }
}
