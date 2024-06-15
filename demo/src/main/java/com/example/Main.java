package com.example;

import com.example.Model.Ticket;
import com.example.Service.GestionColasTickets;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo JSON con las colas de tickets
        String rutaArchivo = "cola_tickets.json";

        // Crear una instancia de GestionColasTickets
        GestionColasTickets gestionColasTickets = new GestionColasTickets();

        // Cargar las colas desde el archivo JSON
        gestionColasTickets.cargarColasDesdeJSON(rutaArchivo);

        // Imprimir información de las colas cargadas
        System.out.println("Colas de tickets cargadas desde el archivo JSON:");

    }
}
