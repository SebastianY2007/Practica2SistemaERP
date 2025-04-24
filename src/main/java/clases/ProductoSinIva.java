package clases;

public class ProductoSinIva {
    private static final double IVA = 0.0;

    public double calcularIva(int cantidad) {
        return cantidad*IVA;
    }
}

