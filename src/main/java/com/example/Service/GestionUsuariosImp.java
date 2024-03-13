package com.example.Service;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class GestionUsuariosImp extends UnicastRemoteObject implements GestionUsuariosInterface {
    private ListaSimple<Usuario> listaUsuarios;
    private Gson gson;

    public GestionUsuariosImp() throws RemoteException {
        this.listaUsuarios = new ListaSimple<>();
        this.gson = new Gson();
    }

    @Override
    public void guardarUsuariosEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(listaUsuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargarUsuariosDesdeJSON(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Type tipoListaUsuarios = new TypeToken<List<Usuario>>() {
            }.getType();
            listaUsuarios = gson.fromJson(reader, tipoListaUsuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerUsuario'");
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
