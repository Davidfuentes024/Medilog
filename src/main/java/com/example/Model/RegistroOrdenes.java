package com.example.Model;

import com.example.EstructurasDeDatos.ListaSimple;

public class RegistroOrdenes {
    private ListaSimple<OrdenExamen> listaOrdenes;

    public RegistroOrdenes() {
        this.listaOrdenes = new ListaSimple<>();
    }

    // Métodos
    public void registrarOrdenExamen(OrdenExamen ordenExamen) {
        listaOrdenes.append(ordenExamen);
    }

    public void autorizarExamen(OrdenExamen ordenExamen) {
        ordenExamen.setEstadoAutorizacion(true);
    }
}
