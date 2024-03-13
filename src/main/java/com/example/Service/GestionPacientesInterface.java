package com.example.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Paciente;

public interface GestionPacientesInterface extends Remote {

    void crearPaciente(Paciente paciente) throws RemoteException;

    Paciente obtenerPaciente(String nombrePaciente) throws RemoteException;

    ListaSimple<Paciente> obtenerTodosPacientes() throws RemoteException;

    void actualizarPaciente(Paciente paciente) throws RemoteException;

    void eliminarPaciente(Long nombrePaciente) throws RemoteException;

    void guardarPacientesEnJSON(String rutaArchivo) throws RemoteException;

    void cargarPacientesDesdeJSON(String rutaArchivo) throws RemoteException;
}
