package View;

import Model.Conductores;
import java.util.List;

public interface ConductoresViewModel {
    void mostrarConductoresDataTable(List<Conductores> conductores);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}