package ejercicio2;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.EmpleadoDAO;
import ejercicio2.modelo.ServicioCumpleaños;
import ejercicio2.modelo.ServicioEmail;
import ejercicio2.persistencia.FakeEmpleadoDAOtext;
import ejercicio2.persistencia.FakeMailTrap;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestCumpleaños {

    @Test
    public void testCumpleaños() {
        EmpleadoDAO registroEmpleados = new FakeEmpleadoDAOtext();
        Empleado empleado1 = new Empleado("Juan", "Perez", LocalDate.now().minusYears(40), "juan.perez@gmail.com");
        registroEmpleados.guardarEmpleado(empleado1);
        ServicioEmail mailSerivice = new FakeMailTrap();
        ServicioCumpleaños servicioCumpleaños = new ServicioCumpleaños(registroEmpleados, mailSerivice);
        servicioCumpleaños.mandarFelizCumple();
        assertEquals(1, registroEmpleados.obtenerEmpleados().size());
        assertEquals(empleado1, registroEmpleados.obtenerEmpleados().getFirst());

        assertEquals("juan.perez@gmail.com", mailSerivice.retornarMail());

    }
}
