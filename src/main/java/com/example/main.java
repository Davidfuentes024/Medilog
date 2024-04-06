package com.example;

import com.example.Service.GestionUsuariosImp;
import com.example.vistas.LoginRegistroInterfaz;

public class main {
    public static void main(String[] args) {
        GestionUsuariosImp gestionUsuarios = new GestionUsuariosImp();
        LoginRegistroInterfaz interfaz = new LoginRegistroInterfaz(gestionUsuarios);
        interfaz.setVisible(true);

    }

}
