package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.enums.EstadoSolicitud;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
        ArrayList<Producto> productos = new ArrayList<Producto>();
        ArrayList<SolicitudCompra> solicitudes = new ArrayList<SolicitudCompra>();

        int opcion = 0;

        while (opcion != 15) {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Registrar producto");
            System.out.println("3. Registrar solicitud de compra");
            System.out.println("4. Listar proveedores");
            System.out.println("5. Listar productos");
            System.out.println("6. Listar solicitudes de compra");
            System.out.println("7. Buscar proveedor por ID");
            System.out.println("8. Buscar producto por nombre");
            System.out.println("9. Buscar solicitud por número");
            System.out.println("10. Aprobar / Rechazar solicitud de compra");
            System.out.println("11. Calcular total de una solicitud");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("\n--- Registrar proveedor ---");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();
                System.out.print("Identificacion: ");
                String identificacion = scanner.nextLine();
                System.out.print("Telefono: ");
                String telefono = scanner.nextLine();
                System.out.print("Correo Electronico: ");
                String correo = scanner.nextLine();
                Proveedor proveedor = new Proveedor(nombre, apellido, identificacion, telefono, correo);
                System.out.print("ID Proveedor: ");
                int idProveedor = scanner.nextInt();
                scanner.nextLine();
                System.out.print("RUC: ");
                String ruc = scanner.nextLine();
                proveedor.setIdProveedor(idProveedor);
                proveedor.setRuc(ruc);
                proveedores.add(proveedor);
                System.out.println("Proveedor registrado con éxito.");
            }
            else if (opcion == 2) {
                System.out.println("\n--- Registrar producto ---");
                System.out.print("Codigo: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Descripcion: ");
                String descripcion = scanner.nextLine();
                System.out.print("Precio: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();
                System.out.print("Stock: ");
                int stock = scanner.nextInt();
                scanner.nextLine();
                System.out.print("¿Tiene IVA? (si/no): ");
                String respuesta = scanner.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    ProductoConIva producto = new ProductoConIva(codigo, nombre, descripcion, precio, categoria, stock);
                    productos.add(producto);
                } else {
                    ProductoSinIva producto = new ProductoSinIva(codigo, nombre, descripcion, precio, categoria, stock);
                    productos.add(producto);
                }
                System.out.println("Producto registrado con éxito.");
            }
            else if (opcion == 3) {
                System.out.println("\n--- Registrar solicitud de compra ---");
                System.out.print("ID de la solicitud: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                GregorianCalendar fecha = new GregorianCalendar();
                ArrayList<DetalleDeCompra> detalles = new ArrayList<DetalleDeCompra>();
                double montoTotal = 0;

                System.out.print("Cantidad de productos a agregar: ");
                int cantidadProductos = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < cantidadProductos; i++) {
                    System.out.print("Codigo del producto: ");
                    int codigoProducto = scanner.nextInt();
                    scanner.nextLine();
                    Producto productoEncontrado = null;
                    for (int j = 0; j < productos.size(); j++) {
                        if (productos.get(j).getCodigo() == codigoProducto) {
                            productoEncontrado = productos.get(j);
                            break;
                        }
                    }
                    if (productoEncontrado != null) {
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Precio Unitario: ");
                        double precioUnitario = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Observaciones: ");
                        String observaciones = scanner.nextLine();
                        DetalleDeCompra detalle = new DetalleDeCompra(id, cantidad, precioUnitario, observaciones, productoEncontrado);
                        detalles.add(detalle);
                        montoTotal += cantidad * precioUnitario;
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                }

                SolicitudCompra solicitud = new SolicitudCompra(id, fecha, montoTotal, EstadoSolicitud.SOLICITADA);
                for (int i = 0; i < detalles.size(); i++) {
                    solicitud.addDetalleDeCompras(detalles.get(i));
                }
                solicitudes.add(solicitud);
                System.out.println("Solicitud de compra registrada.");
            }
            else if (opcion == 4) {
                System.out.println("\n--- Listar proveedores ---");
                for (int i = 0; i < proveedores.size(); i++) {
                    System.out.println(proveedores.get(i));
                }
            }
            else if (opcion == 5) {
                System.out.println("\n--- Listar productos ---");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println(productos.get(i));
                }
            }
            else if (opcion == 6) {
                System.out.println("\n--- Listar solicitudes de compra ---");
                for (int i = 0; i < solicitudes.size(); i++) {
                    System.out.println(solicitudes.get(i));
                }
            }
            else if (opcion == 7) {
                System.out.println("\n--- Buscar proveedor por ID ---");
                System.out.print("Ingrese ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < proveedores.size(); i++) {
                    if (proveedores.get(i).getIdProveedor() == id) {
                        System.out.println(proveedores.get(i));
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Proveedor no encontrado.");
                }
            }
            else if (opcion == 8) {
                System.out.println("\n--- Buscar producto por nombre ---");
                System.out.print("Ingrese nombre: ");
                String nombre = scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println(productos.get(i));
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Producto no encontrado.");
                }
            }
            else if (opcion == 9) {
                System.out.println("\n--- Buscar solicitud por número ---");
                System.out.print("Ingrese número de solicitud: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < solicitudes.size(); i++) {
                    if (solicitudes.get(i).getId() == id) {
                        System.out.println(solicitudes.get(i));
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Solicitud no encontrada.");
                }
            }
            else if (opcion == 10) {
                System.out.println("\n--- Aprobar / Rechazar solicitud de compra ---");
                System.out.print("Ingrese número de solicitud: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < solicitudes.size(); i++) {
                    if (solicitudes.get(i).getId() == id) {
                        System.out.print("¿Aprobar (a) o Rechazar (r)?: ");
                        String decision = scanner.nextLine();
                        if (decision.equals("a")) {
                            solicitudes.get(i).setEstadoSolicitud(EstadoSolicitud.APROBADA);
                        } else if (decision.equals("r")) {
                            solicitudes.get(i).setEstadoSolicitud(EstadoSolicitud.RECHAZADA);
                        }
                        System.out.println("Estado actualizado.");
                        break;
                    }
                }
            }
            else if (opcion == 11) {
                System.out.println("\n--- Calcular total de una solicitud ---");
                System.out.print("Ingrese número de solicitud: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < solicitudes.size(); i++) {
                    if (solicitudes.get(i).getId() == id) {
                        System.out.println("Monto total: " + solicitudes.get(i).getMontoTotal());
                        break;
                    }
                }
            }
            else if (opcion == 12) {
                System.out.println("Saliendo del sistema...");
                break;
            }
            else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
