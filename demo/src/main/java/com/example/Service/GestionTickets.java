package com.example.Service;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Ticket;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class GestionTickets {

    private ListaSimple<Ticket> listaTickets;
    private Gson gson;

    public GestionTickets() {
        this.listaTickets = new ListaSimple<>();
        this.gson = new Gson();
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.append(ticket);
        guardarTicketsEnJSON("tickets.json");
    }

    public void eliminarTicket(String idTicket) {
        int tamaño = listaTickets.size();
        for (int i = 0; i < tamaño; i++) {
            Ticket ticket = listaTickets.getElementAt(i);
            if (ticket.getIdentificador().equals(idTicket)) {
                listaTickets.delete_at(i);
                break;
            }
        }

        // Obtenemos el tamaño de la lista 
        int tamañoLista = listaTickets.size();

        // Iteramos sobre la lista de 
        for (int i = 0; i < tamaño; i++) {
            // Aquí se puede realizar alguna operación con cada elemento
        }

        guardarTicketsEnJSON("tickets.json");
    }

    public Ticket buscarTicket(String idTicket) {
        for (int i = 0; i < listaTickets.size(); i++) {
            Ticket ticket = listaTickets.getElementAt(i);
            if (ticket.getIdentificador().equals(idTicket)) {
                return ticket;
            }
        }
        return null;
    }

    public ListaSimple<Ticket> obtenerTickets() {
        return listaTickets;
    }

    public void guardarTicketsEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            JsonArray ticketsArray = new JsonArray();
            for (int i = 0; i < listaTickets.size(); i++) {
                Ticket ticket = listaTickets.getElementAt(i);
                ticketsArray.add(gson.toJsonTree(ticket));
            }
            gson.toJson(ticketsArray, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarTicketsDesdeJSON(String rutaArchivo) {
        try (Reader reader = new FileReader(rutaArchivo)) {
            JsonArray ticketsArray = gson.fromJson(reader, JsonArray.class);
            if (ticketsArray != null) {
                for (int i = 0; i < ticketsArray.size(); i++) {
                    Ticket ticket = gson.fromJson(ticketsArray.get(i), Ticket.class);
                    listaTickets.append(ticket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
