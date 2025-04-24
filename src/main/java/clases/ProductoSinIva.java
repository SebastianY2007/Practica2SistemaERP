package clases;

public class ProductoSinIva extends Producto {
    private static final double IVA = 0.0;

    public ProductoSinIva(int codigo, String nombre, String descripcion, double precio, String categoria, int stock) {
        super(codigo, nombre, descripcion, precio, categoria, stock);
    }

    public double calcularIva() {
        return getPrecio() * IVA;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio(); // No se aplica IVA
    }
}
