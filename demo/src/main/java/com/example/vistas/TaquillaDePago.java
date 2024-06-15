/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.vistas;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.example.EstructurasDeDatos.ListaSimple;
import com.example.Model.Paciente;
import com.example.Service.GestionColasTickets;
import com.example.Service.GestionPacientesImp;

/**
 *
 * @author JUAN DAVID FUENTES
 */
public class TaquillaDePago extends javax.swing.JFrame {

    ListaSimple<Paciente> pacientes;
    GestionPacientesImp gestionPacientesImp = new GestionPacientesImp();
    GestionColasTickets gestionColasTickets = new GestionColasTickets();
    Paciente pacienteSeleccionado;

    /**
     * Creates new form TaquillaDePago
     */
    public TaquillaDePago() {
        initComponents();
        setLocationRelativeTo(null);
        gestionPacientesImp.cargarPacientesDesdeJSON("pacientes.json");
        pacientes = gestionPacientesImp.getListaPacientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonRetirar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButtonPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(42, 39, 69));

        jLabel3.setBackground(new java.awt.Color(42, 49, 69));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Busqueda Paciente");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\JUAN DAVID FUENTES\\Desktop\\png\\caduceo.png")); // NOI18N
        jLabel7.setToolTipText("");

        jButtonBuscar.setBackground(new java.awt.Color(42, 39, 69));
        jButtonBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Obtener el texto ingresado en el campo de búsqueda
                String nombreABuscar = jTextField1.getText();

                // Limpiar el modelo de la tabla para mostrar nuevos resultados
                DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();
                modeloTabla.setRowCount(0);

                // Recorrer la lista de pacientes y buscar aquellos cuyos nombres coincidan
                // parcialmente con el texto ingresado
                for (int i = 0; i < pacientes.size(); i++) {
                    Paciente paciente = (Paciente) pacientes.getElementAt(i);
                    if (paciente.getNombres().toLowerCase().contains(nombreABuscar.toLowerCase())) {
                        // Si el nombre del paciente contiene la cadena buscada, agregarlo a la tabla de
                        // resultados
                        Object[] fila = { paciente.getId(), paciente.getNombres(), paciente.getApellidos(),
                                paciente.getEdad(), paciente.getIdentificacion(), paciente.getNumeroTelefono() };
                        modeloTabla.addRow(fila);
                    }
                }
            }
        });

        jTable1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "ID", "Nombre", "Apellido", "Edad", "Identificacíon", "Teléfono"
                }));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 335,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 23, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addContainerGap(18, Short.MAX_VALUE)));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 560, 500));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setText("Taquilla De Pago");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\JUAN DAVID FUENTES\\Desktop\\png\\24px.png")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jButtonRetirar.setBackground(new java.awt.Color(42, 39, 69));
        jButtonRetirar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButtonRetirar.setForeground(new java.awt.Color(255, 0, 0));
        jButtonRetirar.setText("Retirar");
        jButtonRetirar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (pacienteSeleccionado != null && pacienteSeleccionado.getTicket() != null) {
                    pacienteSeleccionado.setTicket(null); // Eliminar el ticket del paciente
                    jTextArea2.setText(""); // Limpiar el área de texto
                    JOptionPane.showMessageDialog(null, "Ticket retirado exitosamente.", "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un ticket seleccionado.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar acción a la tabla de resultados
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        int idPacienteSeleccionado = (int) jTable1.getValueAt(selectedRow, 0);
                        pacienteSeleccionado = obtenerPacientePorID(idPacienteSeleccionado);
                        if (pacienteSeleccionado != null) {
                            if (pacienteSeleccionado.getTicket() != null) {
                                jTextArea2.setText(pacienteSeleccionado.getTicket().toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "El paciente no tiene un ticket.", "Mensaje",
                                        JOptionPane.INFORMATION_MESSAGE);
                                jTextArea2.setText("");
                            }
                        }
                    }
                }
            }
        });
        jPanel1.add(jButtonRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 120, 30));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Ticket Paciente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(42, 39, 69));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(51, 255, 0));
        jTextArea2.setRows(5);
        jTextArea2.setCaretColor(new java.awt.Color(51, 255, 0));
        jScrollPane3.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, 190));

        jButtonPagar.setBackground(new java.awt.Color(42, 39, 69));
        jButtonPagar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButtonPagar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPagar.setText("Pagar");
        jButtonPagar.setActionCommand("");
        jButtonPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (pacienteSeleccionado != null && pacienteSeleccionado.getTicket() != null) {
                    // Marcar el ticket como pagado
                    pacienteSeleccionado.getTicket().actualizarEstadoPago();
                    // Encolar el ticket pagado
                    gestionColasTickets.encolarTicket(pacienteSeleccionado.getTicket());
                    // Eliminar el ticket del paciente
                    pacienteSeleccionado.setTicket(null);
                    // Actualizar la información del paciente en el archivo JSON
                    gestionPacientesImp.actualizarPaciente(pacienteSeleccionado);
                    // Actualizar la vista
                    jTextField1.setText("");
                    JOptionPane.showMessageDialog(null, "Ticket pagado y encolado exitosamente.", "Mensaje",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay un ticket seleccionado.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jPanel1.add(jButtonPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void jButtonRetirarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaquillaDePago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaquillaDePago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaquillaDePago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaquillaDePago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaquillaDePago().setVisible(true);
            }
        });
    }

    private Paciente obtenerPacientePorID(int idPaciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.getElementAt(i);
            if (paciente.getId() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}