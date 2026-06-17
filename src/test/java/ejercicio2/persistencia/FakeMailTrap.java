package ejercicio2.persistencia;

import ejercicio2.modelo.ServicioEmail;

public class FakeMailTrap implements ServicioEmail {
    private String mail;


    @Override
    public void mandarEmail(String mail, String asunto, String cuerpo) {
        this.mail = mail;
    } // En sí lo único que voy a verificar es que se haya mandado al mail correcto, el asunto y cuerpo variara según las constantes de la clase ServicioCumpleaños

    @Override
    public String retornarMail() {
        return mail;
    }


}
