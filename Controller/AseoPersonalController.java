package Controller;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Model.AseoPersonal;

public class AseoPersonalController {

    public static void agregarAseoPersonal(String nombre) {
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido. Intente nuevamente.");
        }
        for (AseoPersonal aseo : ProductosController.aseoPersonal) {
            if (aseo != null && aseo.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, "El aseo personal agregado con exitosamente");

            }
        }
    }

    public static void eliminarAseoPersonal(String nombre) {
        for (AseoPersonal aseo : ProductosController.aseoPersonal) {
            if (aseo != null && aseo.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, "El aseo personal elimado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "El aseo personal no existe");
            }
        }
    }

    public static void modificarAseoPersonal(String nombre, String descripcion, int precio, String tipo, int cantidad) {
        for (AseoPersonal aseoPersonal : ProductosController.aseoPersonal) {
            if (aseoPersonal != null && aseoPersonal.getNombre().equals(nombre)) {
                aseoPersonal.setDescripcion(descripcion);
                aseoPersonal.setPrecio(precio);
                aseoPersonal.setTipo(tipo);
                aseoPersonal.setCantidad(cantidad);

            }
        }

    }
}
