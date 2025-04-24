package clases;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Empleado extends Persona{
    private int sueldo;
    private String cedula;
    private GregorianCalendar fechaDeIngreso;
    private String nivelEducativo;
    private Departamento departamento;

    public Empleado(String nombre, String apellido, String identificacion, String telefono, String correoElectronico, int sueldo, String cedula, GregorianCalendar fechaDeIngreso, String nivelEducativo, Departamento departamento) {
        super(nombre, apellido, identificacion, telefono, correoElectronico);
        this.sueldo = sueldo;
        this.cedula = cedula;
        this.fechaDeIngreso = fechaDeIngreso;
        this.nivelEducativo = nivelEducativo;
        this.departamento = departamento;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public GregorianCalendar getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(GregorianCalendar fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return sueldo == empleado.sueldo && Objects.equals(cedula, empleado.cedula) && Objects.equals(fechaDeIngreso, empleado.fechaDeIngreso) && Objects.equals(nivelEducativo, empleado.nivelEducativo) && Objects.equals(departamento, empleado.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sueldo, cedula, fechaDeIngreso, nivelEducativo, departamento);
    }

    @Override
    public String toString() {
        return "Sueldo: " + sueldo +
                "\nCedula: " + cedula +
                "\nFecha De Ingreso: " + fechaDeIngreso +
                "\nNivel Educativo: " + nivelEducativo +
                "\nDepartamento: " + departamento;
    }
}