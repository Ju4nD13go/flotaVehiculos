// Define la interfaz del observador
interface Observer {
    void actualizar(String placa, String estado, String ubicacion);
}

// Clase observadora para el seguimiento en tiempo real.
class ObservadorSeguimiento implements Observer {
    private String nombre;

    public ObservadorSeguimiento(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String placa, String estado, String ubicacion) {

        System.out.println(nombre + " ha recibido la actualización - Placa: " + placa + ", Estado: " + estado + ", Ubicación: " + ubicacion);
    }
}
