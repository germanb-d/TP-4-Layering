package ejercicio2.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public boolean cumple(LocalDate fecha) {
        return fecha.isEqual(this.fechaNacimiento);
    }

    public boolean cumpleHoy() {
        //return cumple(LocalDate.now());
        return LocalDate.now().getDayOfMonth() == this.fechaNacimiento.getDayOfMonth() && LocalDate.now().getMonth() == this.fechaNacimiento.getMonth();
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(fechaNacimiento, empleado.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, fechaNacimiento);
    }
}
