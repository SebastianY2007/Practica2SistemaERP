package ec.edu.ups.poo.clases;

public class ProductoConIVA extends Producto {
    public ProductoConIVA(int codigo, String nombre, String descripcion,
                          double precio, String categoria, int stock) {
        super(codigo, nombre, descripcion, precio, categoria, stock);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 1.12; // 12% IVA
    }

    public double calcularIva() {
        return getPrecio() * 0.12;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
