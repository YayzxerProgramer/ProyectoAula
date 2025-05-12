package Model;

public class Empleado extends Usuarios {

    public Empleado(String nombre, String usuario, String contraseña, int edad, String correo, String rol) {
        super(nombre, usuario, contraseña, edad, correo, rol);
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + getNombre() + ", Usuario=" + getUsuarios() + ", correo=" + getCorreo() + ", contrasena=" + getContraseña() + ", edad= " + getEdad() + ", rol= " + getRol() + '}';
    }

    
}
