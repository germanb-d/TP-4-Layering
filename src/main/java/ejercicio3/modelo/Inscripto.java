package ejercicio3.modelo;

public class Inscripto {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    public Inscripto(String nombre, String apellido, String dni, String telefono, String email) {
        validarNombre(nombre);
        validarApellido(apellido);
        validarDni(dni);
        validarTelefono(telefono);
        validarEmail(email);

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser vacío");
        }
    }

    private void validarApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("Apellido no puede ser vacío");
        }
    }

    private void validarDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("DNI no puede ser vacío");
        }
    }

    private void validarEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    private void validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        if (!telefono.matches(regex)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
