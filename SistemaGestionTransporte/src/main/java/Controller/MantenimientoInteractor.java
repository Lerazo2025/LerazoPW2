package Controller;

import Model.Mantenimiento;

public interface MantenimientoInteractor {
    void consultarMantenimientos();
    void agregarMantenimiento(Mantenimiento mantenimiento);
    void actualizarmantenimiento(Mantenimiento mantenimiento);
    void eliminarmantenimiento(int id);
}