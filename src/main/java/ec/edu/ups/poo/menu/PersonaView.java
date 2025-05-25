package ec.edu.ups.poo.menu;

import ec.edu.ups.poo.clases.Persona;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaView {

    private Frame frame;
    private TextArea Resumen;
    private Button btnAgregarPersona;
    private Button btnMostrarPersonas;

    private List<Persona> personas;

    public PersonaView() {
        personas = new ArrayList<>();
        construirUI();
    }

    private void construirUI() {
        frame = new Frame("Gestión de Personas");
        frame.setLayout(new FlowLayout());

        Resumen = new TextArea(10, 50);
        Resumen.setEditable(false);
        frame.add(new Label("Personas registradas:"));
        frame.add(Resumen);

        btnAgregarPersona = new Button("Agregar Persona");
        btnMostrarPersonas = new Button("Mostrar Personas");

        frame.add(btnAgregarPersona);
        frame.add(btnMostrarPersonas);

        btnAgregarPersona.addActionListener(e -> mostrarVentanaAgregarPersona());
        btnMostrarPersonas.addActionListener(e -> mostrarPersonasRegistradas());

        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    private void mostrarVentanaAgregarPersona() {
        Frame ventana = new Frame("Agregar Persona");
        ventana.setLayout(new GridLayout(6, 2));

        TextField txtNombre = new TextField();
        TextField txtApellido = new TextField();
        TextField txtIdentificacion = new TextField();
        TextField txtTelefono = new TextField();
        TextField txtCorreo = new TextField();

        ventana.add(new Label("Nombre:"));
        ventana.add(txtNombre);
        ventana.add(new Label("Apellido:"));
        ventana.add(txtApellido);
        ventana.add(new Label("Identificación:"));
        ventana.add(txtIdentificacion);
        ventana.add(new Label("Teléfono:"));
        ventana.add(txtTelefono);
        ventana.add(new Label("Correo Electrónico:"));
        ventana.add(txtCorreo);

        Button btnGuardar = new Button("Guardar Persona");
        ventana.add(new Label());
        ventana.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String identificacion = txtIdentificacion.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();

            if (!nombre.isEmpty() && !apellido.isEmpty() && !identificacion.isEmpty()
                    && !telefono.isEmpty() && !correo.isEmpty()) {

                Persona persona = new Persona(nombre, apellido, identificacion, telefono, correo);
                personas.add(persona);
                Resumen.append("Persona registrada:\n" + persona + "\n\n");
                ventana.dispose();
            } else {
                Resumen.append("Error \n");
            }
        });

        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void mostrarPersonasRegistradas() {
        Resumen.setText("");
        if (personas.isEmpty()) {
            Resumen.append("No hay personas registradas.\n");
        } else {
            for (Persona p : personas) {
                Resumen.append(p + "\n-------------------\n");
            }
        }
    }
}
