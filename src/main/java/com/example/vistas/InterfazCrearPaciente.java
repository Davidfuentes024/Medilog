package com.example.vistas;

import com.example.Model.Paciente;
import com.example.Service.GestionPacientesImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearPaciente extends JFrame {
    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField edadField;
    private JTextField identificacionField;
    private JTextField numeroTelefonoField;
    private JButton crearPacienteButton;

    private GestionPacientesImp gestionPacientes;

    public InterfazCrearPaciente(GestionPacientesImp gestionPacientes) {
        this.gestionPacientes = gestionPacientes;

        setTitle("Crear Paciente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        nombresField = new JTextField();
        apellidosField = new JTextField();
        edadField = new JTextField();
        identificacionField = new JTextField();
        numeroTelefonoField = new JTextField();
        crearPacienteButton = new JButton("Crear Paciente");

        panel.add(new JLabel("Nombres:"));
        panel.add(nombresField);
        panel.add(new JLabel("Apellidos:"));
        panel.add(apellidosField);
        panel.add(new JLabel("Edad:"));
        panel.add(edadField);
        panel.add(new JLabel("Identificación:"));
        panel.add(identificacionField);
        panel.add(new JLabel("Número de Teléfono:"));
        panel.add(numeroTelefonoField);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(crearPacienteButton);

        crearPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la información ingresada por el usuario
                String nombres = nombresField.getText();
                String apellidos = apellidosField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String identificacion = identificacionField.getText();
                String numeroTelefono = numeroTelefonoField.getText();

                // Crear un nuevo paciente
                Paciente paciente = new Paciente(nombres, apellidos, edad, identificacion, numeroTelefono);

                // Agregar el paciente a la gestión de pacientes
                gestionPacientes.crearPaciente(paciente);

                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(InterfazCrearPaciente.this, "Paciente creado exitosamente");

                // Limpiar los campos de texto
                limpiarCampos();
            }
        });

        add(panel);
    }

    private void limpiarCampos() {
        nombresField.setText("");
        apellidosField.setText("");
        edadField.setText("");
        identificacionField.setText("");
        numeroTelefonoField.setText("");
    }
}
