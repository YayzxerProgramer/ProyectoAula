package Controller;

import static Controller.ProductosController.guardarCambiosYRetornar;
import static Controller.ProductosController.medicamentos;
import Model.Medicamentos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MedicamentoController {

    public static void cargarMedicamentos() {
        medicamentos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("medicamentos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length == 10) {
                    medicamentos.add(new Medicamentos(p[0], p[1], Integer.parseInt(p[2]), p[3], Integer.parseInt(p[4]),
                            p[5], p[6], p[7], p[8], Boolean.parseBoolean(p[9])));
                }
            }
        } catch (IOException e) {
        }
    }

    public static void guardarMedicamentos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("medicamentos.txt"))) {
            for (Medicamentos m : medicamentos) {
                bw.write(m.getNombre() + "," + m.getDescripcion() + "," + m.getPrecio() + "," + m.getTipo() + ","
                        + m.getCantidad() + "," + m.getLaboratorio() + "," + m.getFechaVencimiento() + ","
                        + m.getLote() + "," + m.getVia() + "," + m.getEliminacion());
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }
    
     public static boolean eliminarMedicamento(String nombre) {
        return medicamentos.removeIf(m -> m.getNombre().equals(nombre)) && guardarCambiosYRetornar(true, "medicamentos");
    }
    public static boolean modificarMedicamento(Medicamentos existente, Medicamentos nuevo) {
        int i = medicamentos.indexOf(existente);
        if (i != -1) medicamentos.set(i, nuevo);
        return guardarCambiosYRetornar(i != -1, "medicamentos");
    }
}
