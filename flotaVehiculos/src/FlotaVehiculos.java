public class FlotaVehiculos {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("ABC123");
        Vehiculo vehiculo2 = new Vehiculo("XYZ789");

        ObservadorSeguimiento observador1 = new ObservadorSeguimiento("Seguimiento Vehículo 1");
        ObservadorSeguimiento observador2 = new ObservadorSeguimiento("Seguimiento Vehículo 2");

        vehiculo1.agregarObservador(observador1);
        vehiculo2.agregarObservador(observador2);

        Tareas tarea1 = new Tareas("Entregar paquete en dirección X");
        Tareas tarea2 = new Tareas("Recolectar mercancía en punto de recogida Y");

        vehiculo1.agregarTarea(tarea1);
        vehiculo2.agregarTarea(tarea2);

        vehiculo1.cambiarEstado("En ruta", "Latitud: 41.7128, Longitud: -74.0060");
        vehiculo2.cambiarEstado("En espera", "Latitud: 42.7128, Longitud: -74.0060");
    }
}
