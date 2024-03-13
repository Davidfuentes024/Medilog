package com.example.EstructurasDeDatos;

public class Cola<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void enqueue(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public T dequeue() {
        if (cabeza == null) {
            return null;
        }
        T valor = cabeza.getValor();
        cabeza = cabeza.getSiguiente();
        if (cabeza == null) {
            cola = null;
        }
        tamaño--;
        return valor;
    }

    public T peek() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.getValor();
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int size() {
        return tamaño;
    }

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        public Nodo(T valor) {
            this(valor, null, null);
        }

        public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }

        public T getValor() {
            return valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

    }
}
