package Controller;

import javax.swing.JOptionPane;
import Model.Usuarios;

public class UsuarioController {

    public static Usuarios[] usuario = new Usuarios[10];

    public static void crearUsuario(String nombre, String username, String contraseña, int edad, String correo, String rol) {
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] == null) {
                usuario[i] = new Usuarios(nombre, username, contraseña, edad, correo, rol);
            }
        }
    }

    public void eliminarUsuario(String username) {
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] != null && usuario[i].getUsuario().equals(username)) {
                usuario[i] = null;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        }
    }

    public static void modificarUsuario(String nombre, String username, String contraseña, String edad, String correo, String rol) {
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido.");
        }
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no válido.");
        }
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida");
        }
        int edadInt = 0;
        if (edad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Edad no válida");
        } else {
            try {
                edadInt = Integer.parseInt(edad);
                if (edadInt <= 0 || edadInt > 120) {
                    JOptionPane.showMessageDialog(null, "Edad fuera de rango permitido");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Edad debe ser un número entero");
            }
        }

        if (correo.isEmpty() && correo.endsWith("@gmail.com") && correo.endsWith("@hotmail.com") && correo.endsWith("@outlook.com")) {
            JOptionPane.showMessageDialog(null, "Correo no válido, solo aceptamos corres de Gmail, Hotmail y Outlook.");
        }
        if (rol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rol no válido");
        }

        for (Usuarios usuario1 : usuario) {
            if (usuario1 != null && usuario1.getUsuario().equals(username)) {
                usuario1.setNombre(nombre);
                usuario1.setUsuario(username);
                usuario1.setContraseña(contraseña);
                usuario1.setEdad(edadInt);
                usuario1.setCorreo(correo);
                usuario1.setRol(rol);
                JOptionPane.showMessageDialog(null, "Usuario modificado con éxito");
            }
        }
    }

    public static boolean validarUsuario(String usuario, String contraseña) {
        Usuarios user = Usuarios.getUsuario(usuario);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no existe. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!user.getContraseña().equals(contraseña)) {
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Inicio de Sesión Exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static boolean RegistroUsuario(String nombre, String usuario, String contraseña, String edad, String correo) {
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido");
            return false;
        }
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuario no válido");
            return false;
        }
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida");
            return false;
        }
        int edadInt = 0;
        if (edad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Edad no válida");
            return false;
        } else {
            try {
                edadInt = Integer.parseInt(edad);
                if (edadInt <= 0 || edadInt > 120) {
                    JOptionPane.showMessageDialog(null, "Edad fuera de rango permitido");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Edad debe ser un número entero");
                return false;
            }
        }

        correo = correo.trim();
        if (correo.isEmpty() || !(correo.endsWith("@gmail.com") || correo.endsWith("@hotmail.com") || correo.endsWith("@outlook.com"))) {
            JOptionPane.showMessageDialog(null, "Correo no válido. Solo aceptamos Gmail, Hotmail y Outlook.");
            return false;
        }
        for (Usuarios u : UsuarioController.usuario) {
            if (u != null && u.getUsuario().equals(usuario)) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso");
                return false;
            }
        }

        crearUsuario(nombre, usuario, contraseña, edadInt, correo,
                "Cliente");
        JOptionPane.showMessageDialog(
                null, "Usuario registrado con éxito", "Software SuperFarmax", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public static void llenarUsuarios() {
        usuario[0] = new Usuarios("Yannior Jose Tapias Segovia", "YanniorT", "Ytapias0118", 18,
                "yanniortapias36@gmail.com", "Administrador");
        usuario[1] = new Usuarios("Anderson Javier Pajaro Fanco", "AndersonP", "AndersonP18", 18,
                "andersonjota.pajarofranco@gmail.com", "Empleado");
        usuario[2] = new Usuarios("Andres David Rico Palencia", "AndresR", "AndresR0118", 18, "ricoandres096@gmail.com",
                "Cliente");
        usuario[3] = new Usuarios("Luis Sarmiento", "LuisS", "LuisS123", 17, "luiskdr22@gmail.com", "Administrador");
    }
}
