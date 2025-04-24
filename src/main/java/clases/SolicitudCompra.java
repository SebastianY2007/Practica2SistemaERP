package clases;

import enums.EstadoSolicitud;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SolicitudCompra {
    private int id;
    private GregorianCalendar fechaSolicitud;
    private List<Producto> productos;
    private double montoTotal;
    private Empleado solicitante;
    private EstadoSolicitud estadoSolicitud;
    private GregorianCalendar fechaDeAprobacion;

    public SolicitudCompra(int id, GregorianCalendar fechaSolicitud, List<DetalleDeCompra> productos, double montoTotal, Empleado solicitante, EstadoSolicitud estadoSolicitud, GregorianCalendar fechaDeAprobacion) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.productos = new ArrayList<Producto>();
        this.montoTotal = montoTotal;
        this.solicitante = solicitante;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaDeAprobacion = fechaDeAprobacion;
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

    public void addProductos(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public GregorianCalendar getFechaDeAprobacion() {
        return fechaDeAprobacion;
    }

    public void setFechaDeAprobacion(GregorianCalendar fechaDeAprobacion) {
        this.fechaDeAprobacion = fechaDeAprobacion;
    }
}