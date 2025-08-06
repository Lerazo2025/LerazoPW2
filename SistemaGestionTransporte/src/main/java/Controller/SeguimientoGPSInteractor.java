package Controller;

import Model.SeguimientoGPS;

public interface SeguimientoGPSInteractor {
    void consultarSeguimientos();
    void agregarSeguimiento(SeguimientoGPS seguimiento);
    void actualizarSeguimiento(SeguimientoGPS seguimiento);
    void eliminarSeguimiento(int id);
}