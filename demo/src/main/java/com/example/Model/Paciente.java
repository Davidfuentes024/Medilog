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
    private int idHistoriaClinica;
    private ListaSimple<Orden> ordenes = new ListaSimple<>();
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Paciente(String nombres, String apellidos, int edad, String identificacion, String numeroTelefono) {
        this.id = generarId();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.identificacion = identificacion;
        this.numeroTelefono = numeroTelefono;
        this.idHistoriaClinica = this.id;
        ticket = null;
    }

    public Paciente(int id, String nombres, String apellidos, int edad, String identificacion, String numeroTelefono,
            int idHistoriaClinica) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.identificacion = identificacion;
        this.numeroTelefono = numeroTelefono;
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    private int generarId() {
        contadorId++;
        return contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ListaSimple<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ListaSimple ordenes) {
        this.ordenes = ordenes;
    }

    public Orden[] getOrdenesArray() {
        if (ordenes.isEmpty()) {
            return new Orden[0]; // Devuelve un array vacío si no hay órdenes
        } else {
            Object[] ordenesObjectArray = ordenes.toArray(); // Convierte la lista de órdenes en un array de Object
            Orden[] ordenesArray = new Orden[ordenesObjectArray.length]; // Crea un nuevo array de tipo Orden
            for (int i = 0; i < ordenesObjectArray.length; i++) {
                ordenesArray[i] = (Orden) ordenesObjectArray[i]; // Convierte cada elemento a tipo Orden
            }
            return ordenesArray; // Devuelve el array de órdenes
        }
    }

}
