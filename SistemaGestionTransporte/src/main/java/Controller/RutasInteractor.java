package Controller;

import Model.Rutas;

public interface RutasInteractor {
    void consultarRutas();
    void agregarRuta(Rutas ruta);
    void actualizarRuta(Rutas ruta);
    void eliminarRuta(int id);
}