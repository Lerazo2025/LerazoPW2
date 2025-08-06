package Controller;

import Model.Vehiculos;
import Model.VehiculosResponse;
import Repository.DatabaseRepository;
import Repository.DatabaseRepositoryImpl;
import View.VehiculosViewModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class VehiculosInteractorImpl implements VehiculosInteractor {
    private DatabaseRepositoryImpl repositorio;
    private VehiculosViewModel vista;
    private DatabaseRepository client;

    public VehiculosInteractorImpl(VehiculosViewModel vista) {
        super();
        this.vista=vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com",3L);
    }

    @Override
    public void consultarVehiculos() {
        try {
            VehiculosResponse response = this.repositorio.consultarVehiculos();
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                this.vista.mostrarMensajeError("No se encontraron vehículos");
            } else {
                this.vista.mostrarVehiculosDataTable(response.getItems());
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }


    @Override
    public void agregarVehiculo(Vehiculos vehiculo) {
        try {
            boolean exito = this.repositorio.agregarVehiculo(vehiculo);
            if (exito) {
                this.vista.mostrarMensajeExito("Vehículo agregado correctamente");
                consultarVehiculos();
            } else {
                this.vista.mostrarMensajeError("Error al agregar vehículo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }



    @Override
    public void actualizarVehiculo(Vehiculos vehiculo) {
        try {
            boolean exito =repositorio.actualizarVehiculo(vehiculo);
            if (exito) {
                this.vista.mostrarMensajeExito("Vehículo actualizado correctamente");
                consultarVehiculos();
            } else {
                this.vista.mostrarMensajeError("Error al actualizar vehículo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void eliminarVehiculo(int id) {
        try {
            boolean exito =this.repositorio.eliminarVehiculo(id);
            if (exito) {
                this.vista.mostrarMensajeExito("Vehículo Eliminado correctamente");
                consultarVehiculos();
            } else {
                this.vista.mostrarMensajeError("Error al Eliminar vehículo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }



}

}