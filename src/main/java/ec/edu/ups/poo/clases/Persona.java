package ec.edu.ups.poo.clases;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectronico;

    public Persona(String nombre, String apellido, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico != null ? correoElectronico : "No especificado";
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(telefono, persona.telefono) && Objects.equals(correoElectronico, persona.correoElectronico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, telefono, correoElectronico);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nTeléfono: " + telefono +
                "\nCorreo Electrónico: " + getCorreoElectronico();
    }
}