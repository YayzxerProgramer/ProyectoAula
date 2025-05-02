package Controller;


import Model.Bebidas;

public class BebidasController {

    public void agregarBebida(String nombre, String descripcion, int precio, String tipo, int cantidad) {
        for (int i = 0; i < ProductosController.bebidas.length; i++) {
            if (ProductosController.bebidas[i] == null) {
                ProductosController.bebidas[i] = new Bebidas(nombre, descripcion, precio, tipo, cantidad);
                break;
            }
        }
    }

    public void eliminarBebida(String nombre) {
        for (int i = 0; i < ProductosController.bebidas.length; i++) {
            if (ProductosController.bebidas[i] != null && ProductosController.bebidas[i].getNombre().equals(nombre)) {
                ProductosController.bebidas[i] = null;
                break;
            }
        }
    }

    public void modificarBebida(String nombre, String descripcion, int precio, String tipo, int cantidad) {
        for (Bebidas bebida : ProductosController.bebidas) {
            if (bebida != null && bebida.getNombre().equals(nombre)) {
                bebida.setDescripcion(descripcion);
                bebida.setPrecio(precio);
                bebida.setTipo(tipo);
                bebida.setCantidad(cantidad);

            }
        }

    }
}
