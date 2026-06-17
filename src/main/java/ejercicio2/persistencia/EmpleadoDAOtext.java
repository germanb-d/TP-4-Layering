package ejercicio2.persistencia;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.EmpleadoDAO;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOtext implements EmpleadoDAO {
    @Override
    public void guardarEmpleado(Empleado empleado) {

        String linea = String.format("%s,%s,%s,%s%n", empleado.getApellido(), empleado.getNombre(), empleado.getFechaNacimiento(), empleado.getEmail());

        try (FileWriter fw = new FileWriter("empleados.txt", true)) {

            fw.write(linea);

        } catch (IOException e) {

            throw new RuntimeException("Error guardando empleado", e);
        }
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String apellido = partes[0];
                String nombre = partes[1];
                LocalDate fechaNacimiento = LocalDate.parse(partes[2]);
                String email = partes[3];
                empleados.add(new Empleado(apellido, nombre, fechaNacimiento, email));
            }
        } catch (FileNotFoundException e) {
            // si el archivo no existe todavía, devolvemos lista vacía
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo los empleados", e);
        }

        return empleados;
    }
}
