package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ProductoConIVA;
import ec.edu.ups.poo.clases.ProductoSinIVA;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductoView {
    private Frame frame;
    private TextField txtCodigo, txtNombre, txtDescripcion, txtPrecio, txtCategoria, txtStock;
    private TextArea areaResultado;
    private List<Producto> productos;
    private CheckboxGroup tipoIVA;
    private Checkbox cbConIVA, cbSinIVA;

    public ProductoView() {
        productos = new ArrayList();
        crearInterfaz();
    }

    private void crearInterfaz() {
        frame = new Frame("Gestión de Productos");
        frame.setLayout(new BorderLayout(5, 5));
        frame.setSize(450, 550);
        frame.setLocationRelativeTo(null);

        Panel panelCampos = new Panel(new GridLayout(7, 2, 5, 5));

        panelCampos.add(new Label("Código:"));
        txtCodigo = new TextField();
        panelCampos.add(txtCodigo);

        panelCampos.add(new Label("Nombre:"));
        txtNombre = new TextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new Label("Descripción:"));
        txtDescripcion = new TextField();
        panelCampos.add(txtDescripcion);

        panelCampos.add(new Label("Precio:"));
        txtPrecio = new TextField();
        panelCampos.add(txtPrecio);

        panelCampos.add(new Label("Categoría:"));
        txtCategoria = new TextField();
        panelCampos.add(txtCategoria);

        panelCampos.add(new Label("Stock:"));
        txtStock = new TextField();
        panelCampos.add(txtStock);

        panelCampos.add(new Label("Tipo de Producto:"));
        Panel panelIVA = new Panel(new FlowLayout(FlowLayout.LEFT));
        tipoIVA = new CheckboxGroup();
        cbConIVA = new Checkbox("Con IVA", tipoIVA, true);
        cbSinIVA = new Checkbox("Sin IVA", tipoIVA, false);
        panelIVA.add(cbConIVA);
        panelIVA.add(cbSinIVA);
        panelCampos.add(panelIVA);

        Panel panelBotones = new Panel(new GridLayout(1, 5, 5, 5)); // Cambiado a 5 columnas
        Button btnAgregar = new Button("Agregar");
        Button btnLimpiar = new Button("Limpiar");
        Button btnMostrar = new Button("Mostrar");
        Button btnListar = new Button("Listar"); // Nuevo botón
        Button btnSalir = new Button("Salir");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnListar); // Agregado nuevo botón
        panelBotones.add(btnSalir);

        areaResultado = new TextArea(8, 40);
        areaResultado.setEditable(false);

        frame.add(panelCampos, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.CENTER);
        frame.add(areaResultado, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarProducto());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnMostrar.addActionListener(e -> mostrarProductos());
        btnListar.addActionListener(e -> mostrarListaProductos());
        btnSalir.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void agregarProducto() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            String categoria = txtCategoria.getText();
            int stock = Integer.parseInt(txtStock.getText());

            Producto producto;
            String tipoProducto;
            if (cbConIVA.getState()) {
                producto = new ProductoConIVA(codigo, nombre, descripcion, precio, categoria, stock);
                tipoProducto = "Con IVA";
            } else {
                producto = new ProductoSinIVA(codigo, nombre, descripcion, precio, categoria, stock);
                tipoProducto = "Sin IVA";
            }

            productos.add(producto);

            DecimalFormat df = new DecimalFormat("#.##");
            String resultado = "Producto agregado:\n" +
                    producto.toString() + "\n" +
                    "Tipo: " + tipoProducto + "\n" +
                    "Precio final: $" + df.format(producto.calcularPrecioFinal());

            areaResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            areaResultado.setText("Error: Los campos numéricos deben contener valores válidos");
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCategoria.setText("");
        txtStock.setText("");
        cbConIVA.setState(true);
    }

    private void mostrarProductos() {
        if (productos.size() == 0) {
            areaResultado.setText("No hay productos registrados");
            return;
        }

        String resultado = "";
        for (Producto p : productos) {
            resultado += p.toString() + "\nPrecio final: $" + p.calcularPrecioFinal() + "\n\n";
        }
        areaResultado.setText(resultado);
    }

    private void mostrarListaProductos() {
        if (productos.isEmpty()) {
            areaResultado.setText("No hay productos registrados");
            return;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        StringBuilder lista = new StringBuilder("LISTA DE PRODUCTOS\n\n");

        for (Producto p : productos) {
            lista.append("--------------------------------\n").append(p.toString()).append("\nTipo: ").append(p instanceof ProductoConIVA ? "Con IVA" : "Sin IVA").append("\nPrecio final: $").append(df.format(p.calcularPrecioFinal())).append("\n\n");
        }

        Frame frameLista = new Frame("Lista de Productos");
        TextArea taLista = new TextArea(lista.toString(), 20, 60, TextArea.SCROLLBARS_VERTICAL_ONLY);
        taLista.setEditable(false);

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> frameLista.dispose());

        frameLista.add(taLista, BorderLayout.CENTER);
        frameLista.add(btnCerrar, BorderLayout.SOUTH);
        frameLista.pack();
        frameLista.setVisible(true);
        frameLista.setSize(200, 300);
        frameLista.setLocationRelativeTo(null);
    }
}