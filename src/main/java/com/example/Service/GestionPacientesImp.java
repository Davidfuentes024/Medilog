package com.example.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Paciente;
import com.example.Model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestionPacientesImp extends UnicastRemoteObject implements GestionPacientesInterface {

    private ListaSimple<Usuario> listaUsuarios;
    private Gson gson;

    public GestionPacientesImp() throws RemoteException {
        this.listaUsuarios = new ListaSimple<>();
        this.gson = new Gson();
    }

    @Override
    public void guardarPacientesEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(listaUsuarios, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargarPacientesDesdeJSON(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Type tipoListaUsuarios = new TypeToken<List<Usuario>>() {
            }.getType();
            listaUsuarios = gson.fromJson(reader, tipoListaUsuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearPaciente(Paciente paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPaciente'");
    }

    @Override
    public Paciente obtenerPaciente(String nombrePaciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPaciente'");
    }

    @Override
    public ListaSimple<Paciente> obtenerTodosPacientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosPacientes'");
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPaciente'");
    }

    @Override
    public void eliminarPaciente(Long nombrePaciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuario'");
    }

}
