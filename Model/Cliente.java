package Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.ProductosController;

public class Cliente extends Usuarios {

    static List<Medicamentos> carrito = new ArrayList<>();

    public Cliente(String nombre, String usuario, String contraseña, int edad, String correo, String rol) {
        super(nombre, usuario, contraseña, edad, correo, "Cliente");
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + getNombre() + ", Usuario=" + getUsuario() + ", correo=" + getCorreo()
                + ", contrasena=" + getContraseña() + ", edad= " + getEdad() + ", rol= " + getRol() + '}';
    }

    public static void medicamentosC() {
        JLabel mensaje1 = new JLabel("<html>Seleccione un medicamento para agregar al carrito:</html>");
        mensaje1.setFont(new Font("Arial", Font.BOLD, 16));
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(mensaje1, BorderLayout.SOUTH);
        panel1.setPreferredSize(new Dimension(200, 40));

        String[] medicamentosDisponibles = new String[ProductosController.medicamentos.length];
        for (int i = 0; i < ProductosController.medicamentos.length; i++) {
            if (ProductosController.medicamentos[i] != null) {
                medicamentosDisponibles[i] = ProductosController.medicamentos[i].getNombre();
            }
        }
        String medicamentoSeleccionado = (String) JOptionPane.showInputDialog(null, panel1, "Carrito de Compras", JOptionPane.PLAIN_MESSAGE, null, medicamentosDisponibles, medicamentosDisponibles[0]);
        if (medicamentoSeleccionado != null) {
            for (Medicamentos medicamento : ProductosController.medicamentos) {
                if (medicamento != null && medicamento.getNombre().equals(medicamentoSeleccionado)) {
                    carrito.add(medicamento);
                    JOptionPane.showMessageDialog(null, "Producto agregado al carrito exitosamente.", "Carrito de Compras", JOptionPane.PLAIN_MESSAGE);
                    carritoCompras();
                }
            }
        }
    }

    public static void consultar() {
        ImageIcon icono = new ImageIcon("");
        JLabel mensaje = new JLabel("<html>1. Medicamentos <br>2. Cuidado Sexual<br>3. Aseo Personal<br>4. Bebidas<br>5. Ir al menu anterior</html>");
        JLabel titulo = new JLabel("<html><h1>Menu Clientes</h1></html>");
        JLabel imagenLabel = new JLabel(icono);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        mensaje.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(mensaje, BorderLayout.SOUTH);
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(imagenLabel, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(300, 270));
        String opcion = (String) JOptionPane.showInputDialog(null, panel, "Menu Clientes", JOptionPane.PLAIN_MESSAGE, null, null, null);
        if (opcion != null) {
            switch (opcion) {
                case "1" -> {
                    String[] columnas = {"Nombre", "Descripción", "Precio", "Tipo", "Cantidad", "Laboratorio", "Fecha Vencimiento", "Lote", "Vía"};
                    DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    for (Medicamentos medicamento : ProductosController.medicamentos) {
                        if (medicamento != null) {
                            Object[] fila = {
                                medicamento.getNombre(),
                                medicamento.getDescripcion(),
                                medicamento.getPrecio(),
                                medicamento.getTipo(),
                                medicamento.getCantidad(),
                                medicamento.getLaboratorio(),
                                medicamento.getFechaVencimiento(),
                                medicamento.getLote(),
                                medicamento.getVia(),};
                            modelo.addRow(fila);
                        }
                    }

                    JTable tabla = new JTable(modelo);
                    tabla.setFillsViewportHeight(true);

                    JScrollPane scrollPane = new JScrollPane(tabla);
                    scrollPane.setPreferredSize(new Dimension(800, 300));

                    JOptionPane.showMessageDialog(null, scrollPane, "Lista de Medicamentos", JOptionPane.PLAIN_MESSAGE);
                    carritoCompras();
                }
                case "2" -> {
                    
                }


                case "3" ->
                    JOptionPane.showMessageDialog(null, "Aseo Personal");
                case "4" ->
                    JOptionPane.showMessageDialog(null, "Bebidas");
                default ->
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }
    }

    public static void carritoCompras() {
        ImageIcon icono = new ImageIcon("proyectoaula3\\image\\Productos1.gif");
        JLabel mensaje = new JLabel("<html>1. Agregar al carrito<br>2. Eliminar del carrito<br>3. Ver carrito<br>4. Ir al menu anterior</html>");
        JLabel titulo = new JLabel("<html><h1>Menu Clientes</h1></html>");
        JLabel imagenLabel = new JLabel(icono);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        mensaje.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(mensaje, BorderLayout.SOUTH);
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(imagenLabel, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(300, 270));
        String opcion = (String) JOptionPane.showInputDialog(null, panel, "Menu Clientes", JOptionPane.PLAIN_MESSAGE, null, null, null);
        if (opcion != null) {
            switch (opcion) {
                case "1" -> {
                    medicamentosC();
                }
                case "2" -> {
                    JOptionPane.showMessageDialog(null, "Eliminar del carrito");
                }
                case "3" -> {
                    if (!carrito.isEmpty()) {
                        StringBuilder contenidoCarrito = new StringBuilder("Productos en el carrito:\n");
                        for (Medicamentos medicamento : carrito) {
                            contenidoCarrito.append("- ").append(medicamento.getNombre()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, contenidoCarrito.toString(), "Carrito de Compras", JOptionPane.PLAIN_MESSAGE);
                        menuCliente();
                    } else {
                        JOptionPane.showMessageDialog(null, "El carrito está vacío.", "Carrito de Compras", JOptionPane.PLAIN_MESSAGE);
                        menuCliente();
                    }
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }
    }

    public static void menuCliente() {
        ImageIcon icono = new ImageIcon("proyectoaula3\\image\\Cliente.gif");
        JLabel mensaje = new JLabel("<html>1. Consultar<br>2. Carrito de compras</html>");
        JLabel titulo = new JLabel("<html><h1>Menu Clientes</h1></html>");
        JLabel imagenLabel = new JLabel(icono);
        titulo.setFont(new Font("Arial", Font.BOLD, 14));
        mensaje.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));
        panelTexto.add(titulo);
        panelTexto.add(mensaje);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints pcuadricula = new GridBagConstraints();
        pcuadricula.anchor = GridBagConstraints.WEST;
        panel.add(imagenLabel, pcuadricula);

        pcuadricula.anchor = GridBagConstraints.EAST;
        pcuadricula.fill = GridBagConstraints.HORIZONTAL;
        pcuadricula.weightx = 3.0;
        panel.add(panelTexto, pcuadricula);

        panel.setPreferredSize(new Dimension(470, 200));
        String opcion = (String) JOptionPane.showInputDialog(null, panel, "Menu Clientes", JOptionPane.PLAIN_MESSAGE, null, null, null);
        if (opcion != null) {
            switch (opcion) {
                case "1" ->
                    consultar();
                case "2" ->
                    carritoCompras();
                default ->
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }

        }

    }

}
