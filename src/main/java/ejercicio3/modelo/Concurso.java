package ejercicio3.modelo;

import java.time.LocalDate;

public class Concurso {
    public int getId() {
        return id;
    }

    private int id;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso(int id, String nombre, LocalDate inicio, LocalDate fin) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre de concurso inválido");
        }
        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("Fechas inválidas");
        }
        if (fin.isBefore(inicio)) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la de inicio");
        }

        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = inicio;
        this.fechaFinInscripcion = fin;
    }

    public boolean estaAbierto() {
        LocalDate hoy = LocalDate.now();
        return (hoy.isEqual(fechaInicioInscripcion) || hoy.isAfter(fechaInicioInscripcion))
                && (hoy.isEqual(fechaFinInscripcion) || hoy.isBefore(fechaFinInscripcion));
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}