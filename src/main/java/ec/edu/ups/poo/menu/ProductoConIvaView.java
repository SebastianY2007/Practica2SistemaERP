package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.ProductoConIva;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoConIvaView {

    private Frame frame;
    private Button btnCalcularTodo;
    private Button btnVerHistorial;
    private List<ProductoConIva> productos;

    public ProductoConIvaView() {
        productos = new ArrayList<>();
        construirUI();
    }

    private void construirUI() {
        frame = new Frame("Producto con IVA");
        frame.setLayout(new FlowLayout());

        btnCalcularTodo = new Button("Calcular");
        btnVerHistorial = new Button("Ver Historial");

        frame.add(btnCalcularTodo);
        frame.add(btnVerHistorial);

        btnCalcularTodo.addActionListener(e -> mostrarVentanaCalculoCompleto());
        btnVerHistorial.addActionListener(e -> mostrarHistorial());

        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    private void mostrarVentanaCalculoCompleto() {
        Frame ventana = new Frame("Cálculo de Precio e IVA");
        ventana.setLayout(new FlowLayout());

        TextField txtPrecio = new TextField(10);
        TextArea resultado = new TextArea(4, 35);
        resultado.setEditable(false);
        Button btnCalcular = new Button("Calcular");

        ventana.add(new Label("Precio del producto:"));
        ventana.add(txtPrecio);
        ventana.add(btnCalcular);
        ventana.add(resultado);

        btnCalcular.addActionListener(e -> {
            try {
                double precio = Double.parseDouble(txtPrecio.getText().trim());
                ProductoConIva producto = new ProductoConIva(1, "Genérico", "Producto sin detalles", precio, "General", 10);

                double iva = producto.calcularIva();
                double precioFinal = producto.calcularPrecioFinal();

                productos.add(producto); // Agregar al historial

                resultado.setText(
                        "Precio original: $" + String.format("%.2f", precio) +
                                "\nIVA (15%): $" + String.format("%.2f", iva) +
                                "\nPrecio con IVA: $" + String.format("%.2f", precioFinal)
                );
            } catch (NumberFormatException ex) {
                resultado.setText("Error: Precio inválido.");
            }
        });

        ventana.setSize(400, 250);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });
    }

    private void mostrarHistorial() {
        Frame ventanaHistorial = new Frame("Historial de Productos");
        ventanaHistorial.setLayout(new FlowLayout());

        TextArea areaHistorial = new TextArea(15, 50);
        areaHistorial.setEditable(false);

        if (productos.isEmpty()) {
            areaHistorial.setText("No hay productos registrados.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (ProductoConIva p : productos) {
                sb.append("Precio original: $").append(String.format("%.2f", p.getPrecio())).append(" | IVA: $").append(String.format("%.2f", p.calcularIva())).append(" | Total: $").append(String.format("%.2f", p.calcularPrecioFinal())).append("\n");
            }
            areaHistorial.setText(sb.toString());
        }

        ventanaHistorial.add(areaHistorial);
        ventanaHistorial.setSize(600, 350);
        ventanaHistorial.setLocationRelativeTo(null);
        ventanaHistorial.setVisible(true);

        ventanaHistorial.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaHistorial.dispose();
            }
        });
    }
}
