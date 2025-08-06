package View;

import Controller.MantenimientoInteractor;
import Controller.MantenimientoInteractorImpl;
import Model.Mantenimiento;

import Model.Vehiculos;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import jakarta.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("mantenimientoBean")
@SessionScoped
public class MantenimientoBean implements Serializable, MantenimientoViewModel {
    private List<Mantenimiento> mantenimientos;
    private Mantenimiento mantenimientoSeleccionado = new Mantenimiento();
    private Mantenimiento mantenimiento = new Mantenimiento();

    private MantenimientoInteractor interactor;

    public MantenimientoBean() {
        this.mantenimientos = new ArrayList<>();
        this.mantenimiento = new Mantenimiento();
        this.interactor = new MantenimientoInteractorImpl(this);
    }

    public void agregar() {
        interactor.agregarMantenimiento(mantenimiento);
        mantenimiento = new Mantenimiento();
    }

    public void actualizar() {
        interactor.actualizarmantenimiento(mantenimientoSeleccionado );
        mantenimientoSeleccionado = new Mantenimiento();
    }

    public void eliminarmantenimiento(Mantenimiento mantenimiento) {
        if (mantenimiento != null && mantenimiento.getId() > 0) {
            interactor.eliminarmantenimiento(mantenimiento.getId());
            interactor.consultarMantenimientos();
            mostrarMensajeExito("Mantenimiento eliminado correctamente");
        } else {
            mostrarMensajeError("Mantenimiento inválido para eliminar");
        }
    }

    public String leer() {
        interactor.consultarMantenimientos();
        return "leerMantenimientos.xhtml?faces-redirect=true";
    }

    public void seleccionarMantenimiento(Mantenimiento mantenimientoSeleccionado) {
        this.mantenimientoSeleccionado = mantenimientoSeleccionado;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @Override
    public void mostrarMantenimientosDataTable(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
    }

    // Getters y Setters
    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public Mantenimiento getMantenimientoSeleccionado() {
        return mantenimientoSeleccionado;
    }

    public void setMantenimientoSeleccionado(Mantenimiento mantenimientoSeleccionado) {
        this.mantenimientoSeleccionado = mantenimientoSeleccionado;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
}