package com.example.Model;

public class Ticket {
    private String identificador;
    private String motivoCita;
    private int turno;
    private boolean estadoPago;
    private double valor; // Nuevo atributo para almacenar el valor del ticket

    public Ticket(String motivoCita, int turno) {
        this.motivoCita = motivoCita;
        this.turno = turno;
        this.estadoPago = false;
        // Generar el identificador automáticamente
        generarIdentificador();
        // Calcular el valor del ticket automáticamente
        calcularValor();
    }

    public void actualizarEstadoPago() {
        this.estadoPago = true;
    }

    private void generarIdentificador() {
        // Obtener las dos primeras letras del motivo de la cita (especialidad)
        String especialidad = motivoCita.substring(0, 2).toUpperCase();
        // Construir el identificador con la especialidad, el tipo de examen y el número
        // de turno
        this.identificador = especialidad + "-" + turno;
    }

    private void calcularValor() {
        // Obtener la especialidad del motivo de la cita
        String especialidad = motivoCita.toUpperCase();
        // Calcular el valor del ticket según la especialidad
        switch (especialidad) {
            case "MEDICINA INTERNA":
            case "MEDICINA FAMILIAR":
            case "PEDIATRÍA":
            case "NEUMOLOGÍA":
            case "GASTROENTEROLOGÍA":
            case "GENÉTICA MÉDICA":
            case "NEUROLOGÍA":
            case "OBSTETRICIA Y GINECOLOGÍA":
                this.valor = 50.0;
                break;
            case "PATOLOGÍA CLÍNICA":
            case "BIOQUÍMICA CLÍNICA":
            case "RADIOLOGÍA":
            case "RADIOTERAPIA":
            case "MEDICINA NUCLEAR":
            case "CARDIOLOGÍA":
            case "OTORRINOLARINGOLOGÍA":
            case "PSIQUIATRÍA":
                this.valor = 70.0;
                break;
            case "MEDICINA GENERAL":
                this.valor = 0.0; // Gratis para medicina general
                break;
            case "MEDICINA DEPORTIVA":
            case "ONCOLOGÍA":
                this.valor = 60.0;
                break;
            case "UROLOGÍA":
                this.valor = 65.0;
                break;
            default:
                this.valor = 100.0; // Precio predeterminado para otras especialidades
                break;
        }
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Identificador: ").append(identificador).append("\n");
        sb.append("Motivo de la cita: ").append(motivoCita).append("\n");
        sb.append("Turno: ").append(turno).append("\n");
        sb.append("Estado de pago: ").append(estadoPago ? "Pagado" : "Pendiente").append("\n");
        sb.append("Valor: ").append(valor).append("\n");
        return sb.toString();
    }

}
