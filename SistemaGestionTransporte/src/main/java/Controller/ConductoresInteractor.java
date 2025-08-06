package Controller;

import Model.Conductores;

public interface ConductoresInteractor {
    void consultarConductores();
    void agregarConductor(Conductores conductor);
    void actualizarConductor(Conductores conductor);
    void eliminarConductor(int id);
}