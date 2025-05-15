package ec.edu.ups.poo.clases;

public class Persona {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String telefono;
    private String correoElectronico;

    public Persona(String nombre, String apellido, String identificacion, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nIdentificacion: " + identificacion +
                "\nTelefono:" + telefono +
                "\nCorreo Electronico: " + correoElectronico;
    }
}