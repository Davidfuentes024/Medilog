package com.example.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Paciente;

public interface GestionPacientesInterface {

    void crearPaciente(Paciente paciente);

    Paciente obtenerPaciente(String nombrePaciente);

    ListaSimple<Paciente> obtenerTodosPacientes();

    void actualizarPaciente(Paciente paciente);

    void eliminarPaciente(Long nombrePaciente);

    void guardarPacientesEnJSON(String rutaArchivo);

    void cargarPacientesDesdeJSON(String rutaArchivo);
}
