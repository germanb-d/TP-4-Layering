package ejercicio1.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/participantes";
    public static final String USER = "root";
    public static final String PASSWORD = "German113";
    private Connection dbConn;


//    private void setupBaseDeDatos() throws SQLException {
//        String url = "jdbc:derby://localhost:1527/participantes";
//        String user = "app";
//        String password = "app";
//        this.dbConn = DriverManager.getConnection(url, user, password);
//    }
    
    public Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("error con la base de datos", e);
        }
    }
}
