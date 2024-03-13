package com.example.Model;

public class Ticket {
    private String identificador;
    private String especialidad;
    private String motivoCita;
    private String turno;
    private boolean estadoPago;

    public Ticket(String identificador, String especialidad, String motivoCita, String turno, boolean estadoPago) {
        this.identificador = identificador;
        this.especialidad = especialidad;
        this.motivoCita = motivoCita;
        this.turno = turno;
        this.estadoPago = estadoPago;
    }

    // Métodos
    public String generarIdentificador() {
        // Lógica para generar un identificador único para el ticket
        return "T" + Math.random(); // Solo una implementación de ejemplo, no es un método seguro para generar
                                    // identificadores únicos
    }

    public void actualizarEstadoPago() {
        this.estadoPago = true;
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

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

}
