package com.example.Model;

import com.example.EstructurasDeDatos.Cola;

public class ColaEspera {
    private Cola<Ticket> listaTickets;

    public ColaEspera() {
        this.listaTickets = new Cola<>();
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.enqueue(ticket);
    }

    public Ticket obtenerProximoTicket() {
        return listaTickets.dequeue();
    }

    public Cola<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void setListaTickets(Cola<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

}
