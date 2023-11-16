import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Vehiculo {
    private String placa;
    private String estado;
    private String ubicacion;
    private String Modelo;
    private String TipoVehiculo;
    private Conductor conductor;
    private List<Observer> observadores = new ArrayList<>(); // Lista de observadores
    private List<Tareas> tareas = new ArrayList<>();

    public void asignarConductor(Conductor conductor) {

        this.conductor = conductor;
        JOptionPane.showMessageDialog(null, "¡Conductor asignado al vehículo con éxito!", "Asignación Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    public Conductor obtenerConductor() {
        return conductor;
    }

    public Vehiculo(String placa) {
        this.placa = placa;
        this.estado = "Disponible";
        this.ubicacion = "Latitud: 40.7128, Longitud: -74.0060"; // Ubicación ficticia
    }
    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }
    public void setTipoVehiculo(String tipoVehiculo) {
        this.TipoVehiculo = tipoVehiculo;
    }
    public void cambiarEstado(String estado, String ubicacion ) {
        this.estado = estado;
        this.Modelo = Modelo;
        this.TipoVehiculo = TipoVehiculo;
        this.ubicacion = ubicacion;
        notificarObservadores(estado, ubicacion);
    }

    public void realizarMantenimiento() {

    }

    public String getPlaca() {
        return placa;
    }

    public String getEstado() {
        return estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void agregarTarea(Tareas tarea) {
        tareas.add(tarea);
        notificarObservadores(estado, ubicacion); // Notificar observadores cuando se agrega una nueva tarea
    }

    public List<Tareas> getTareas() {
        return tareas;
    }


    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observer observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores(String estado, String ubicacion) {
        for (Observer observador : observadores) {
            observador.actualizar(this.placa, estado, ubicacion);
        }
    }

    public String getModelo() {
        return Modelo;

    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }
}
