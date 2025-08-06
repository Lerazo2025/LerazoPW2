package Controller;

import Model.Rutas;
import Model.RutasResponse;
import Model.Vehiculos;
import Repository.DatabaseRepositoryImpl;
import View.RutasViewModel;

public class RutasInteractorImpl implements RutasInteractor {
    private DatabaseRepositoryImpl repositorio;
    private RutasViewModel vista;

    public RutasInteractorImpl(RutasViewModel vista) {
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarRutas() {
        try {
            RutasResponse response = repositorio.consultarRutas();
            if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
                vista.mostrarMensajeError("No se encontraron rutas");
            } else {
                vista.mostrarRutasDataTable(response.getItems());
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void agregarRuta(Rutas ruta) {
        try {
            boolean exito = repositorio.agregarRuta(ruta);
            if (exito) {
                vista.mostrarMensajeExito("Ruta agregada correctamente");
                consultarRutas();
            } else {
                vista.mostrarMensajeError("Error al agregar ruta");
            }
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void actualizarRuta(Rutas ruta) {
        try {
            boolean exito =repositorio.actualizarRuta(ruta);
            if (exito) {
                this.vista.mostrarMensajeExito("Vehículo actualizado correctamente");
                consultarRutas();
            } else {
                this.vista.mostrarMensajeError("Error al actualizar vehículo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }
    }

    @Override
    public void eliminarRuta(int id) {
        try {
            boolean exito =this.repositorio.eliminarRuta(id);
            if (exito) {
                this.vista.mostrarMensajeExito("Ruta Eliminada correctamente");
                consultarRutas();
            } else {
                this.vista.mostrarMensajeError("Error al Eliminar Ruta");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.vista.mostrarMensajeError("Error de conexión: " + e.getMessage());
        }



    }
}