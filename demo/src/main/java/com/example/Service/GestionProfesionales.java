package com.example.Service;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Profesional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class GestionProfesionales {

    private ListaSimple<Profesional> listaProfesionales;
    private Gson gson;

    public GestionProfesionales() {
        this.listaProfesionales = new ListaSimple<>();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void guardarProfesionalesEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(listaProfesionales.toArray(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarProfesionalesDesdeJSON(String rutaArchivo) {
        try (Reader reader = new FileReader(rutaArchivo)) {
            Type tipoListaProfesionales = new TypeToken<List<Profesional>>() {}.getType();
            List<Profesional> profesionales = gson.fromJson(reader, tipoListaProfesionales);
            for (Profesional profesional : profesionales) {
                listaProfesionales.append(profesional);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearProfesional(Profesional profesional) {
        listaProfesionales.append(profesional);
        guardarProfesionalesEnJSON("profesionales.json");
    }

    public Profesional obtenerProfesional(String nombreProfesional) {
        int tamaño = listaProfesionales.size();
        for (int i = 0; i < tamaño; i++) {
            Profesional profesional = listaProfesionales.getElementAt(i);
            if (profesional.getNombre().equals(nombreProfesional)) {
                return profesional;
            }
        }
        return null;
    }

    public ListaSimple<Profesional> obtenerTodosProfesionales() {
        return listaProfesionales;
    }

    public void actualizarProfesional(Profesional profesional) {
        int tamaño = listaProfesionales.size();
        for (int i = 0; i < tamaño; i++) {
            Profesional profesionalExistente = listaProfesionales.getElementAt(i);
            if (profesionalExistente.getId() == profesional.getId()) {
                listaProfesionales.delete_at(i);
                listaProfesionales.insert(profesional, i);
                break;
            }
        }
        guardarProfesionalesEnJSON("profesionales.json");
    }

    public void eliminarProfesional(int idProfesional) {
        int tamaño = listaProfesionales.size();
        for (int i = 0; i < tamaño; i++) {
            Profesional profesional = listaProfesionales.getElementAt(i);
            if (profesional.getId() == idProfesional) {
                listaProfesionales.delete_at(i);
                break;
            }
        }
        guardarProfesionalesEnJSON("profesionales.json");
    }

    
}
