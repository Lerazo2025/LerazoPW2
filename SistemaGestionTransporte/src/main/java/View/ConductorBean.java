package View;

import Controller.ConductoresInteractor;
import Controller.ConductoresInteractorImpl;
import Model.Conductores;
import Model.Vehiculos;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("conductorBean")
@SessionScoped
public class ConductorBean implements Serializable, ConductoresViewModel {

    private List<Conductores> conductores;
    private Conductores conductorSeleccionado = new Conductores();
    private Conductores conductor = new Conductores();

    private ConductoresInteractor interactor;

    public ConductorBean() {
        this.conductores = new ArrayList<>();
        this.conductor = new Conductores();
        interactor = new ConductoresInteractorImpl(this);
        interactor.consultarConductores();
    }

    public void agregar() {
        interactor.agregarConductor(conductor);
        conductor = new Conductores();
    }

    public void actualizar() {
        interactor.actualizarConductor(conductorSeleccionado);
        conductorSeleccionado = new Conductores();
    }

    public void eliminar(Conductores conductor) {
        if (conductor != null && conductor.getId() > 0) {
            interactor.eliminarConductor(conductor.getId());
            interactor.consultarConductores();
            mostrarMensajeExito("Conductor eliminado correctamente");
        } else {
            mostrarMensajeError("Conductor inválido para eliminar");
        }
    }

    public String leer() {
        interactor.consultarConductores();
        return "leerConductores.xhtml?faces-redirect=true";
    }

    public void seleccionarConductor(Conductores c) {
        this.conductorSeleccionado = c;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity severity) {
        FacesMessage msg = new FacesMessage(severity, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(msg);
    }

    @Override
    public void mostrarConductoresDataTable(List<Conductores> conductores) {
        this.conductores = conductores;
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

    public List<Conductores> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductores> conductores) {
        this.conductores = conductores;
    }

    public Conductores getConductorSeleccionado() {
        return conductorSeleccionado;
    }

    public void setConductorSeleccionado(Conductores conductorSeleccionado) {
        this.conductorSeleccionado = conductorSeleccionado;
    }

    public Conductores getConductor() {
        return conductor;
    }

    public void setConductor(Conductores conductor) {
        this.conductor = conductor;
    }
}