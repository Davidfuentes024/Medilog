package com.example.Model;

public class Orden {

    private static int contadorId = 0; // Contador estático para generar IDs automáticos
    private int id;
    private String tipoExamen;
    private int idPaciente;
    private double costoExamen;
    private String descripcion;
    private boolean estadoAutorizacion;

    public Orden(String tipoExamen, int idPaciente, double costoExamen, String descripcion,
            boolean estadoAutorizacion) {
        this.id = ++contadorId; // Generar un nuevo ID automáticamente
        this.tipoExamen = tipoExamen;
        this.idPaciente = idPaciente;
        this.costoExamen = costoExamen;
        this.descripcion = descripcion;
        this.estadoAutorizacion = estadoAutorizacion;
    }

    public Orden(int id, String tipoExamen, int idPaciente, double costoExamen, String descripcion,
            boolean estadoAutorizacion) {
        this.id = id;
        this.tipoExamen = tipoExamen;
        this.idPaciente = idPaciente;
        this.costoExamen = costoExamen;
        this.descripcion = descripcion;
        this.estadoAutorizacion = estadoAutorizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public double getCostoExamen() {
        return costoExamen;
    }

    public void setCostoExamen(double costoExamen) {
        this.costoExamen = costoExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstadoAutorizacion() {
        return estadoAutorizacion;
    }

    public void setEstadoAutorizacion(boolean estadoAutorizacion) {
        this.estadoAutorizacion = estadoAutorizacion;
    }

}
