package com.example.vistas;

import javax.swing.*;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Service.GestionColasTickets;
import com.example.Service.GestionPacientesImp;
import com.example.Service.GestionProfesionales;
import com.example.Service.GestionTickets;
import com.example.Service.GestionUsuariosImp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame {

    private GestionPacientesImp gestionPacientesImp = new GestionPacientesImp();
    private GestionProfesionales gestionProfesionales = new GestionProfesionales();
    private GestionColasTickets gestionColasTickets = new GestionColasTickets();
    private GestionTickets gestionTickets = new GestionTickets();
    private GestionUsuariosImp gestionUsuariosImp = new GestionUsuariosImp();

    private ListaSimple pacientes;
    private ListaSimple profesionales;
    private ListaSimple colasTickects;
    private ListaSimple tickets;
    private ListaSimple usuarios;

    public AdminFrame() {
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gestionPacientesImp.cargarPacientesDesdeJSON("pacientes.json");
        gestionColasTickets.cargarColasDesdeJSON("cola_tickets.json");
        gestionProfesionales.cargarProfesionalesDesdeJSON("profesionales.json");
        gestionTickets.cargarTicketsDesdeJSON("tickets.json");
        gestionUsuariosImp.cargarUsuariosDesdeJSON("usuarios.json");

        pacientes = gestionPacientesImp.getListaPacientes();
        profesionales = gestionProfesionales.obtenerTodosProfesionales();
        colasTickects = gestionColasTickets.getMotivosCitas();
        tickets = gestionTickets.obtenerTickets();
        usuarios = gestionUsuariosImp.obtenerTodosUsuarios();

        // Crear panel para los botones con espacio vertical
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10)); // Espacio vertical de 10 pixels entre botones

        // Botones para acceder a cada gestión
        JButton btnPacientes = new JButton("Gestión de Pacientes");
        btnPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir la gestión de pacientes
            }
        });
        panelBotones.add(btnPacientes);

        JButton btnProfesionales = new JButton("Gestión de Profesionales");
        btnProfesionales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir la gestión de profesionales
            }
        });
        panelBotones.add(btnProfesionales);

        JButton btnColas = new JButton("Gestión de Colas de Tickets");
        btnColas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir la gestión de colas de tickets
            }
        });
        panelBotones.add(btnColas);

        JButton btnTickets = new JButton("Gestión de Tickets");
        btnTickets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir la gestión de tickets
            }
        });
        panelBotones.add(btnTickets);

        JButton btnUsuarios = new JButton("Gestión de Usuarios");
        btnUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes abrir la gestión de usuarios
            }
        });
        panelBotones.add(btnUsuarios);

        // Agregar el panel de botones al frame
        add(panelBotones);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        AdminFrame adminFrame = new AdminFrame();
    }
}
