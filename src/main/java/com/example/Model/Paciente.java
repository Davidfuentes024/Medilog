package com.example.Model;

import com.example.EstructurasDeDatos.ListaSimple;

public class Paciente {
    private static int contadorId = 0;
    private int id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String identificacion;
    private String numeroTelefono;
    private ListaSimple<HistoriaClinica> historiasClinicas;

    public Paciente(String nombres, String apellidos, int edad, String identificacion, String numeroTelefono) {
        this.id = generarId();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.identificacion = identificacion;
        this.numeroTelefono = numeroTelefono;
        this.historiasClinicas = new ListaSimple<>();
    }

    private int generarId() {
        contadorId++;
        return contadorId;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void agregarHistoriaClinica(HistoriaClinica historiaClinica) {
        historiasClinicas.append(historiaClinica);
    }

    public String obtenerInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nombres: ").append(nombres).append("\n");
        sb.append("Apellidos: ").append(apellidos).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("Identificación: ").append(identificacion).append("\n");
        sb.append("Número de teléfono: ").append(numeroTelefono).append("\n");
        return sb.toString();
    }

    public String obtenerInformacionHistoriasClinicas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Historias Clínicas:\n");
        for (int i = 0; i < historiasClinicas.size(); i++) {
            sb.append(historiasClinicas.getElementAt(i).obtenerInformacion()).append("\n");
        }
        return sb.toString();
    }
}
