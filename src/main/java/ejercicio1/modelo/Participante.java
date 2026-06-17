package ejercicio1.modelo;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        if (nombre == null || nombre.isEmpty()) throw new RuntimeException("Debe cargar un nombre");
        if (!validarTelefono(telefono))
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        if (!esRegionValida(region))
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{4}-\\d{6}");
    }

    private boolean esRegionValida(String region) {
        return region.equals("China") || region.equals("US") || region.equals("Europa");
    }

    // para que la capa de persistencia acceda a los datos
    public String nombre() {
        return nombre;
    }

    public String telefono() {
        return telefono;
    }

    public String region() {
        return region;
    }
}