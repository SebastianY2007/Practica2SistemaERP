package clases;

import java.util.Objects;

public class DetalleDeCompra {
    private int codigo;
    private int cantidad;
    private double precioUnitario;
    private String observaciones;
    private Producto producto;

    public DetalleDeCompra(int codigo, int cantidad, double precioUnitario, String observaciones, Producto producto) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.observaciones = observaciones;
        this.producto = producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleDeCompra that = (DetalleDeCompra) o;
        return codigo == that.codigo && cantidad == that.cantidad && Double.compare(precioUnitario, that.precioUnitario) == 0 && Objects.equals(observaciones, that.observaciones) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, cantidad, precioUnitario, observaciones, producto);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                "\nCantidad: " + cantidad +
                "\nPrecio Unitario: " + precioUnitario +
                "\nObservaciones: " + observaciones +
                "\nProducto: " + producto;
    }
}