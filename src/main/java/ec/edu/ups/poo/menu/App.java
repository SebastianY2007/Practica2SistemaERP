package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.DetalleDeCompra;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
        List<DetalleDeCompra> listaDetalles = new ArrayList<>();
        new  DetalleDeCompraView(listaDetalles);
    }
}