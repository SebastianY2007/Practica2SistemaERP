package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.Proveedor;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ProveedorView {
    private Frame frame;
    private TextField txtNombre, txtApellido, txtRuc, txtTelefono, txtCorreo, txtId;
    private TextArea resumen;
    private List<Proveedor> proveedores;

    public ProveedorView(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
        crearInterfaz();
    }

    private void crearInterfaz() {
        frame = new Frame("Gestión de Proveedores");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        Panel panelCampos = new Panel(new GridLayout(6, 2, 5, 5));

        panelCampos.add(new Label("Nombre:"));
        txtNombre = new TextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new Label("Apellido:"));
        txtApellido = new TextField();
        panelCampos.add(txtApellido);

        panelCampos.add(new Label("RUC:"));
        txtRuc = new TextField();
        panelCampos.add(txtRuc);

        panelCampos.add(new Label("Teléfono:"));
        txtTelefono = new TextField();
        panelCampos.add(txtTelefono);

        panelCampos.add(new Label("Correo Electrónico:"));
        txtCorreo = new TextField();
        panelCampos.add(txtCorreo);

        panelCampos.add(new Label("ID Proveedor:"));
        txtId = new TextField();
        panelCampos.add(txtId);

        Panel panelBotones = new Panel(new FlowLayout());
        Button btnAgregar = new Button("Agregar");
        Button btnLimpiar = new Button("Limpiar");
        Button btnSalir = new Button("Salir");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        resumen = new TextArea(10, 50);
        resumen.setEditable(false);

        frame.add(panelCampos, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.CENTER);
        frame.add(resumen, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarProveedor());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void agregarProveedor() {
        try {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String ruc = txtRuc.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            int id = Integer.parseInt(txtId.getText());

            Proveedor p = new Proveedor(nombre, apellido, telefono, correo, id, ruc);
            proveedores.add(p);

            resumen.setText(p.toString());
        } catch (NumberFormatException e) {
            resumen.setText("Error: ID debe ser un número válido");
        } catch (Exception e) {
            resumen.setText("Error: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtRuc.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtId.setText("");
    }
}