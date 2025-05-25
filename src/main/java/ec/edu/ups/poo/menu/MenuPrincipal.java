package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.DetalleDeCompra;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.clases.SolicitudCompra;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {
    private Frame frame;
    private List<DetalleDeCompra> detallesCompra;
    private List<Proveedor> proveedores;
    private List<SolicitudCompra> solicitudes;

    public static void main(String[] args) {
        new MenuPrincipal();
    }

    public MenuPrincipal() {
        detallesCompra = new ArrayList<>();
        proveedores = new ArrayList<>();
        solicitudes = new ArrayList<>();
        crearInterfaz();
    }

    private void crearInterfaz() {
        frame = new Frame("Sistema de Gestión - Menú Principal");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);

        Panel panelTitulo = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label titulo = new Label("SISTEMA DE GESTIÓN", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelTitulo.add(titulo);
        frame.add(panelTitulo, BorderLayout.NORTH);

        Panel panelBotones = new Panel(new GridLayout(4, 1, 10, 10));

        Button btnPersonas = new Button("Gestión de Personas");
        Button btnProductos = new Button("Gestión de Productos");
        Button btnProductosConIVA = new Button("Productos con IVA");
        Button btnProductosSinIVA = new Button("Productos sin IVA");
        Button btnProveedores = new Button("Gestión de Proveedores");
        Button btnDetallesCompra = new Button("Detalles de Compra");
        Button btnSolicitudes = new Button("Solicitudes de Compra");
        Button btnSalir = new Button("Salir del Sistema");

        panelBotones.add(btnPersonas);
        panelBotones.add(btnProductos);
        panelBotones.add(btnProductosConIVA);
        panelBotones.add(btnProductosSinIVA);
        panelBotones.add(btnProveedores);
        panelBotones.add(btnDetallesCompra);
        panelBotones.add(btnSolicitudes);
        panelBotones.add(btnSalir);

        frame.add(panelBotones, BorderLayout.CENTER);

        btnPersonas.addActionListener(e -> new PersonaView());
        btnProductos.addActionListener(e -> new ProductoView());
        btnProductosConIVA.addActionListener(e -> new ProductoConIvaView());
        btnProductosSinIVA.addActionListener(e -> new ProductoSinIvaView());
        btnProveedores.addActionListener(e -> new ProveedorView(proveedores));
        btnDetallesCompra.addActionListener(e -> new DetalleDeCompraView(detallesCompra));
        btnSolicitudes.addActionListener(e -> new SolicitudCompraView(solicitudes));

        btnSalir.addActionListener(e -> System.exit(0));

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}