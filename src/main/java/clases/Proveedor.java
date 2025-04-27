package clases;

import java.util.List;

public class Proveedor extends Persona{
    private int idProveedor;
    private String ruc;
    private List<Producto> productos;

    public Proveedor(String nombre, String apellido, String identificacion, String telefono, String correoElectronico) {
        super(nombre, apellido, identificacion, telefono, correoElectronico);
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nID Proveedor: " + idProveedor +
                "\nRuc: " + ruc +
                "\nProductos: " + productos;
    }
}