package com.example.EstructurasDeDatos;

public class HashMapImplementation<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private int capacity;
    private ListaSimple<Entry<K, V>>[] table;

    public HashMapImplementation() {
        this(DEFAULT_CAPACITY);
    }

    public HashMapImplementation(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new ListaSimple[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new ListaSimple<>();
        }
        int existingIndex = findKeyIndex(table[index], key);
        if (existingIndex != -1) {
            table[index].getElementAt(existingIndex).value = value;
        } else {
            table[index].append(new Entry<>(key, value));
            size++;
        }
    }

    private int findKeyIndex(ListaSimple<Entry<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.getElementAt(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                Entry<K, V> entry = table[index].getElementAt(i);
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            int keyIndex = findKeyIndex(table[index], key);
            if (keyIndex != -1) {
                table[index].delete_at(keyIndex);
                size--;
            }
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].getElementAt(i).key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (ListaSimple<Entry<K, V>> list : table) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.getElementAt(i).value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ListaSimple<K> keySet() {
        ListaSimple<K> keys = new ListaSimple<>();
        for (ListaSimple<Entry<K, V>> list : table) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    keys.append(list.getElementAt(i).key);
                }
            }
        }
        return keys;
    }

    public ListaSimple<V> values() {
        ListaSimple<V> values = new ListaSimple<>();
        for (ListaSimple<Entry<K, V>> list : table) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    values.append(list.getElementAt(i).value);
                }
            }
        }
        return values;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
        size = 0;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        ListaSimple<Entry<K, V>>[] newTable = new ListaSimple[newCapacity];
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                for (int j = 0; j < table[i].size(); j++) {
                    Entry<K, V> entry = table[i].getElementAt(j);
                    int newIndex = hash(entry.key);
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new ListaSimple<>();
                    }
                    newTable[newIndex].append(entry);
                }
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    public Object[] toArray() {
        // Creamos un nuevo array del tamaño adecuado para almacenar todos los elementos
        // del mapa
        Object[] array = new Object[size];
        // Variable para llevar el seguimiento del índice actual en el array
        int index = 0;
        // Iteramos sobre todas las listas en la tabla hash
        for (ListaSimple<Entry<K, V>> lista : table) {
            // Verificamos si la lista actual no es nula
            if (lista != null) {
                // Iteramos sobre todos los elementos en la lista actual
                for (int i = 0; i < lista.size(); i++) {
                    // Almacenamos el valor del elemento en el array y luego incrementamos el índice
                    array[index++] = lista.getElementAt(i).value;
                }
            }
        }
        // Devolvemos el array que contiene todos los valores del mapa
        return array;
    }

    public Object[] keysToArray() {
        // Creamos un nuevo array del tamaño adecuado para almacenar todas las claves
        // del mapa
        Object[] array = new Object[size];
        // Variable para llevar el seguimiento del índice actual en el array
        int index = 0;
        // Iteramos sobre todas las listas en la tabla hash
        for (ListaSimple<Entry<K, V>> lista : table) {
            // Verificamos si la lista actual no es nula
            if (lista != null) {
                // Iteramos sobre todos los elementos en la lista actual
                for (int i = 0; i < lista.size(); i++) {
                    // Almacenamos la clave del elemento en el array y luego incrementamos el índice
                    array[index++] = lista.getElementAt(i).key;
                }
            }
        }
        // Devolvemos el array que contiene todas las claves del mapa
        return array;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
