package com.example;

import com.example.Service.GestionPacientesImp;
import com.example.Service.GestionPacientesInterface;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Crear e inicializar el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);

            // Crear una instancia del objeto del servidor
            GestionPacientesInterface gestionPacientes = new GestionPacientesImp();

            // Registrar el objeto del servidor en el registro RMI
            Naming.rebind("//localhost/GestionPacientes", gestionPacientes);

            System.out.println("Servidor RMI iniciado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
