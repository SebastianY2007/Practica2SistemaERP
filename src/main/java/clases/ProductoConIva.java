package clases;

public class ProductoConIva {
    private static final double IVA = 0.15;

    public double calcularIva(int cantidad) {
        return cantidad*IVA;
    }
}
