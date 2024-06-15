package com.example.Model;

public class HistoriaClinica {

    private int id;
    private String descripcion;
    private String diagnostico;

    public HistoriaClinica(int id, String descripcion, String diagnostico) {
        this.id = id;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
    }

    public String obtenerInformacion() {
        return "Id: " + id + "\nDescripción: " + descripcion + "\nDiagnóstico: " + diagnostico;
    }

}
