package com.example.Model;

public class HistoriaClinica {
    private String descripcion;
    private String diagnostico;

    public HistoriaClinica(String descripcion, String diagnostico) {
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
    }

    public String obtenerInformacion() {
        return "Descripción: " + descripcion + "\nDiagnóstico: " + diagnostico;
    }

}
