package com.example.Service;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Paciente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class GestionPacientesImp implements GestionPacientesInterface {

    private ListaSimple<Paciente> listaPacientes;
    private Gson gson;

    public GestionPacientesImp() {
        this.listaPacientes = new ListaSimple<>();
        this.gson = new Gson();
    }

    @Override
    public void guardarPacientesEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(listaPacientes.toArray(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargarPacientesDesdeJSON(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Type tipoListaPacientes = new TypeToken<List<Paciente>>() {
            }.getType();
            List<Paciente> pacientes = gson.fromJson(reader, tipoListaPacientes);

            // Limpiar la lista actual antes de cargar los pacientes
            listaPacientes = new ListaSimple<>();

            // Agregar los pacientes a la lista
            for (Paciente paciente : pacientes) {
                listaPacientes.append(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearPaciente(Paciente paciente) {
        listaPacientes.append(paciente);
        guardarPacientesEnJSON("pacientes.json");
    }

    @Override
    public Paciente obtenerPaciente(String nombrePaciente) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente paciente = listaPacientes.getElementAt(i);
            if (paciente.getNombres().equals(nombrePaciente)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public ListaSimple<Paciente> obtenerTodosPacientes() {
        return listaPacientes;
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente pacienteExistente = listaPacientes.getElementAt(i);
            if (pacienteExistente.getId() == paciente.getId()) {
                listaPacientes.delete_at(i);
                listaPacientes.insert(paciente, i);
                break;
            }
        }
        guardarPacientesEnJSON("pacientes.json");
    }

    @Override
    public void eliminarPaciente(Long idPaciente) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente paciente = listaPacientes.getElementAt(i);
            if (paciente.getId() == idPaciente) {
                listaPacientes.delete_at(i);
                break;
            }
        }
        guardarPacientesEnJSON("pacientes.json");
    }
}
