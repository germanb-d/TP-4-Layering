package ejercicio3.persistencia;

import ejercicio3.modelo.Inscripto;
import ejercicio3.modelo.InscriptoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscriptoDAOJDBC implements InscriptoDAO {

    @Override
    public void saveInscription(Inscripto inscripto, int concursoId) {
        String query = "INSERT INTO inscripto (dni, apellido, nombre, telefono, email, id_concurso) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, inscripto.getDni());
            ps.setString(2, inscripto.getApellido());
            ps.setString(3, inscripto.getNombre());
            ps.setString(4, inscripto.getTelefono());
            ps.setString(5, inscripto.getEmail());
            ps.setInt(6, concursoId);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la inscripción en la BD", e);
        }
    }
}