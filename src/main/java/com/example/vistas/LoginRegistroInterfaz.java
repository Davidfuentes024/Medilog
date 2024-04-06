package com.example.vistas;

import com.example.Model.Usuario;
import com.example.Service.GestionPacientesImp;
import com.example.Service.GestionUsuariosImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class LoginRegistroInterfaz extends JFrame {
    private GestionUsuariosImp gestionUsuarios;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginRegistroInterfaz(GestionUsuariosImp gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
        setTitle("Login / Registro");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Usuario usuario = gestionUsuarios.obtenerUsuario(username);
                if (usuario != null && usuario.getPassword().equals(password)) {
                    if (usuario.getRol() == 1) {
                        // Abrir la interfaz de creación de pacientes si el usuario es de rol 1
                        abrirInterfazCrearPaciente();
                    } else {
                        // Aquí puedes agregar el código para abrir otra interfaz según el rol del
                        // usuario
                        JOptionPane.showMessageDialog(LoginRegistroInterfaz.this,
                                "Login successful, but not implemented for this role");
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginRegistroInterfaz.this, "Invalid username or password");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Usuario usuario = new Usuario(username, password, 1); // Rol 1 para usuarios registrados
                gestionUsuarios.crearUsuario(usuario);
                JOptionPane.showMessageDialog(LoginRegistroInterfaz.this, "User registered successfully");
            }
        });
    }

    private void abrirInterfazCrearPaciente() {
        GestionPacientesImp gestionPacientes = new GestionPacientesImp(); // Asegúrate de tener la implementación de
                                                                          // GestionPacientes
        InterfazCrearPaciente interfazCrearPaciente = new InterfazCrearPaciente(gestionPacientes);
        interfazCrearPaciente.setVisible(true);
        setVisible(false); // Ocultar la ventana de login
    }

    public static void main(String[] args) throws RemoteException {
        GestionUsuariosImp gestionUsuarios = new GestionUsuariosImp();
        LoginRegistroInterfaz interfaz = new LoginRegistroInterfaz(gestionUsuarios);
        interfaz.setVisible(true);
    }
}
