package View;

import Model.Mantenimiento;
import java.util.List;

public interface MantenimientoViewModel {
    void mostrarMantenimientosDataTable(List<Mantenimiento> mantenimientos);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}