package com.example.EstructurasDeDatos;

public class ListaSimple<T> implements Lista<T> {

    private Nodo<T> cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    @Override
    public void append(T valor) {
        try {
            if (cabeza == null) {
                cabeza = new Nodo<>(valor);
                return;
            }
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<>(valor));
        } catch (Exception e) {
            System.err.println("Error al intentar agregar un valor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void prepend(T valor) {
        try {
            Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza);
            cabeza = nuevoNodo;
        } catch (Exception e) {
            System.err.println("Error al intentar agregar un valor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void insert(T valor, int indice) {
        try {
            if (indice == 0) {
                prepend(valor);
                return;
            }
            Nodo<T> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                if (actual == null) {
                    throw new IndexOutOfBoundsException();
                }
                actual = actual.getSiguiente();
            }
            Nodo<T> nuevoNodo = new Nodo<>(valor, actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Índice fuera de los límites al insertar valor.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error al intentar insertar un valor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public T getElementAt(int indice) {
        try {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < indice; i++) {
                if (actual == null) {
                    throw new IndexOutOfBoundsException();
                }
                actual = actual.getSiguiente();
            }
            return actual.getValor();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Índice fuera de los límites al obtener elemento.");
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Error al intentar obtener un elemento: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            Nodo<T> actual = cabeza;
            while (actual != null) {
                sb.append(actual.getValor());
                if (actual.getSiguiente() != null) {
                    sb.append(" -> ");
                }
                actual = actual.getSiguiente();
            }
            return sb.toString();
        } catch (Exception e) {
            System.err.println("Error al intentar generar la representación en cadena de la lista: " + e.getMessage());
            e.printStackTrace();
            return "Error al intentar generar la representación en cadena de la lista.";
        }
    }

    public int find(T valor) {
        try {
            Nodo<T> actual = cabeza;
            int indice = 0;
            while (actual != null) {
                if (actual.getValor().equals(valor)) {
                    return indice;
                }
                actual = actual.getSiguiente();
                indice++;
            }
            return -1; // Si no se encuentra el valor
        } catch (Exception e) {
            System.err.println("Error al intentar buscar el valor: " + e.getMessage());
            e.printStackTrace();
            return -1; // Manejo de error, devuelve -1 en caso de excepción
        }
    }

    public void remove(T valor) {
        try {
            if (cabeza == null) {
                return;
            }

            if (cabeza.getValor().equals(valor)) {
                cabeza = cabeza.getSiguiente();
                return;
            }

            Nodo<T> anterior = cabeza;
            Nodo<T> actual = cabeza.getSiguiente();

            while (actual != null) {
                if (actual.getValor().equals(valor)) {
                    anterior.setSiguiente(actual.getSiguiente());
                    return;
                }
                anterior = actual;
                actual = actual.getSiguiente();
            }
        } catch (Exception e) {
            System.err.println("Error al intentar eliminar el valor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete_at(int indice) {
        try {
            if (cabeza == null) {
                return;
            }

            if (indice == 0) {
                cabeza = cabeza.getSiguiente();
                return;
            }

            Nodo<T> anterior = null;
            Nodo<T> actual = cabeza;
            int contador = 0;

            while (actual != null && contador < indice) {
                anterior = actual;
                actual = actual.getSiguiente();
                contador++;
            }

            if (actual != null) {
                anterior.setSiguiente(actual.getSiguiente());
            }
        } catch (Exception e) {
            System.err.println("Error al intentar eliminar el nodo en la posición " + indice + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        int count = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.getSiguiente();
        }
        return count;
    }

    public void reverse() {
        try {
            if (cabeza == null || cabeza.getSiguiente() == null) {
                return;
            }

            Nodo<T> anterior = null;
            Nodo<T> actual = cabeza;
            Nodo<T> siguiente = null;

            while (actual != null) {
                siguiente = actual.getSiguiente();
                actual.setSiguiente(anterior);
                anterior = actual;
                actual = siguiente;
            }

            cabeza = anterior;
        } catch (Exception e) {
            System.err.println("Error al intentar invertir la lista: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public T getHead() {
        return cabeza != null ? cabeza.getValor() : null;
    }

    public T getTail() {
        if (cabeza == null) {
            return null;
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual.getValor();
    }

    // Implementación de otras funciones de la lista...

    public T[] toArray() {

        Object[] array = new Object[size()];
        Nodo<T> actual = cabeza;
        int index = 0;

        while (actual != null) {
            array[index++] = actual.getValor();
            actual = actual.getSiguiente();
        }

        @SuppressWarnings("unchecked")
        T[] typedArray = (T[]) array;
        return typedArray;
    }

    // Clase interna Nodo
    private static class Nodo<T> {

        private T valor;
        private Nodo<T> siguiente;

        public Nodo(T valor) {
            this(valor, null);
        }

        public Nodo(T valor, Nodo<T> siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
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
