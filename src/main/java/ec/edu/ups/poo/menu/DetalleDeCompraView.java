package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.DetalleDeCompra;
import ec.edu.ups.poo.clases.Producto;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class DetalleDeCompraView {
    private Frame frame;
    private TextField txtCodigo, txtCantidad, txtPrecioUnitario, txtObservaciones, txtNombreProducto;
    private TextArea taResumen;
    private Button btnAgregar, btnLimpiar, btnSalir;

    private List<DetalleDeCompra> detalles;

    public DetalleDeCompraView(List<DetalleDeCompra> detalles) {
        this.detalles = detalles;
        construirUI();
    }

    private void construirUI() {
        frame = new Frame("Detalles de Compra");
        frame.setLayout(new GridLayout(8, 2));

        frame.add(new Label("Código:"));
        txtCodigo = new TextField();
        frame.add(txtCodigo);

        frame.add(new Label("Cantidad:"));
        txtCantidad = new TextField();
        frame.add(txtCantidad);

        frame.add(new Label("Precio Unitario:"));
        txtPrecioUnitario = new TextField();
        frame.add(txtPrecioUnitario);

        frame.add(new Label("Observaciones:"));
        txtObservaciones = new TextField();
        frame.add(txtObservaciones);

        frame.add(new Label("Nombre del Producto:"));
        txtNombreProducto = new TextField();
        frame.add(txtNombreProducto);

        btnAgregar = new Button("Agregar");
        btnLimpiar = new Button("Limpiar");
        btnSalir = new Button("Salir");

        frame.add(btnAgregar);
        frame.add(btnLimpiar);
        frame.add(btnSalir);

        taResumen = new TextArea(5, 50);
        frame.add(new Label("Resumen:"));
        frame.add(taResumen);

        btnAgregar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                int cantidad = Integer.parseInt(txtCantidad.getText());
                double precio = Double.parseDouble(txtPrecioUnitario.getText());
                String observaciones = txtObservaciones.getText();
                String nombreProducto = txtNombreProducto.getText();

                Producto producto = new Producto(nombreProducto) {
                    @Override
                    public double calcularPrecioFinal() {
                        return 0;
                    }
                };

                DetalleDeCompra detalle = new DetalleDeCompra(codigo, cantidad, precio, observaciones, producto);
                detalles.add(detalle);

                taResumen.append(detalle.toString() + "\n\n");
            } catch (Exception ex) {
                taResumen.append("Error: Datos inválidos\n");
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtCodigo.setText("");
            txtCantidad.setText("");
            txtPrecioUnitario.setText("");
            txtObservaciones.setText("");
            txtNombreProducto.setText("");
        });

        btnSalir.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}