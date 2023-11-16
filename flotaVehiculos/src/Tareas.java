class Tareas {
    private String descripcion;
    private String vehiculoAsignado;

    public Tareas(String descripcion) {
        this.descripcion = descripcion;
    }

    public void asignarVehiculo(String placa) {
        vehiculoAsignado = placa;
        // Notificar a los observadores (observadores de asignación de tareas).
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getVehiculoAsignado() {
        return vehiculoAsignado;
    }
}
