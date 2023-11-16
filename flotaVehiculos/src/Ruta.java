import java.util.ArrayList;
import java.util.List;
public class Ruta {
    private String origen;
    private String destino;
    private List<String> puntosIntermedios;

    public Ruta(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        this.puntosIntermedios = new ArrayList<>();
    }

    public void agregarPuntoIntermedio(String punto) {
        puntosIntermedios.add(punto);
    }

}
