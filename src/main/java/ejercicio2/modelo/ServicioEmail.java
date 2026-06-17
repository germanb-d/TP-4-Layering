package ejercicio2.modelo;

public interface ServicioEmail {

    void mandarEmail(String mail, String asunto, String cuerpo);

    String retornarMail(); // esto solo lo uso para el test

    // void mandarFelizCumple(Empleado empleado);
}
