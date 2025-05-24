package ec.edu.ups.poo.clases;

import java.util.List;
import java.util.Objects;

public class Proveedor extends Persona {
    private int idProveedor;
    private String ruc;
    private List<Producto> productos;

    public Proveedor(String nombre, String apellido, String telefono,
                     String correoElectronico, int idProveedor, String ruc) {
        super(nombre, apellido, telefono, correoElectronico);
        this.idProveedor = idProveedor;
        this.ruc = ruc;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return idProveedor == proveedor.idProveedor && Objects.equals(ruc, proveedor.ruc) && Objects.equals(productos, proveedor.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProveedor, ruc, productos);
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Teléfono: " + getTelefono() + "\n" +
                "Correo Electrónico: " + (getCorreoElectronico()) + "\n" +
                "RUC: " + ruc + "\n" +
                "ID Proveedor: " + idProveedor;
    }
}