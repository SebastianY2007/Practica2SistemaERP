package ec.edu.ups.poo.clases;

public class ProductoConIva extends Producto {
    private static final double IVA = 0.15;

    public ProductoConIva(int codigo, String nombre, String descripcion, double precio, String categoria, int stock) {
        super(codigo, nombre, descripcion, precio, categoria, stock);
    }

    public double calcularIva() {
        return getPrecio() * IVA;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() + calcularIva();
    }
}