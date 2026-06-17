package ejercicio3.Main;


import ejercicio3.modelo.*;
import ejercicio3.persistencia.*;
import ejercicio3.vista.*;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        //ConcursoDAO concurso = new ConcursoDAOtext();
        //InscriptoDAO inscripto = new InscriptoDAOtext();
        ConcursoDAO concurso = new ConcursoDAOJDBC();
        InscriptoDAO inscripto = new InscriptoDAOJDBC();
        lanzarAplicacion(concurso, inscripto);
    }

    private static void lanzarAplicacion(ConcursoDAO concurso, InscriptoDAO inscripto) {
        EventQueue.invokeLater(() -> {
            try {
                new VistaRegistro(concurso, inscripto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}