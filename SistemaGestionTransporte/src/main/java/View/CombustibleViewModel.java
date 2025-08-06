package View;

import Model.Combustible;
import java.util.List;

public interface CombustibleViewModel {
    void mostrarCombustibleDataTable(List<Combustible> lista);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}