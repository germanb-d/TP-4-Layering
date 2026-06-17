package ejercicio2.main;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.EmpleadoDAO;
import ejercicio2.modelo.ServicioCumpleaños;
import ejercicio2.modelo.ServicioEmail;
import ejercicio2.persistencia.EmpleadoDAOtext;
import ejercicio2.persistencia.MailTrap;

import java.time.LocalDate;

//public class main { //Ya se puede probar con el test
//    public static void main(String[] args) {
//      EmpleadoDAO registroEmpleados = new EmpleadoDAOtext();
//      Empleado empleado1 = new Empleado("Juan", "Perez", LocalDate.now().minusYears(40), "juan.perez@gmail.com");
//       registroEmpleados.guardarEmpleado(empleado1);
//       ServicioEmail mailSerivice = new MailTrap("sandbox.smtp.mailtrap.io", 587, "05383d2a787f02", "la contraseña iria aca");
//       ServicioCumpleaños servicioCumpleaños = new ServicioCumpleaños(registroEmpleados, mailSerivice);
//       servicioCumpleaños.mandarFelizCumple();
//    }
//}
