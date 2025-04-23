package clases;

import java.util.List;

public class Proveedor extends Persona{
    private int idProveedor;
    private String ruc;
    private List<Producto> productos;

    public Proveedor(String nombre, String apellido, String identificacion, String telefono, String correoElectronico) {
        super(nombre, apellido, identificacion, telefono, correoElectronico);
    }


}