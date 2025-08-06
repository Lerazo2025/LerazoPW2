package Controller;

import Model.Conductores;
import Model.ConductoresResponse;
import Repository.DatabaseRepositoryImpl;
import View.ConductoresViewModel;

public class ConductoresInteractorImpl implements ConductoresInteractor {

    private DatabaseRepositoryImpl repositorio;
    private ConductoresViewModel vista;

    public ConductoresInteractorImpl(ConductoresViewModel vista) {
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarConductores() {
        try {
            ConductoresResponse response = repositorio.consultarConductores();
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                vista.mostrarMensajeError("No se encontraron conductores");
            } else {
                vista.mostrarConductoresDataTable(response.getItems());
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void agregarConductor(Conductores conductor) {
        try {
            boolean exito = repositorio.agregarConductor(conductor);
            if (exito) {
                vista.mostrarMensajeExito("Conductor agregado correctamente");
                consultarConductores();
            } else {
                vista.mostrarMensajeError("Error al agregar conductor");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void actualizarConductor(Conductores conductor) {
        try {
            boolean exito = repositorio.actualizarConductor(conductor);
            if (exito) {
                vista.mostrarMensajeExito("Conductor actualizado correctamente");
                consultarConductores();
            } else {
                vista.mostrarMensajeError("Error al actualizar conductor");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void eliminarConductor(int id) {
        try {
            boolean exito = repositorio.eliminarconductor(id);
            if (exito) {
                vista.mostrarMensajeExito("Conductor eliminado correctamente");
                consultarConductores();
            } else {
                vista.mostrarMensajeError("Error al eliminar conductor");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }
}