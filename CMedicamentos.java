
package View;

import Controller.MedicamentoController;
import Controller.ProductosController;
import Model.Medicamentos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CMedicamentos extends javax.swing.JFrame {
    
    ProductosController controlador = new ProductosController();
    
    public CMedicamentos() {
        MedicamentoController.cargarMedicamentos();
        initComponents();
        controlador.cargarProductosDesdeArchivos();
        llenarTablaMedicamentos();
        
    }
    ArrayList<Medicamentos> medicamento = ProductosController.medicamentos;
    
    private void llenarTablaMedicamentos() {
    DefaultTableModel model = (DefaultTableModel) TableMedicamento.getModel();
    model.setRowCount(0);

    for (Medicamentos medicamentos : medicamento) {
        model.addRow(new Object[]{
            medicamentos.getNombre(),
            medicamentos.getDescripcion(),
            medicamentos.getPrecio(),
            medicamentos.getTipo(),
            medicamentos.getLaboratorio(),
            medicamentos.getCantidad(),
            medicamentos.getFechaVencimiento(),
            medicamentos.getLote(),
            medicamentos.getVia()
        });
    }
}
    private void buscarMedicamento() {
        String nombre = TextFieldBuscar.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un medicamento en la tabla.");
            return;
        }

        for (Medicamentos medicamentos : medicamento) {
            if (medicamentos.getNombre().equals(nombre)) {
                InfoTextArea.setText(
                        "Nombre: " + medicamentos.getNombre() + "\n" +
                        "Descripción: " + medicamentos.getDescripcion() + "\n" +
                        "Precio: " + medicamentos.getPrecio() + "\n" +
                        "Tipo: " + medicamentos.getTipo() + "\n" +
                        "Cantidad: " + medicamentos.getCantidad() + "\n" +
                        "Laboratorio: " + medicamentos.getLaboratorio() + "\n" +
                        "Fecha de Vencimiento: " + medicamentos.getFechaVencimiento() + "\n" +
                        "Lote: " + medicamentos.getLote() + "\n" +
                        "Vía: " + medicamentos.getVia() + "\n" +
                        "Eliminación: " + medicamentos.getEliminacion()
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Medicamento no encontrado.");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMedicamento = new javax.swing.JTable();
        TextFieldBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TableMedicamento.setBackground(new java.awt.Color(255, 255, 255));
        TableMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Tipo", "Laboratorio", "Cantidad", "Fecha Vencimiento", "Lote", "Via"
            }
        ));
        TableMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableMedicamento);

        TextFieldBuscar.setText("jTextField1");

        jButton1.setText("Buscarr");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        InfoTextArea.setColumns(20);
        InfoTextArea.setRows(5);
        InfoTextArea.setToolTipText("Aqui encontrarras la informacion completa de los productos");
        jScrollPane2.setViewportView(InfoTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarMedicamento();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMedicamentoMouseClicked
        int selectedRow = TableMedicamento.getSelectedRow();
                if (selectedRow != -1) {
                    String nombre = (String) TableMedicamento.getValueAt(selectedRow, 0);
                    TextFieldBuscar.setText(nombre);
                }
    }//GEN-LAST:event_TableMedicamentoMouseClicked

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CMedicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JTable TableMedicamento;
    private javax.swing.JTextField TextFieldBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
