package View;

import Model.SeguimientoGPS;
import java.util.List;

public interface SeguimientoGPSViewModel {
    void mostrarSeguimientosDataTable(List<SeguimientoGPS> seguimientos);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}