package com.example.EstructurasDeDatos;

public interface Lista<T> {
    void append(T valor);

    void prepend(T valor);

    void insert(T valor, int indice);

    T getElementAt(int indice);

    String toString();

    void remove(T valor);

    void delete_at(int indice);

    boolean isEmpty();

    int size();

    void reverse();

    T getHead();

    T getTail();
}
