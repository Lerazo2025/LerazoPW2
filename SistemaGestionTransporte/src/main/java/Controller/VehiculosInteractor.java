package Controller;

import Model.Vehiculos;

public interface VehiculosInteractor {
    void consultarVehiculos();
    void agregarVehiculo(Vehiculos vehiculo);
    void actualizarVehiculo(Vehiculos vehiculo);
    void eliminarVehiculo(int id);

}
