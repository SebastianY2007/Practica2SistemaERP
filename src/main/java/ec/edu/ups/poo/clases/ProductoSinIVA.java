package ec.edu.ups.poo.clases;

public class ProductoSinIVA extends Producto {
    public ProductoSinIVA(int codigo, String nombre, String descripcion,
                          double precio, String categoria, int stock) {
        super(codigo, nombre, descripcion, precio, categoria, stock);
    }

    public double calcularIva() {
        return getPrecio();
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio(); // Sin IVA
    }

    @Override
    public String toString() {
        return super.toString();
    }
}