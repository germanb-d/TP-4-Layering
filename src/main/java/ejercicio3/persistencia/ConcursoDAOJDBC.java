package ejercicio3.persistencia;

import ejercicio3.modelo.Concurso;
import ejercicio3.modelo.ConcursoDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursoDAOJDBC implements ConcursoDAO {

    @Override
    public List<Concurso> todosLosConcursos() {
        List<Concurso> concursos = new ArrayList<>();
        String query = "SELECT id_concurso, nombre, fecha_inicio_inscripcion, fecha_fin_inscripcion FROM concurso";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_concurso");
                String nombre = rs.getString("nombre");
                LocalDate inicio = rs.getDate("fecha_inicio_inscripcion").toLocalDate();
                LocalDate fin = rs.getDate("fecha_fin_inscripcion").toLocalDate();

                Concurso concurso = new Concurso(id, nombre, inicio, fin);
                if (concurso.estaAbierto()) {
                    concursos.add(concurso);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar concursos en la BD", e);
        }
        return concursos;
    }
}