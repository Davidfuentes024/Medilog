package com.example.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Usuario;

public interface GestionUsuariosInterface extends Remote {

    void crearUsuario(Usuario usuario) throws RemoteException;

    Usuario obtenerUsuario(String nombreUsuario) throws RemoteException;

    ListaSimple<Usuario> obtenerTodosUsuarios() throws RemoteException;

    void actualizarUsuario(Usuario usuario) throws RemoteException;

    void eliminarUsuario(String nombreUsuario) throws RemoteException;

    void guardarUsuariosEnJSON(String rutaArchivo) throws RemoteException;

    void cargarUsuariosDesdeJSON(String rutaArchivo) throws RemoteException;
}
