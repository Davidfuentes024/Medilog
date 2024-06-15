package com.example.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.example.EstructurasDeDatos.Cola;
import com.example.EstructurasDeDatos.HashMapImplementation;
import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Ticket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GestionColasTickets {

    private HashMapImplementation<String, Cola<Ticket>> colaTicketsPorMotivo;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GestionColasTickets() {
        colaTicketsPorMotivo = new HashMapImplementation<>();
    }

    public void encolarTicket(Ticket ticket) {
        // Obtenemos el motivo de la cita del ticket
        String motivoCita = ticket.getMotivoCita();

        // Verificamos si ya existe una cola para el motivo de la cita
        if (!colaTicketsPorMotivo.containsKey(motivoCita)) {
            // Si no existe, creamos una nueva cola y la asociamos al motivo de la cita en
            // el mapa
            colaTicketsPorMotivo.put(motivoCita, new Cola<>());
        }

        // Obtenemos la cola correspondiente al motivo de la cita
        Cola<Ticket> colaTickets = colaTicketsPorMotivo.get(motivoCita);

        // Encolamos el ticket en la cola correspondiente
        colaTickets.enqueue(ticket);
    }

    public void desencolarTicket(String motivo) {
        // Verificamos si existe una cola para el motivo dado
        if (colaTicketsPorMotivo.containsKey(motivo)) {
            // Si existe, obtenemos la cola correspondiente
            Cola<Ticket> colaTickets = colaTicketsPorMotivo.get(motivo);

            // Verificamos si la cola no está vacía
            if (!colaTickets.estaVacia()) {
                // Si no está vacía, desencolamos el próximo ticket
                colaTickets.dequeue();

                // Luego de desencolar, podríamos guardar las colas actualizadas en un archivo
                // JSON
                guardarColaEnJSON();
            }
        }
    }

    public Cola<Ticket> getColaPorMotivo(String motivo) {
        return colaTicketsPorMotivo.get(motivo);
    }

    public ListaSimple<String> getMotivosCitas() {
        return colaTicketsPorMotivo.keySet();
    }

    public void guardarColaEnJSON() {
        Map<String, Ticket[]> ticketsPorMotivo = new HashMap<>();
        for (String motivo : colaTicketsPorMotivo.keySet()) {
            Cola<Ticket> colaTickets = colaTicketsPorMotivo.get(motivo);
            Object[] objTickets = colaTickets.toArray();
            Ticket[] tickets = new Ticket[objTickets.length];
            try {
                for (int i = 0; i < objTickets.length; i++) {
                    tickets[i] = (Ticket) objTickets[i];
                }
            } catch (ClassCastException e) {
                // Manejar la excepción
                e.printStackTrace();
            }

            ticketsPorMotivo.put(motivo, tickets);
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("cola_tickets.json"), StandardCharsets.UTF_8)) {
            gson.toJson(ticketsPorMotivo, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarColasDesdeJSON(String rutaArchivo) {
        try (Reader reader = new InputStreamReader(new FileInputStream(rutaArchivo), StandardCharsets.UTF_8)) {
            JsonObject jsonColas = gson.fromJson(reader, JsonObject.class);
            for (Map.Entry<String, JsonElement> entry : jsonColas.entrySet()) {
                String motivo = entry.getKey();
                JsonArray jsonArray = entry.getValue().getAsJsonArray();
                ListaSimple<Ticket> ticketsList = new ListaSimple<>();
                for (JsonElement jsonElement : jsonArray) {
                    Ticket ticket = gson.fromJson(jsonElement, Ticket.class);
                    ticketsList.append(ticket);
                }
                Cola<Ticket> colaTickets = new Cola<>();
                for (Ticket ticket : ticketsList) {
                    colaTickets.enqueue(ticket);
                }
                colaTicketsPorMotivo.put(motivo, colaTickets);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imprimirColas() {
        System.out.println("Contenido de las colas de tickets:");

        for (String motivo : colaTicketsPorMotivo.keySet()) {
            System.out.println("Motivo de cita: " + motivo);
            Cola<Ticket> cola = colaTicketsPorMotivo.get(motivo);
            if (cola != null) {
                System.out.println("Tickets:");
                Cola<Ticket> copiaCola = new Cola<>(); // Creamos una copia para no modificar la original
                while (!cola.estaVacia()) {
                    Ticket ticket = cola.dequeue();
                    System.out.println(ticket);
                    copiaCola.enqueue(ticket); // Volvemos a encolar el ticket en la cola original
                }
                colaTicketsPorMotivo.put(motivo, copiaCola); // Restauramos la cola original
            } else {
                System.out.println("No hay tickets para este motivo de cita.");
            }
        }
    }
}
