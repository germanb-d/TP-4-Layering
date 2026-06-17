package ejercicio1.main;

import ejercicio1.modelo.Evento;
import ejercicio1.modelo.ParticipanteDAO;
import ejercicio1.persistencia.Conexion;
import ejercicio1.persistencia.ParticipanteDAOJDBC;
import ejercicio1.vista.ventanaPrincipal;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    private static Conexion jdbc;

    public static void main(String[] args) {

//        inicializarDatabase();
        jdbc = new Conexion(); // Inicializamos el campo estático
        ParticipanteDAO repo = new ParticipanteDAOJDBC(jdbc);
        Evento evento = new Evento(repo);
        lanzarAplicacion(evento);
    }

    private static void lanzarAplicacion(Evento evento) {
        EventQueue.invokeLater(() -> {
            try {
                new ventanaPrincipal(evento);
            } catch (Exception e) {
                System.out.println();
            }
        });
    }

    private static void inicializarDatabase() {
//        jdbc = new Conexion();
//        jdbc.setupBaseDeDatos();
    }
}