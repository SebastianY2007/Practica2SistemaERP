package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.ProductoSinIva;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoSinIvaView {

    private Frame frame;
    private Button btnCalcular;
    private Button btnVerHistorial;
    private Button btnLimpiarHistorial;
    private List<ProductoSinIva> productosSinIva;

    public ProductoSinIvaView() {
        productosSinIva = new ArrayList<>();
        construirUI();
    }

    private void construirUI() {
        frame = new Frame("Producto sin IVA");
        frame.setLayout(new FlowLayout());

        btnCalcular = new Button("Calcular Precio");
        btnVerHistorial = new Button("Ver Historial");
        btnLimpiarHistorial = new Button("Limpiar Historial");

        frame.add(btnCalcular);
        frame.add(btnVerHistorial);
        frame.add(btnLimpiarHistorial);

        btnCalcular.addActionListener(e -> mostrarVentanaCalculo());
        btnVerHistorial.addActionListener(e -> mostrarHistorial());
        btnLimpiarHistorial.addActionListener(e -> limpiarHistorial());

        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    private void mostrarVentanaCalculo() {
        Frame ventana = new Frame("Precio sin IVA");
        ventana.setLayout(new FlowLayout());

        TextField txtPrecio = new TextField(10);
        TextArea resultado = new TextArea(4, 35);
        resultado.setEditable(false);

        Button btnProcesar = new Button("Mostrar Resultado");

        ventana.add(new Label("Precio del producto:"));
        ventana.add(txtPrecio);
        ventana.add(btnProcesar);
        ventana.add(resultado);

        btnProcesar.addActionListener(e -> {
            try {
                double precio = Double.parseDouble(txtPrecio.getText().trim());
                ProductoSinIva producto = new ProductoSinIva(1, "Producto sin IVA", "Sin impuestos", precio, "General", 10);

                double iva = producto.calcularIva();
                double precioFinal = producto.calcularPrecioFinal();

                productosSinIva.add(producto);

                resultado.setText(
                        "Precio original: $" + String.format("%.2f", precio) + "\nIVA (0%): $" + String.format("%.2f", iva) + "\nPrecio con IVA: $" + String.format("%.2f", precioFinal)
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
        Frame ventanaHistorial = new Frame("Historial de Productos sin IVA");
        ventanaHistorial.setLayout(new FlowLayout());

        TextArea areaHistorial = new TextArea(15, 50);
        areaHistorial.setEditable(false);

        if (productosSinIva.isEmpty()) {
            areaHistorial.setText("No hay productos sin IVA registrados.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (ProductoSinIva p : productosSinIva) {
                sb.append("Precio: $").append(String.format("%.2f", p.getPrecio()))
                        .append(" | IVA: $0.00")
                        .append(" | Total: $").append(String.format("%.2f", p.calcularPrecioFinal()))
                        .append("\n");
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

    private void limpiarHistorial() {
        productosSinIva.clear();

        Frame ventanaMensaje = new Frame("Historial limpiado");
        ventanaMensaje.setLayout(new FlowLayout());

        Label mensaje = new Label("El historial se limpio correctamente");
        Button btnCerrar = new Button("Cerrar");

        btnCerrar.addActionListener(e -> ventanaMensaje.dispose());

        ventanaMensaje.add(mensaje);
        ventanaMensaje.add(btnCerrar);

        ventanaMensaje.setSize(300, 100);
        ventanaMensaje.setLocationRelativeTo(frame);
        ventanaMensaje.setVisible(true);

        ventanaMensaje.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaMensaje.dispose();
            }
        });
    }
}
