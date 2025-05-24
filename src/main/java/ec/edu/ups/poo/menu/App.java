package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.menu.PersonaView;
import ec.edu.ups.poo.menu.ProductoConIvaView;
import ec.edu.ups.poo.menu.ProductoSinIvaView;
import ec.edu.ups.poo.menu.SolicitudCompraView;
import ec.edu.ups.poo.clases.SolicitudCompra;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private Frame framePrincipal;
    private Button btnPersonas;
    private Button btnProductos;
    private Button btnProductosSinIva;
    private Button btnSolicitudes;

    private List<SolicitudCompra> solicitudes;

    public App() {
        solicitudes = new ArrayList<>();
        construirUI();
    }

    private void construirUI() {
        framePrincipal = new Frame("Aplicación Principal");
        framePrincipal.setLayout(new FlowLayout());

        btnPersonas = new Button("Gestión de Personas");
        btnProductos = new Button("Gestión de Productos con IVA");
        btnProductosSinIva = new Button("Gestión de Productos sin IVA");
        btnSolicitudes = new Button("Gestión de Solicitudes de Compra");

        framePrincipal.add(btnPersonas);
        framePrincipal.add(btnProductos);
        framePrincipal.add(btnProductosSinIva);
        framePrincipal.add(btnSolicitudes);

        btnPersonas.addActionListener(e -> new PersonaView());
        btnProductos.addActionListener(e -> new ProductoConIvaView());
        btnProductosSinIva.addActionListener(e -> new ProductoSinIvaView());
        btnSolicitudes.addActionListener(e -> new SolicitudCompraView(solicitudes));

        framePrincipal.setSize(400, 180);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);

        framePrincipal.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                framePrincipal.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new App();
    }
}
