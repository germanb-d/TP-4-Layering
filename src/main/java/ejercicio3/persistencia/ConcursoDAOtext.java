package ejercicio3.persistencia;

import ejercicio3.modelo.Concurso;
import ejercicio3.modelo.ConcursoDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConcursoDAOtext implements ConcursoDAO {

    @Override
    public List<Concurso> todosLosConcursos() {
        List<Concurso> concursos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // concursos.txt ni se agerga nada ni tampoco se edita, solo se leen entonces lo dejo en resources
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("concursos"); //esto tuve que buscar para saber como acceder al archivo de concursos si se encontraba en resources
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) { // "new InputStreamReader(is) convierte ese flujo de bytes (InputStream) en un flujo de caracteres."

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0].trim()); //el trim porque si usamos el txt tal cual esta en el tp, hay un espacio entre cada dato
                String nombre = partes[1].trim();
                LocalDate inicio = LocalDate.parse(partes[2].trim(), formatter);
                LocalDate fin = LocalDate.parse(partes[3].trim(), formatter);

                Concurso concurso = new Concurso(id, nombre, inicio, fin);
                if (concurso.estaAbierto()) { // sino devolvia todos, cuando muchos de ellos estaban cerrados
                    concursos.add(concurso);
                }
                //concursos.add(new Concurso(id, nombre, inicio, fin));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error leyendo concursos.txt", e);
        }

        return concursos;
    }

}
