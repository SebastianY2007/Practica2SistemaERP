package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.SolicitudCompra;
import ec.edu.ups.poo.clases.DetalleDeCompra;
import ec.edu.ups.poo.enums.EstadoSolicitud;
import ec.edu.ups.poo.clases.Producto;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudCompraView {

    private Frame frame;
    private TextField txtId;
    private TextField txtFecha;
    private TextField txtMonto;
    private TextArea taProductos;

    private Button btnAgregar;
    private Button btnCambiarEstado;
    private Button btnLimpiar;
    private Button btnSalir;

    private List<SolicitudCompra> solicitudes;

    public SolicitudCompraView(List<SolicitudCompra> solicitudes) {
        this.solicitudes = solicitudes;
        construirUI();
    }

    private void construirUI() {
        frame = new Frame("Gestión de Solicitudes de Compra");
        frame.setLayout(new FlowLayout());

        frame.add(new Label("ID Solicitud:"));
        txtId = new TextField(10);
        frame.add(txtId);

        frame.add(new Label("Fecha (dd/mm/yyyy):"));
        txtFecha = new TextField(10);
        frame.add(txtFecha);

        frame.add(new Label("Monto Total:"));
        txtMonto = new TextField(10);
        frame.add(txtMonto);

        frame.add(new Label("Resumen Productos (simulado):"));
        taProductos = new TextArea(5, 40);
        frame.add(taProductos);

        btnAgregar = new Button("Agregar Solicitud");
        btnCambiarEstado = new Button("Cambiar Estado");
        btnLimpiar = new Button("Limpiar");
        btnSalir = new Button("Salir");

        frame.add(btnAgregar);
        frame.add(btnCambiarEstado);
        frame.add(btnLimpiar);
        frame.add(btnSalir);

        // Acción Agregar Solicitud
        btnAgregar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                double monto = Double.parseDouble(txtMonto.getText().trim());

                GregorianCalendar fecha = new GregorianCalendar(); // Para simplificar
                SolicitudCompra solicitud = new SolicitudCompra(id, fecha, monto, EstadoSolicitud.SOLICITADA);

                // Producto simulado (normalmente esto se ingresaría con más detalle)
                DetalleDeCompra detalle = new DetalleDeCompra(new Producto(999), 2, 10.0, "Ninguna");
                solicitud.addDetalleDeCompras(detalle);

                solicitudes.add(solicitud);

                taProductos.append("Solicitud agregada: ID " + id + "\n");
            } catch (NumberFormatException ex) {
                taProductos.append("Error: Datos inválidos.\n");
            }
        });

        // Acción Cambiar Estado
        btnCambiarEstado.addActionListener(e -> {
            if (!solicitudes.isEmpty()) {
                SolicitudCompra ultima = solicitudes.get(solicitudes.size() - 1);
                ultima.setEstadoSolicitud(EstadoSolicitud.APROBADA);
                taProductos.append("Estado cambiado a APROBADA para ID: " + ultima.getId() + "\n");
            }
        });

        // Acción Limpiar
        btnLimpiar.addActionListener(e -> {
            txtId.setText("");
            txtFecha.setText("");
            txtMonto.setText("");
            taProductos.setText("");
        });

        // Acción Salir
        btnSalir.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
