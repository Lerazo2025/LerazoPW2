package Controller;

import Model.SeguimientoGPS;
import Model.SeguimientoGPSResponse;
import Repository.DatabaseRepositoryImpl;
import View.SeguimientoGPSViewModel;

public class SeguimientoGPSInteractorImpl implements SeguimientoGPSInteractor {

    private DatabaseRepositoryImpl repositorio;
    private SeguimientoGPSViewModel vista;

    public SeguimientoGPSInteractorImpl(SeguimientoGPSViewModel vista) {
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarSeguimientos() {
        try {
            SeguimientoGPSResponse response = repositorio.consultarSeguimientos();
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                vista.mostrarMensajeError("No se encontraron registros de seguimiento GPS");
            } else {
                vista.mostrarSeguimientosDataTable(response.getItems());
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void agregarSeguimiento(SeguimientoGPS seguimiento) {
        try {
            boolean exito = repositorio.agregarSeguimiento(seguimiento);
            if (exito) {
                vista.mostrarMensajeExito("Seguimiento agregado correctamente");
                consultarSeguimientos();
            } else {
                vista.mostrarMensajeError("Error al agregar seguimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void actualizarSeguimiento(SeguimientoGPS seguimiento) {
        try {
            boolean exito = repositorio.actualizarSeguimiento(seguimiento);
            if (exito) {
                vista.mostrarMensajeExito("Seguimiento actualizado correctamente");
                consultarSeguimientos();
            } else {
                vista.mostrarMensajeError("Error al actualizar seguimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void eliminarSeguimiento(int id) {
        try {
            boolean exito = repositorio.eliminarSeguimiento(id);
            if (exito) {
                vista.mostrarMensajeExito("Seguimiento eliminado correctamente");
                consultarSeguimientos();
            } else {
                vista.mostrarMensajeError("Error al eliminar seguimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }
}