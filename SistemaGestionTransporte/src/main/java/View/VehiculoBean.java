package View;

import Controller.VehiculosInteractor;
import Controller.VehiculosInteractorImpl;
import Model.Conductores;
import Model.Vehiculos;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("vehiculoBean")
@SessionScoped

public class VehiculoBean implements Serializable, VehiculosViewModel {
    private List<Vehiculos>vehiculos;
    private Vehiculos vehiculoSeleccionado = new Vehiculos();
    private Vehiculos vehiculo = new Vehiculos();

    public VehiculoBean() { // constructor que construye el listado de peliculas
        this.vehiculos = new ArrayList<Vehiculos>();
        this.vehiculo= new Vehiculos ();

    }

    private VehiculosInteractor interactor = new VehiculosInteractorImpl(this);

    public void agregar() {
        interactor.agregarVehiculo(vehiculo);
        vehiculo = new Vehiculos();
    }

    public void actualizarVehiculo() {
        interactor.actualizarVehiculo(vehiculoSeleccionado);
        vehiculoSeleccionado = new Vehiculos();
    }

    public void eliminarVehiculo(Vehiculos vehiculo) {
        if (vehiculo != null && vehiculo.getId() > 0) {
            interactor.eliminarVehiculo(vehiculo.getId());
            interactor.consultarVehiculos();
            mostrarMensajeExito("Vehículo eliminado correctamente");
        } else {
            mostrarMensajeError("Vehículo inválido para eliminar");
        }
    }

    public String leer() {
        interactor.consultarVehiculos();
        return "leerVehiculos.xhtml?faces-redirect=true";
    }

    public void seleccionarVehiculo(Vehiculos vehiculo) {
        this.vehiculoSeleccionado= vehiculo;
    }


    private void mostrarMensaje(String mensaje,FacesMessage.Severity tipo ) {
        FacesMessage message=new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Vehiculos> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculos> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void mostrarVehiculosDataTable(List<Vehiculos> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
   mostrarMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
    }

    public Vehiculos getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculos vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }
}