package ejercicio3.persistencia;

import ejercicio3.modelo.Inscripto;
import ejercicio3.modelo.InscriptoDAO;

import java.io.FileWriter;
import java.io.IOException;

public class InscriptoDAOtext implements InscriptoDAO {

    @Override
    public void saveInscription(Inscripto inscripto, int concursoId) {
        String linea = String.format("%s, %s, %s, %s, %d%n", inscripto.getApellido(), inscripto.getNombre(), inscripto.getTelefono(), inscripto.getEmail(), concursoId);

        try (FileWriter fw = new FileWriter("inscriptos.txt", true)) {
            fw.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error guardando inscripto en texto", e);
        }
    }
}
