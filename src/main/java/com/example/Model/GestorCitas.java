package com.example.Model;

import com.example.EstructurasDeDatos.ListaSimple;

public class GestorCitas {
    private ListaSimple<Cita> listaCitas;

    public GestorCitas() {
        this.listaCitas = new ListaSimple<>();
    }

    public void crearCita(Cita cita) {
        listaCitas.append(cita);
    }

    public ListaSimple<Cita> buscarCitaPorPaciente(String idPaciente) {
        ListaSimple<Cita> citasPorPaciente = new ListaSimple<>();
        int indice = 0;
        while (indice < listaCitas.size()) {
            Cita cita = listaCitas.getElementAt(indice);
            if (cita.getIdPaciente().equals(idPaciente)) {
                citasPorPaciente.append(cita);
            }
            indice++;
        }
        return citasPorPaciente;
    }

    public ListaSimple<Cita> buscarCitaPorEspecialidad(String especialidad) {
        ListaSimple<Cita> citasPorEspecialidad = new ListaSimple<>();
        int indice = 0;
        while (indice < listaCitas.size()) {
            Cita cita = listaCitas.getElementAt(indice);
            if (cita.getEspecialidad().equals(especialidad)) {
                citasPorEspecialidad.append(cita);
            }
            indice++;
        }
        return citasPorEspecialidad;
    }

    public void autorizarExamen(OrdenExamen ordenExamen) {
        // Lógica para autorizar el examen
    }
}
