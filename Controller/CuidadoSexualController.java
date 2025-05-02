package Controller;

import Model.CuidadoSexual;

public class CuidadoSexualController {

    public void agregarCuidadoSexual(String nombre, String descripcion, int precio, String tipo, int cantidad) {
        for (int i = 0; i < ProductosController.cuidadoSexual.length; i++) {
            if (ProductosController.cuidadoSexual[i] == null) {
                ProductosController.cuidadoSexual[i] = new CuidadoSexual(nombre, descripcion, precio, tipo, cantidad);
                break;
            }
        }
    }

    public void eliminarCuidadoSexual(String nombre) {
        for (int i = 0; i < ProductosController.cuidadoSexual.length; i++) {
            if (ProductosController.cuidadoSexual[i] != null
                    && ProductosController.cuidadoSexual[i].getNombre().equals(nombre)) {
                ProductosController.cuidadoSexual[i] = null;
                break;
            }
        }
    }

    public void modificarCuidadoSexual(String nombre, String descripcion, int precio, String tipo, int cantidad) {
        for (CuidadoSexual cuidadoSexual : ProductosController.cuidadoSexual) {
            if (cuidadoSexual != null && cuidadoSexual.getNombre().equals(nombre)) {
                cuidadoSexual.setDescripcion(descripcion);
                cuidadoSexual.setPrecio(precio);
                cuidadoSexual.setTipo(tipo);
                cuidadoSexual.setCantidad(cantidad);
                break;
            }
        }
    }
}
