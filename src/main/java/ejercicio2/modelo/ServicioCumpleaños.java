package ejercicio2.modelo;

import java.util.ArrayList;
import java.util.List;

public class ServicioCumpleaños {
    public static final String ASUNTO = "Feliz cumpleaños";
    public static final String CUERPO = "Te deseamos un feliz cumpleaños";
    private EmpleadoDAO empleadoDAO;
    private ServicioEmail servicioEmail;

    public ServicioCumpleaños(EmpleadoDAO empleadoDAO, ServicioEmail servicioEmail) {
        this.empleadoDAO = empleadoDAO;
        this.servicioEmail = servicioEmail;
    }

    ;

    public void mandarFelizCumple() {
        List<Empleado> empleados = this.empleadoDAO.obtenerEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado.cumpleHoy()) { // tambien podria pedirse un localdate y hacer q funcione aun con dias distintos al de hoy. Pero creo q por la consigna y logica (solo hoy es su cumple) seria q solo funcione con la fecha de hoy
                servicioEmail.mandarEmail(empleado.getEmail(), ASUNTO, CUERPO);
            }
        }
    }
}
