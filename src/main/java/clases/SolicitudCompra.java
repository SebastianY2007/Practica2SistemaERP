    package clases;

    import enums.EstadoSolicitud;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.GregorianCalendar;
    import java.util.List;

    public class SolicitudCompra {
        private int id;
        private GregorianCalendar fechaSolicitud;
        private List<DetalleDeCompra> detalleDeCompras;
        private double montoTotal;
        private EstadoSolicitud estadoSolicitud;

        public SolicitudCompra(int id, GregorianCalendar fechaSolicitud, double montoTotal, EstadoSolicitud estadoSolicitud) {
            this.id = id;
            this.fechaSolicitud = fechaSolicitud;
            this.detalleDeCompras = new ArrayList<DetalleDeCompra>();
            this.montoTotal = montoTotal;
            this.estadoSolicitud = estadoSolicitud;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public GregorianCalendar getFechaSolicitud() {
            return fechaSolicitud;
        }

        public void setFechaSolicitud(GregorianCalendar fechaSolicitud) {
            this.fechaSolicitud = fechaSolicitud;
        }

        public void addDetalleDeCompras(DetalleDeCompra detalleDeCompra) {
            detalleDeCompras.add(detalleDeCompra);
        }

        public List<DetalleDeCompra> getDetalleDeCompraas() {
            return detalleDeCompras;
        }

        public double getMontoTotal() {
            return montoTotal;
        }

        public void setMontoTotal(double montoTotal) {
            this.montoTotal = montoTotal;
        }

        public EstadoSolicitud getEstadoSolicitud() {
            return estadoSolicitud;
        }

        public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
            this.estadoSolicitud = estadoSolicitud;
        }

        @Override
        public String toString() {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String productosIngresados = "";
            for (int i = 0; i < detalleDeCompras.size(); i++) {
                DetalleDeCompra detalle = detalleDeCompras.get(i);
                productosIngresados += "- " + detalle.getProducto().getNombre() +
                        " (Cantidad: " + detalle.getCantidad() +
                        ", Precio Unitario: $" + detalle.getPrecioUnitario() +
                        ", Observaciones: " + detalle.getObservaciones() + ")";
            }

            return "\nID: " + id +
                    "\nFecha de Solicitud: " + formato.format(fechaSolicitud.getTime()) +
                    "\nProductos:\n" + productosIngresados +
                    "\nMonto Total: $" + montoTotal +
                    "\nEstado de Solicitud: " + estadoSolicitud;
        }
    }
