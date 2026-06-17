package ejercicio1.persistencia;

import ejercicio1.modelo.ParticipanteDAO;
import ejercicio1.modelo.Participante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteDAOJDBC implements ParticipanteDAO {
    private final Conexion conexion;

    public ParticipanteDAOJDBC(Conexion Conexion) {
        this.conexion = Conexion;
    }

    @Override
    public void guardarParticipante(Participante participante) {
        String sql = "insert into participantes(nombre, telefono, region) values( ?, ?,?)";
        try (Connection conexion2 = conexion.conectar(); PreparedStatement st = conexion2.prepareStatement(sql)) { //asi saco el close
            //en si capaz seria mejor pasar el connection por constructor, pero como no se manejan transacciones ni nada asi y es solo un DAO lo dejo asi
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error guardando al participante", e);

        }

    }
}

