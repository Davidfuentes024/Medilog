package com.example.Model;

public class Cita {

    private String especialidad;
    private Profesional profesionalAsignado;
    private String motivoCita;

    public Cita(String especialidad, String motivoCita, Profesional profesionalAsignado) {
        this.especialidad = especialidad;
        this.profesionalAsignado = profesionalAsignado;
        this.motivoCita = motivoCita;
       
    }

    public String generarTicket(String turno) {
        return especialidad + " - " + motivoCita + " - " + turno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Profesional getProfesionalAsignado() {
        return profesionalAsignado;
    }

    public void setProfesionalAsignado(Profesional profesionalAsignado) {
        this.profesionalAsignado = profesionalAsignado;
    }

}
