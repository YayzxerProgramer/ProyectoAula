package View;

import Controller.ProductosController;
import Model.AseoPersonal;
import Model.Bebidas;
import Model.CuidadoSexual;
import Model.Medicamentos;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CProductos extends javax.swing.JFrame {

    private String tipoProductoSeleccionado;
    ProductosController controlador = new ProductosController();

    public CProductos() {
        controlador.inicializarProductos();
        controlador.cargarProductosDesdeArchivos();
        initComponents();
    }

    public void setTipoProducto(String tipoProductoSeleccionado) {
        this.tipoProductoSeleccionado = tipoProductoSeleccionado;
    }

    ArrayList<Medicamentos> medicamento = ProductosController.medicamentos;
    ArrayList<AseoPersonal> aseoPersonal = ProductosController.aseoPersonal;
    ArrayList<Bebidas> bebidas = ProductosController.bebidas;
    ArrayList<CuidadoSexual> cuidadoSexual = ProductosController.cuidadoSexual;

    public void configurarColumnas(String[] columnas) {
        DefaultTableModel model = (DefaultTableModel) TableProductos.getModel();
        model.setColumnIdentifiers(columnas);
    }

    public String[] obtenerColumnas(String tipoProducto) {
        return switch (tipoProducto) {
            case "Medicamentos" ->
                new String[]{
                    "Nombre", "Descripción", "Precio", "Tipo", "Laboratorio",
                    "Cantidad", "Fecha Vencimiento", "Lote", "Vía"
                };
            case "Bebidas" ->
                new String[]{
                    "Nombre", "Descripción", "Precio", "Tipo", "Cantidad"
                };
            case "Aseo Personal" ->
                new String[]{
                    "Nombre", "Descripción", "Precio", "Tipo", "Cantidad"
                };
            case "Cuidado Sexual" ->
                new String[]{
                    "Nombre", "Precio", "Descripción", "Tipo", "Cantidad"
                };
            default ->
                new String[]{"Columna 1", "Columna 2"};
        };
    }

    public void llenarTablaCuidadoSexual() {
        String[] columnas = obtenerColumnas("Cuidado Sexual");
        configurarColumnas(columnas);
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

    public void llenarTablaMedicamentos() {
        String[] columnas = obtenerColumnas("Medicamentos");
        configurarColumnas(columnas);

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

    public void llenarTablaAseoPersonal() {
        String[] columnas = obtenerColumnas("Aseo Personal");
        configurarColumnas(columnas);

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

    public void llenarTablaBebidas() {
        String[] columnas = obtenerColumnas("Bebidas");
        configurarColumnas(columnas);

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

    private void buscarProducto(String nombreProducto) {
        if (nombreProducto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de producto para buscar.");
            return;
        }
        ArrayList<?> listaProductos = null;

        switch (tipoProductoSeleccionado) {
            case "Medicamentos" ->
                listaProductos = medicamento;
            case "Bebidas" ->
                listaProductos = bebidas;
            case "Aseo Personal" ->
                listaProductos = aseoPersonal;
            case "Cuidado Sexual" ->
                listaProductos = cuidadoSexual;
            default -> {
                JOptionPane.showMessageDialog(this, "Tipo de producto no válido.");
                return;
            }
        }

        boolean encontrado = false;
        StringBuilder informacion = new StringBuilder();

        for (Object producto : listaProductos) {
            if (producto instanceof Medicamentos && ((Medicamentos) producto).getNombre().equalsIgnoreCase(nombreProducto)) {
                Medicamentos medicamento1 = (Medicamentos) producto;
                informacion.append("Nombre: ").append(medicamento1.getNombre()).append("\n")
                        .append("Descripción: ").append(medicamento1.getDescripcion()).append("\n")
                        .append("Precio: ").append(medicamento1.getPrecio()).append("\n")
                        .append("Tipo: ").append(medicamento1.getTipo()).append("\n")
                        .append("Laboratorio: ").append(medicamento1.getLaboratorio()).append("\n")
                        .append("Cantidad: ").append(medicamento1.getCantidad()).append("\n")
                        .append("Fecha de Vencimiento: ").append(medicamento1.getFechaVencimiento()).append("\n")
                        .append("Lote: ").append(medicamento1.getLote()).append("\n")
                        .append("Vía: ").append(medicamento1.getVia()).append("\n");
                encontrado = true;
                break;
            } else if (producto instanceof Bebidas && ((Bebidas) producto).getNombre().equalsIgnoreCase(nombreProducto)) {
                Bebidas bebida = (Bebidas) producto;
                informacion.append("Nombre: ").append(bebida.getNombre()).append("\n")
                        .append("Descripción: ").append(bebida.getDescripcion()).append("\n")
                        .append("Precio: ").append(bebida.getPrecio()).append("\n")
                        .append("Tipo: ").append(bebida.getTipo()).append("\n")
                        .append("Cantidad: ").append(bebida.getCantidad()).append("\n");
                encontrado = true;
                break;
            } else if (producto instanceof CuidadoSexual && ((CuidadoSexual) producto).getNombre().equalsIgnoreCase(nombreProducto)) {
                CuidadoSexual cuidadosexual = (CuidadoSexual) producto;
                informacion.append("Nombre: ").append(cuidadosexual.getNombre()).append("\n")
                        .append("Descripción: ").append(cuidadosexual.getDescripcion()).append("\n")
                        .append("Precio: ").append(cuidadosexual.getPrecio()).append("\n")
                        .append("Tipo: ").append(cuidadosexual.getTipo()).append("\n")
                        .append("Cantidad: ").append(cuidadosexual.getCantidad()).append("\n");
                encontrado = true;
                break;
            } else if (producto instanceof AseoPersonal && ((AseoPersonal) producto).getNombre().equalsIgnoreCase(nombreProducto)) {
                AseoPersonal aseopersonal = (AseoPersonal) producto;
                informacion.append("Nombre: ").append(aseopersonal.getNombre()).append("\n")
                        .append("Descripción: ").append(aseopersonal.getDescripcion()).append("\n")
                        .append("Precio: ").append(aseopersonal.getPrecio()).append("\n")
                        .append("Tipo: ").append(aseopersonal.getTipo()).append("\n")
                        .append("Cantidad: ").append(aseopersonal.getCantidad()).append("\n");
                encontrado = true;
                break;
            }

            if (encontrado) {
                InfoTextArea.setText(informacion.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            }
        }
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

        TextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextFieldBuscarKeyPressed(evt);
            }
        });

        ButtonBuscar.setText("jButton1");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

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

    private void TableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductosMouseClicked
        int selectedRow = TableProductos.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) TableProductos.getValueAt(selectedRow, 0);
            TextFieldBuscar.setText(nombre);
        }
    }//GEN-LAST:event_TableProductosMouseClicked

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        buscarProducto(TextFieldBuscar.getText());
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void TextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldBuscarKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            buscarProducto(TextFieldBuscar.getText());
        }
    }//GEN-LAST:event_TextFieldBuscarKeyPressed

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
