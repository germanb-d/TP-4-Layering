package ejercicio2.persistencia;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.EmpleadoDAO;

import java.time.LocalDate;
import java.util.List;

public class FakeEmpleadoDAOtext implements EmpleadoDAO {
    private String nombre;
    private String apellido;
    private String mail;
    private LocalDate fechaNacimiento;

    @Override
    public void guardarEmpleado(Empleado empleado) {
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.mail = empleado.getEmail();
        this.fechaNacimiento = empleado.getFechaNacimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        Empleado e = new Empleado(nombre, apellido, fechaNacimiento, mail);
        return List.of(e);
    }
}
