package View;

import Model.Vehiculos;

import java.util.List;

public interface VehiculosViewModel {
    void mostrarVehiculosDataTable(List<Vehiculos>vehiculos);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}
