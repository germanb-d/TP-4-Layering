package ejercicio2.modelo;

import java.util.ArrayList;
import java.util.List;

public interface EmpleadoDAO {

    void guardarEmpleado(Empleado empleado);

    List<Empleado> obtenerEmpleados();
}

