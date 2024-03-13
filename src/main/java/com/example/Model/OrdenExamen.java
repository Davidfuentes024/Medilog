package com.example.Model;

public class OrdenExamen {
    private String identificador;
    private String especialidad;
    private String tipoExamen;
    private String idPaciente;
    private double costoExamen;
    private String descripcion;
    private boolean estadoAutorizacion;

    public OrdenExamen(String identificador, String especialidad, String tipoExamen, String idPaciente,
            double costoExamen, String descripcion) {
        this.identificador = identificador;
        this.especialidad = especialidad;
        this.tipoExamen = tipoExamen;
        this.idPaciente = idPaciente;
        this.costoExamen = costoExamen;
        this.descripcion = descripcion;
        this.estadoAutorizacion = false;
    }

    // Métodos
    public void actualizarEstadoAutorizacion() {
        this.estadoAutorizacion = true;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
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
