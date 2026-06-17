package ejercicio1.modelo;

public class Evento {
    private ParticipanteDAO guardados;

    public Evento(ParticipanteDAO guardados) {
        this.guardados = guardados;
    }

    public void agregarParticipante(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);
        guardados.guardarParticipante(participante);
    }
}
