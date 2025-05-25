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
        btnVerEstado.addActionListener(e -> mostrarVentanaVerEstado());

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

        ventana.add(new Label("ID Solicitud:"));
        ventana.add(txtId);

        Button btnGuardar = new Button("Guardar");
        ventana.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                double monto = 0.0;
                GregorianCalendar fecha = new GregorianCalendar();

                SolicitudCompra solicitud = new SolicitudCompra(id, fecha, monto, EstadoSolicitud.SOLICITADA);
                solicitudes.add(solicitud);
                taProductos.append("Solicitud agregada: ID " + id + "\n");
                ventana.dispose();
            } catch (NumberFormatException ex) {
                taProductos.append("Error: Datos inválidos para solicitud.\n");
            }
        });

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });

        ventana.setSize(300, 120);
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

        ventana.add(new Label("Selecciona la Solicitud por ID:"));
        Choice choice = new Choice();
        for (SolicitudCompra s : solicitudes) {
            choice.add(String.valueOf(s.getId()));
        }
        ventana.add(choice);

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
                int solicitudId = Integer.parseInt(choice.getSelectedItem());
                int productoId = Integer.parseInt(txtProductoId.getText().trim());
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                double precio = 10.0;

                for (SolicitudCompra s : solicitudes) {
                    if (s.getId() == solicitudId) {
                        DetalleDeCompra detalle = new DetalleDeCompra(productoId, cantidad, precio, "Ninguna");
                        s.addDetalleDeCompras(detalle);
                        s.setMontoTotal(s.getMontoTotal() + (cantidad * precio));
                        taProductos.append("Producto agregado a solicitud ID " + solicitudId + ": Producto ID " + productoId + ", Cantidad " + cantidad + "\n");
                        break;
                    }
                }
                ventana.dispose();
            } catch (NumberFormatException ex) {
                taProductos.append("Error: Datos inválidos para producto.\n");
            }
        });

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });

        ventana.setSize(320, 200);
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

        ventana.add(new Label("Seleccione una Solicitud por ID:"));

        Choice choice = new Choice();
        for (SolicitudCompra s : solicitudes) {
            choice.add(String.valueOf(s.getId()));
        }
        ventana.add(choice);

        Button btnAprobar = new Button("Aprobar");
        Button btnRechazar = new Button("Rechazar");

        ventana.add(btnAprobar);
        ventana.add(btnRechazar);

        btnAprobar.addActionListener(e -> {
            int id = Integer.parseInt(choice.getSelectedItem());
            for (SolicitudCompra s : solicitudes) {
                if (s.getId() == id) {
                    s.setEstadoSolicitud(EstadoSolicitud.APROBADA);
                    taProductos.append("Solicitud ID " + id + " APROBADA.\n");
                    break;
                }
            }
            ventana.dispose();
        });

        btnRechazar.addActionListener(e -> {
            int id = Integer.parseInt(choice.getSelectedItem());
            for (SolicitudCompra s : solicitudes) {
                if (s.getId() == id) {
                    s.setEstadoSolicitud(EstadoSolicitud.RECHAZADA);
                    taProductos.append("Solicitud ID " + id + " RECHAZADA.\n");
                    break;
                }
            }
            ventana.dispose();
        });

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });

        ventana.setSize(300, 200);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void mostrarVentanaVerEstado() {
        if (solicitudes.isEmpty()) {
            taProductos.append("No hay solicitudes registradas.\n");
            return;
        }

        Frame ventana = new Frame("Ver Estado de Solicitud");
        ventana.setLayout(new FlowLayout());

        ventana.add(new Label("Seleccione una Solicitud por ID:"));

        Choice choice = new Choice();
        for (SolicitudCompra s : solicitudes) {
            choice.add(String.valueOf(s.getId()));
        }
        ventana.add(choice);

        Button btnVer = new Button("Ver Estado");
        ventana.add(btnVer);

        btnVer.addActionListener(e -> {
            int id = Integer.parseInt(choice.getSelectedItem());
            for (SolicitudCompra s : solicitudes) {
                if (s.getId() == id) {
                    taProductos.append("Estado actual de la solicitud ID " + id + ": " + s.getEstadoSolicitud() + "\n");
                    break;
                }
            }
            ventana.dispose();
        });

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });

        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
