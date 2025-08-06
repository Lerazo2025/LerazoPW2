package View;

import Controller.SeguimientoGPSInteractor;
import Controller.SeguimientoGPSInteractorImpl;
import Model.SeguimientoGPS;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("seguimientoGPSBean")
@SessionScoped
public class SeguimientoGPSBean implements Serializable, SeguimientoGPSViewModel {
    private List<SeguimientoGPS> seguimientos;
    private SeguimientoGPS seguimientoSeleccionado = new SeguimientoGPS();
    private SeguimientoGPS seguimiento = new SeguimientoGPS();

    private SeguimientoGPSInteractor interactor;

    public SeguimientoGPSBean() {
        this.seguimientos = new ArrayList<>();
        this.seguimiento = new SeguimientoGPS();
        this.interactor = new SeguimientoGPSInteractorImpl(this);
    }

    public void agregar() {
        interactor.agregarSeguimiento(seguimiento);
        seguimiento = new SeguimientoGPS();
    }

    public void actualizarSeguimiento() {
        interactor.actualizarSeguimiento(seguimientoSeleccionado);
        seguimientoSeleccionado = new SeguimientoGPS();
    }

    public void eliminarSeguimiento(SeguimientoGPS seguimiento) {
        if (seguimiento != null && seguimiento.getId() > 0) {
            interactor.eliminarSeguimiento(seguimiento.getId());
        } else {
            mostrarMensajeError("Seguimiento inválido para eliminar");
        }
    }

    public String leer() {
        interactor.consultarSeguimientos();
        return "leerSeguimientosGPS.xhtml?faces-redirect=true";
    }

    public void seleccionarSeguimiento(SeguimientoGPS seguimiento) {
        this.seguimientoSeleccionado = seguimiento;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @Override
    public void mostrarSeguimientosDataTable(List<SeguimientoGPS> seguimientos) {
        this.seguimientos = seguimientos;
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

    public List<SeguimientoGPS> getSeguimientos() {
        return seguimientos;
    }

    public void setSeguimientos(List<SeguimientoGPS> seguimientos) {
        this.seguimientos = seguimientos;
    }

    public SeguimientoGPS getSeguimientoSeleccionado() {
        return seguimientoSeleccionado;
    }

    public void setSeguimientoSeleccionado(SeguimientoGPS seguimientoSeleccionado) {
        this.seguimientoSeleccionado = seguimientoSeleccionado;
    }

    public SeguimientoGPS getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(SeguimientoGPS seguimiento) {
        this.seguimiento = seguimiento;
    }
}