package Controller;

import Model.Combustible;

public interface CombustibleInteractor {
    void consultarCombustibles();
    void agregarCombustible(Combustible combustible);
    void actualizarCombustible(Combustible combustible);
    void eliminarCombustibles(int id);
}