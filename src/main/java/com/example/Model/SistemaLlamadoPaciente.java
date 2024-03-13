package com.example.Model;

import com.example.EstructurasDeDatos.Cola;

public class SistemaLlamadoPaciente {
    public static void mostrarProximoPacientePorEspecialidad(Cola<Ticket> colaEspera, String especialidad) {
        Cola<Ticket> colaTemporal = new Cola<>(); // Creamos una cola temporal para almacenar los elementos extraídos
        boolean encontrado = false;

        // Iteramos sobre la cola original para buscar el próximo paciente por
        // especialidad
        while (!colaEspera.estaVacia()) {
            Ticket ticket = colaEspera.dequeue(); // Extraemos el primer elemento de la cola original
            colaTemporal.enqueue(ticket); // Añadimos el elemento extraído a la cola temporal

            // Verificamos si el ticket pertenece a la especialidad deseada
            if (ticket.getEspecialidad().equals(especialidad)) {
                System.out.println("Próximo paciente para " + especialidad + ": " + ticket.getIdentificador());
                encontrado = true;
                break; // Salimos del bucle una vez que encontramos el próximo paciente para la
                       // especialidad
            }
        }

        // Restauramos la cola original reinsertando los elementos de la cola temporal
        while (!colaTemporal.estaVacia()) {
            colaEspera.enqueue(colaTemporal.dequeue());
        }

        // Si no se encontró ningún paciente para la especialidad, mostramos un mensaje
        if (!encontrado) {
            System.out.println("No hay pacientes en espera para " + especialidad);
        }
    }
}
