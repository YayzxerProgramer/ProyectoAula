package Controller;

import Model.Medicamentos;

public class MedicamentoController {

    public void agregarMedicamento(String nombre, String descripcion, int precio, String tipo, int cantidad, String laboratorio, String fechaVencimiento, String lote, String via, boolean eliminacion) {
        for (int i = 0; i < ProductosController.medicamentos.length; i++) {
            if (ProductosController.medicamentos[i] == null) {
                ProductosController.medicamentos[i] = new Medicamentos(nombre, descripcion, precio, tipo, cantidad, laboratorio, fechaVencimiento, lote, via, eliminacion);
                break;
            }
        }
    }

    public void eliminarMedicamento(String nombre) {
        for (int i = 0; i < ProductosController.medicamentos.length; i++) {
            if (ProductosController.medicamentos[i] != null && ProductosController.medicamentos[i].getNombre().equals(nombre)) {
                ProductosController.medicamentos[i] = null;
                break;
            }
        }
    }
    
    
    public void modificarMedicamento(String nombre, String descripcion, int precio, String tipo, int cantidad,  String laboratorio, String fechaVencimiento, String lote, String via, boolean eliminacion) {
        for (Medicamentos medicamento : ProductosController.medicamentos) {
            if (medicamento != null && medicamento.getNombre().equals(nombre)) {
                medicamento.setDescripcion(descripcion);
                medicamento.setPrecio(precio);
                medicamento.setTipo(tipo);
                medicamento.setCantidad(cantidad);

            }
        }

    }
}    
