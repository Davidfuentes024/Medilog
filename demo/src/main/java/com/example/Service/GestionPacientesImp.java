package com.example.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Orden;
import com.example.Model.Paciente;
import com.example.Model.Ticket;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GestionPacientesImp implements GestionPacientesInterface {

    private ListaSimple<Paciente> listaPacientes;
    private Gson gson;

    public GestionPacientesImp() {
        this.listaPacientes = new ListaSimple<>();
        this.gson = new Gson();
    }

    public void guardarPacientesEnJSON(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            JsonArray pacientesArray = new JsonArray();
            for (int i = 0; i < listaPacientes.size(); i++) {
                Paciente paciente = listaPacientes.getElementAt(i);
                JsonObject pacienteJson = new JsonObject();
                pacienteJson.addProperty("id", paciente.getId());
                pacienteJson.addProperty("nombres", paciente.getNombres());
                pacienteJson.addProperty("apellidos", paciente.getApellidos());
                pacienteJson.addProperty("edad", paciente.getEdad());
                pacienteJson.addProperty("identificacion", paciente.getIdentificacion());
                pacienteJson.addProperty("numeroTelefono", paciente.getNumeroTelefono());
                pacienteJson.addProperty("idHistoriaClinica", paciente.getIdHistoriaClinica());

                // Guardar el ticket del paciente si existe
                Ticket ticket = paciente.getTicket();
                if (ticket != null) {
                    JsonObject ticketJson = new JsonObject();
                    ticketJson.addProperty("identificador", ticket.getIdentificador());
                    ticketJson.addProperty("motivoCita", ticket.getMotivoCita());
                    ticketJson.addProperty("turno", ticket.getTurno());
                    ticketJson.addProperty("estadoPago", ticket.isEstadoPago());
                    ticketJson.addProperty("valor", ticket.getValor());
                    pacienteJson.add("ticket", ticketJson);
                }

                // Guardar las órdenes del paciente
                JsonArray ordenesArray = new JsonArray();
                for (Orden orden : paciente.getOrdenesArray()) {
                    JsonObject ordenJson = new JsonObject();
                    ordenJson.addProperty("id", orden.getId());
                    ordenJson.addProperty("tipoExamen", orden.getTipoExamen());
                    ordenJson.addProperty("costoExamen", orden.getCostoExamen());
                    ordenJson.addProperty("descripcion", orden.getDescripcion());
                    ordenJson.addProperty("estadoAutorizacion", orden.isEstadoAutorizacion());
                    // Agregar el objeto de orden al array de órdenes
                    ordenesArray.add(ordenJson);
                }
                pacienteJson.add("ordenes", ordenesArray);

                // Agregar el objeto de paciente al array de pacientes
                pacientesArray.add(pacienteJson);
            }
            gson.toJson(pacientesArray, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargarPacientesDesdeJSON(String rutaArchivo) {
        try (Reader reader = new FileReader(rutaArchivo)) {
            JsonArray pacientesArray = gson.fromJson(reader, JsonArray.class);
            if (pacientesArray != null) {
                for (JsonElement pacienteElement : pacientesArray) {
                    JsonObject pacienteJson = pacienteElement.getAsJsonObject();

                    // Obtener los datos del paciente
                    int id = pacienteJson.get("id").getAsInt();
                    String nombres = pacienteJson.get("nombres").getAsString();
                    String apellidos = pacienteJson.get("apellidos").getAsString();
                    int edad = pacienteJson.get("edad").getAsInt();
                    String identificacion = pacienteJson.get("identificacion").getAsString();
                    String numeroTelefono = pacienteJson.get("numeroTelefono").getAsString();
                    int idHistoriaClinica = pacienteJson.get("idHistoriaClinica").getAsInt();

                    // Crear el objeto Paciente
                    Paciente paciente = new Paciente(id, nombres, apellidos, edad, identificacion, numeroTelefono,
                            idHistoriaClinica);

                    // Cargar el ticket del paciente si existe
                    JsonObject ticketJson = pacienteJson.getAsJsonObject("ticket");
                    if (ticketJson != null) {
                        String identificador = ticketJson.get("identificador").getAsString();
                        String motivoCita = ticketJson.get("motivoCita").getAsString();
                        int turno = ticketJson.get("turno").getAsInt();
                        boolean estadoPago = ticketJson.get("estadoPago").getAsBoolean();
                        double valor = ticketJson.get("valor").getAsDouble();
                        // Crear el objeto Ticket
                        Ticket ticket = new Ticket(motivoCita, turno);
                        ticket.setIdentificador(identificador);
                        ticket.setEstadoPago(estadoPago);
                        ticket.setValor(valor);
                        // Asignar el ticket al paciente
                        paciente.setTicket(ticket);
                    }

                    // Cargar las órdenes del paciente
                    JsonArray ordenesArray = pacienteJson.getAsJsonArray("ordenes");
                    if (ordenesArray != null) {
                        for (JsonElement ordenElement : ordenesArray) {
                            JsonObject ordenJson = ordenElement.getAsJsonObject();
                            int idOrden = ordenJson.get("id").getAsInt();
                            String tipoExamen = ordenJson.get("tipoExamen").getAsString();
                            double costoExamen = ordenJson.get("costoExamen").getAsDouble();
                            String descripcion = ordenJson.get("descripcion").getAsString();
                            boolean estadoAutorizacion = ordenJson.get("estadoAutorizacion").getAsBoolean();
                            // Crear objeto de orden y agregarlo al paciente
                            Orden orden = new Orden(idOrden, tipoExamen, paciente.getId(), costoExamen, descripcion,
                                    estadoAutorizacion);
                            paciente.getOrdenes().append(orden);
                        }
                    }

                    // Agregar el paciente a la lista
                    listaPacientes.append(paciente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearPaciente(Paciente paciente) {
        // Obtener el ID del paciente
        int idPaciente = paciente.getId();
        // Verificar si el ID ya está ocupado
        while (idOcupado(idPaciente)) {
            // Si el ID está ocupado, incrementar el ID en 1
            idPaciente++;
            paciente.setId(idPaciente); // Actualizar el ID del paciente
        }
        // Agregar el paciente a la lista
        listaPacientes.append(paciente);
        // Guardar la lista de pacientes en el archivo JSON
        guardarPacientesEnJSON("pacientes.json");
    }

    // Método para verificar si un ID está ocupado
    private boolean idOcupado(long id) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente paciente = listaPacientes.getElementAt(i);
            if (paciente.getId() == id) {
                return true; // El ID está ocupado
            }
        }
        return false; // El ID no está ocupado
    }

    @Override
    public Paciente obtenerPaciente(String nombrePaciente) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente paciente = listaPacientes.getElementAt(i);
            if (paciente.getNombres().equals(nombrePaciente)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public ListaSimple<Paciente> obtenerTodosPacientes() {
        return listaPacientes;
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente pacienteExistente = listaPacientes.getElementAt(i);
            if (pacienteExistente.getId() == paciente.getId()) {
                listaPacientes.delete_at(i);
                listaPacientes.insert(paciente, i);
                break;
            }
        }
        guardarPacientesEnJSON("pacientes.json");
    }

    @Override
    public void eliminarPaciente(Long idPaciente) {
        int tamaño = listaPacientes.size();
        for (int i = 0; i < tamaño; i++) {
            Paciente paciente = listaPacientes.getElementAt(i);
            if (paciente.getId() == idPaciente) {
                listaPacientes.delete_at(i);
                break;
            }
        }
        guardarPacientesEnJSON("pacientes.json");
    }

    public ListaSimple<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ListaSimple<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

}
