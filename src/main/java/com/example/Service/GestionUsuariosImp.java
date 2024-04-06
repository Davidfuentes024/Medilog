package com.example.Service;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Type tipoListaUsuarios = new TypeToken<List<Usuario>>() {
            }.getType();
            List<Usuario> usuarios = gson.fromJson(reader, tipoListaUsuarios);

            // Limpiar la lista actual antes de cargar los usuarios
            listaUsuarios = new ListaSimple<>();

            // Agregar los usuarios a la lista
            for (Usuario usuario : usuarios) {
                listaUsuarios.append(usuario);
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

    @Override
    public ListaSimple<Usuario> obtenerTodosUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosUsuarios'");
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarUsuario'");
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuario'");
    }

}
