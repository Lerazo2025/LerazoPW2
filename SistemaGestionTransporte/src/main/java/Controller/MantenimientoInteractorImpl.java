package Controller;

import Model.Mantenimiento;
import Model.MantenimientoResponse;
import Model.Vehiculos;
import Repository.DatabaseRepositoryImpl;
import View.MantenimientoViewModel;

public class MantenimientoInteractorImpl implements MantenimientoInteractor {
    private DatabaseRepositoryImpl repositorio;
    private MantenimientoViewModel vista;

    public MantenimientoInteractorImpl(MantenimientoViewModel vista) {
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarMantenimientos() {
        try {
            MantenimientoResponse response = repositorio.consultarMantenimientos();
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                vista.mostrarMensajeError("No se encontraron registros de mantenimiento");
            } else {
                vista.mostrarMantenimientosDataTable(response.getItems());
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void agregarMantenimiento(Mantenimiento mantenimiento) {
        try {
            boolean exito = repositorio.agregarMantenimiento(mantenimiento);
            if (exito) {
                vista.mostrarMensajeExito("Mantenimiento agregado correctamente");
                consultarMantenimientos();
            } else {
                vista.mostrarMensajeError("Error al agregar mantenimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }



    @Override
    public void actualizarmantenimiento(Mantenimiento mantenimiento) {
        try {
            boolean exito =repositorio.actualizarmantenimiento(mantenimiento);
            if (exito) {
                this.vista.mostrarMensajeExito("Mantenimiento actualizado correctamente");
                consultarMantenimientos();
            } else {
                this.vista.mostrarMensajeError("Error al actualizar Mantenimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }


    @Override
    public void eliminarmantenimiento(int id) {
        try {
            boolean exito = repositorio.eliminarmantenimiento(id);
            if (exito) {
                vista.mostrarMensajeExito("Mantenimiento eliminado correctamente");
                consultarMantenimientos();
            } else {
                vista.mostrarMensajeError("Error al eliminar mantenimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }


}