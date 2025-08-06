package View;

import Model.Rutas;
import java.util.List;

public interface RutasViewModel {
    void mostrarRutasDataTable(List<Rutas> rutas);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}