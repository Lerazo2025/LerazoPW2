package Controller;

import Model.Combustible;
import Model.CombustibleResponse;
import Repository.DatabaseRepositoryImpl;
import View.CombustibleViewModel;

public class CombustibleInteractorImpl implements CombustibleInteractor {
    private DatabaseRepositoryImpl repo;
    private CombustibleViewModel vista;

    public CombustibleInteractorImpl(CombustibleViewModel vista) {
        this.vista = vista;
        this.repo = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarCombustibles() {
        try {
            CombustibleResponse response = repo.consultarCombustibles();
            if (response == null || response.getItems().isEmpty()) {
                vista.mostrarMensajeError("No se encontraron registros de combustible.");
            } else {
                vista.mostrarCombustibleDataTable(response.getItems());
            }
        } catch (Exception e) {
            vista.mostrarMensajeError("Error al consultar: " + e.getMessage());
        }
    }

    @Override
    public void agregarCombustible(Combustible combustible) {
        try {
            boolean exito = repo.agregarCombustible(combustible);
            if (exito) {
                vista.mostrarMensajeExito("Registro agregado correctamente");
                consultarCombustibles();
            } else {
                vista.mostrarMensajeError("Error al agregar registro.");
            }
        } catch (Exception e) {
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCombustible(Combustible combustible) {
        try {
            boolean exito = repo.actualizarCombustible(combustible);
            if (exito) {
                vista.mostrarMensajeExito("Registro actualizado correctamente");
                consultarCombustibles();
            } else {
                vista.mostrarMensajeError("Error al actualizar.");
            }
        } catch (Exception e) {
            vista.mostrarMensajeError("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCombustibles(int id) {
        try {
            boolean exito = repo.eliminarCombustible(id);
            if (exito) {
                vista.mostrarMensajeExito("Registro actualizado correctamente");
               consultarCombustibles();
            } else {
                vista.mostrarMensajeError("Error al actualizar.");
            }
        } catch (Exception e) {
            vista.mostrarMensajeError("Error: " + e.getMessage());
        }
    }
}