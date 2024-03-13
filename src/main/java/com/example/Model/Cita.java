package com.example.Model;

public class Cita {

    private String especialidad;
    private String profesionalAsignado;
    private String motivoCita;
    private String idPaciente;
    private boolean estadoPago;
    private double valorConsulta;

    public Cita(String especialidad, String profesionalAsignado, String motivoCita, String idPaciente,
            boolean estadoPago, double valorConsulta) {
        this.especialidad = especialidad;
        this.profesionalAsignado = profesionalAsignado;
        this.motivoCita = motivoCita;
        this.idPaciente = idPaciente;
        this.estadoPago = estadoPago;
        this.valorConsulta = valorConsulta;
    }

    public String generarTicket(String turno) {
        return especialidad + " - " + motivoCita + " - " + turno;
    }

    public void marcarComoPagado() {
        this.estadoPago = true;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getProfesionalAsignado() {
        return profesionalAsignado;
    }

    public void setProfesionalAsignado(String profesionalAsignado) {
        this.profesionalAsignado = profesionalAsignado;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

}
