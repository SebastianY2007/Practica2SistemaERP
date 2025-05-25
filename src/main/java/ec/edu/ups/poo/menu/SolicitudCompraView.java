package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.SolicitudCompra;
import ec.edu.ups.poo.clases.DetalleDeCompra;
import ec.edu.ups.poo.enums.EstadoSolicitud;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudCompraView {

    private Frame frame;
    private TextArea taProductos;
    private Button btnAgregar;
    private Button btnAgregarProducto;
    private Button btnCambiarEstado;
    private Button btnVerEstado;
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

        frame.add(new Label("Resumen Productos / Solicitudes:"));
        taProductos = new TextArea(5, 50);
        taProductos.setEditable(false);
        frame.add(taProductos);

        btnAgregar = new Button("Agregar Solicitud");
        btnAgregarProducto = new Button("Agregar Producto");
        btnCambiarEstado = new Button("Cambiar Estado");
        btnVerEstado = new Button("Ver Estado");
        btnLimpiar = new Button("Limpiar");
        btnSalir = new Button("Salir");

        frame.add(btnAgregar);
        frame.add(btnAgregarProducto);
        frame.add(btnCambiarEstado);
        frame.add(btnVerEstado);
        frame.add(btnLimpiar);
        frame.add(btnSalir);

        btnAgregar.addActionListener(e -> mostrarVentanaAgregarSolicitud());
        btnAgregarProducto.addActionListener(e -> mostrarVentanaAgregarProducto());
        btnCambiarEstado.addActionListener(e -> mostrarVentanaCambiarEstado());

        btnVerEstado.addActionListener(e -> {
            if (!solicitudes.isEmpty()) {
                SolicitudCompra ultima = solicitudes.get(solicitudes.size() - 1);
                taProductos.append("Estado actual de la solicitud ID " + ultima.getId() + ": " + ultima.getEstadoSolicitud() + "\n");
            } else {
                taProductos.append("No hay solicitudes registradas.\n");
            }
        });

        btnLimpiar.addActionListener(e -> taProductos.setText(""));
        btnSalir.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.DARK_GRAY);
    }

    private void mostrarVentanaAgregarSolicitud() {
        Frame ventana = new Frame("Agregar Nueva Solicitud");
        ventana.setLayout(new FlowLayout());

        TextField txtId = new TextField(10);
        TextField txtMonto = new TextField(10);

        ventana.add(new Label("ID Solicitud:"));
        ventana.add(txtId);
        ventana.add(new Label("Monto Total:"));
        ventana.add(txtMonto);

        Button btnGuardar = new Button("Guardar");
        ventana.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                double monto = Double.parseDouble(txtMonto.getText().trim());
                GregorianCalendar fecha = new GregorianCalendar();

                SolicitudCompra solicitud = new SolicitudCompra(id, fecha, monto, EstadoSolicitud.SOLICITADA);
                solicitudes.add(solicitud);
                taProductos.append("Solicitud agregada: ID " + id + "\n");
                ventana.dispose();
            } catch (NumberFormatException ex) {
                taProductos.append("Error: Datos inválidos para solicitud.\n");
            }
        });

        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void mostrarVentanaAgregarProducto() {
        if (solicitudes.isEmpty()) {
            taProductos.append("Error: No hay solicitudes para agregar productos.\n");
            return;
        }

        Frame ventana = new Frame("Agregar Producto a Solicitud");
        ventana.setLayout(new FlowLayout());

        TextField txtProductoId = new TextField(10);
        TextField txtCantidad = new TextField(10);

        ventana.add(new Label("ID Producto:"));
        ventana.add(txtProductoId);
        ventana.add(new Label("Cantidad:"));
        ventana.add(txtCantidad);

        Button btnGuardar = new Button("Guardar Producto");
        ventana.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                int productoId = Integer.parseInt(txtProductoId.getText().trim());
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                double precio = 10.0;

                SolicitudCompra ultima = solicitudes.get(solicitudes.size() - 1);
                DetalleDeCompra detalle = new DetalleDeCompra(productoId, cantidad, precio, "Ninguna");
                ultima.addDetalleDeCompras(detalle);

                taProductos.append("Producto agregado a solicitud ID " + ultima.getId() + ": Producto ID " + productoId + ", Cantidad " + cantidad + "\n");
                ventana.dispose();
            } catch (NumberFormatException ex) {
                taProductos.append("Error: Datos inválidos para producto.\n");
            }
        });

        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void mostrarVentanaCambiarEstado() {
        if (solicitudes.isEmpty()) {
            taProductos.append("No hay solicitudes para cambiar estado.\n");
            return;
        }

        Frame ventana = new Frame("Cambiar Estado de Solicitud");
        ventana.setLayout(new FlowLayout());

        Button btnAprobar = new Button("Aprobar");
        Button btnRechazar = new Button("Rechazar");

        ventana.add(new Label("Selecciona una acción para la última solicitud:"));
        ventana.add(btnAprobar);
        ventana.add(btnRechazar);

        btnAprobar.addActionListener(e -> {
            SolicitudCompra ultima = solicitudes.get(solicitudes.size() - 1);
            ultima.setEstadoSolicitud(EstadoSolicitud.APROBADA);
            taProductos.append("Solicitud ID " + ultima.getId() + " APROBADA.\n");
            ventana.dispose();
        });

        btnRechazar.addActionListener(e -> {
            SolicitudCompra ultima = solicitudes.get(solicitudes.size() - 1);
            ultima.setEstadoSolicitud(EstadoSolicitud.RECHAZADA);
            taProductos.append("Solicitud ID " + ultima.getId() + " RECHAZADA.\n");
            ventana.dispose();
        });

        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
