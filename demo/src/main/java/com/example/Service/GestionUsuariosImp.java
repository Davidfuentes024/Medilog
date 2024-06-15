package com.example.Service;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Usuario;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;

public class GestionUsuariosImp implements GestionUsuariosInterface {
    private ListaSimple<Usuario> listaUsuarios;
    private Gson gson;

    public GestionUsuariosImp() {
        this.listaUsuarios = new ListaSimple<>();
        this.gson = new Gson();
    }

    @Override
    public void guardarUsuariosEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(listaUsuarios.toArray(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargarUsuariosDesdeJSON(String rutaArchivo) {
        try (Reader reader = new FileReader(rutaArchivo)) {
            Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
                    listaUsuarios.append(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        listaUsuarios.append(usuario);
        guardarUsuariosEnJSON("usuarios.json");
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        int tamaño = listaUsuarios.size();
        for (int i = 0; i < tamaño; i++) {
            Usuario usuario = listaUsuarios.getElementAt(i);
            if (usuario.getUsername().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean validarCredenciales(String nombreUsuario, String contraseña) {
        try {
            // Obtener el usuario correspondiente al nombre de usuario proporcionado
            Usuario usuario = obtenerUsuario(nombreUsuario);
            // Verificar si el usuario existe y si la contraseña coincide
            return usuario != null && usuario.getPassword().equals(contraseña);
        } catch (Exception e) {
            // Manejar la excepción aquí (por ejemplo, imprimir un mensaje de error)
            System.err.println("Error al validar credenciales: " + e.getMessage());
            return false; // Retornar false en caso de excepción
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        int tamaño = listaUsuarios.size();
        for (int i = 0; i < tamaño; i++) {
            Usuario usuarioExistente = listaUsuarios.getElementAt(i);
            if (usuarioExistente.getUsername() == usuario.getUsername()) {
                listaUsuarios.delete_at(i);
                listaUsuarios.insert(usuario, i);
                break;
            }
        }
        guardarUsuariosEnJSON("usuarios.json");
    }

    public void eliminarUsuario(String username) {
        int tamaño = listaUsuarios.size();
        for (int i = 0; i < tamaño; i++) {
            Usuario usuario = listaUsuarios.getElementAt(i);
            if (usuario.getUsername() == username) {
                listaUsuarios.delete_at(i);
                break;
            }
        }
        guardarUsuariosEnJSON("usuarios.json");
    }

    public ListaSimple<Usuario> obtenerTodosUsuarios() {
        return listaUsuarios;
    }

}
