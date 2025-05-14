package View;

import Controller.ProductosController;
import Model.AseoPersonal;
import Model.Bebidas;
import Model.CuidadoSexual;
import Model.Medicamentos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CProductos extends javax.swing.JFrame {

    ProductosController controlador = new ProductosController();

    public CProductos() {
        controlador.inicializarProductos();
        controlador.cargarProductosDesdeArchivos();
        initComponents();
    }
    ArrayList<Medicamentos> medicamento = ProductosController.medicamentos;
    ArrayList<AseoPersonal> aseoPersonal = ProductosController.aseoPersonal;
    ArrayList<Bebidas> bebidas = ProductosController.bebidas;
    ArrayList<CuidadoSexual> cuidadoSexual = ProductosController.cuidadoSexual;

    private void llenarTablaCuidadoSexual() {
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setRowCount(0);

        for (CuidadoSexual cuidadosexual : cuidadoSexual) {
            model.addRow(new Object[]{
                cuidadosexual.getNombre(),
                cuidadosexual.getPrecio(),
                cuidadosexual.getDescripcion(),
                cuidadosexual.getTipo(),
                cuidadosexual.getCantidad()
            });
        }
    }

    private void buscarCuidadoSexual() {
        String nombre = TextFieldBuscar.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un medicamento en la tabla");
            return;
        }
        for (CuidadoSexual cuidadosexual : cuidadoSexual) {
            if (cuidadosexual.getNombre().equals(nombre)) {
                InfoTextArea.setText(" Nombre: " + cuidadosexual.getNombre() + "\n"
                        + "Descripción: " + cuidadosexual.getDescripcion() + "\n"
                        + "Precio: " + cuidadosexual.getPrecio() + "\n"
                        + "Tipo: " + cuidadosexual.getTipo() + "\n"
                        + "Cantidad: " + cuidadosexual.getCantidad() 
                );
                return;
            }

        }
    }

    private void llenarTablaMedicamentos() {
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
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
                        "Nombre: " + medicamentos.getNombre() + "\n"
                        + "Descripción: " + medicamentos.getDescripcion() + "\n"
                        + "Precio: " + medicamentos.getPrecio() + "\n"
                        + "Tipo: " + medicamentos.getTipo() + "\n"
                        + "Cantidad: " + medicamentos.getCantidad() + "\n"
                        + "Laboratorio: " + medicamentos.getLaboratorio() + "\n"
                        + "Fecha de Vencimiento: " + medicamentos.getFechaVencimiento() + "\n"
                        + "Lote: " + medicamentos.getLote() + "\n"
                        + "Vía: " + medicamentos.getVia() + "\n"
                        + "Eliminación: " + medicamentos.getEliminacion()
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Medicamento no encontrado.");
    }

    private void llenarTablaAseoPersonal() {
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setRowCount(0);

        for (AseoPersonal aseopersonal : aseoPersonal) {
            model.addRow(new Object[]{
                aseopersonal.getNombre(),
                aseopersonal.getPrecio(),
                aseopersonal.getDescripcion(),
                aseopersonal.getTipo(),
                aseopersonal.getCantidad()

            });
        }
    }

    private void buscarAseoPersonal() {
        String nombre = TextFieldBuscar.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un medicamento en la tabla.");
            return;
        }

        for (AseoPersonal aseopersonal : aseoPersonal) {
            if (aseopersonal.getNombre().equals(nombre)) {
                InfoTextArea.setText(
                        "Nombre: " + aseopersonal.getNombre() + "\n"
                        + "precio: " + aseopersonal.getPrecio() + "\n"
                        + "Descripcion: " + aseopersonal.getPrecio() + "\n"
                        + "Tipo: " + aseopersonal.getPrecio() + "\n"
                        + "Cantidad: " + aseopersonal.getPrecio()
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Aseo Personal no encontrado.");
    }

    private void llenarTablaBebidas() {
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setRowCount(0);

        for (Bebidas bebida : bebidas) {
            model.addRow(new Object[]{
                bebida.getNombre(),
                bebida.getDescripcion(),
                bebida.getPrecio(),
                bebida.getTipo(),
                bebida.getCantidad(),});
        }
    }

    private void buscarbebidas() {
        String nombre = TextFieldBuscar.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una bebida en la tabla.");
            return;

        }
        for (Bebidas bebida : bebidas) {
            if (bebida.getNombre().equals(nombre)) {
                InfoTextArea.setText(
                        "Nombre: " + bebida.getNombre() + "\n"
                        + "Descripción: " + bebida.getDescripcion() + "\n"
                        + "Precio: " + bebida.getPrecio() + "\n"
                        + "Tipo: " + bebida.getTipo() + "\n"
                        + "Cantidad: " + bebida.getCantidad() + "\n"
                );
                return;

            }

        }
        JOptionPane.showMessageDialog(this, "Bebida no encontrada.");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();
        TextFieldBuscar = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProductos);

        InfoTextArea.setColumns(20);
        InfoTextArea.setRows(5);
        jScrollPane2.setViewportView(InfoTextArea);

        TextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldBuscarActionPerformed(evt);
            }
        });

        ButtonBuscar.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscar))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldBuscarActionPerformed

    private void TableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductosMouseClicked
        int selectedRow = TableProductos.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) TableProductos.getValueAt(selectedRow, 0);
            TextFieldBuscar.setText(nombre);
        }
    }//GEN-LAST:event_TableProductosMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JTable TableProductos;
    private javax.swing.JTextField TextFieldBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
