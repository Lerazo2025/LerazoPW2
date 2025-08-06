package View;

import Controller.CombustibleInteractor;
import Controller.CombustibleInteractorImpl;
import Model.Combustible;
import Model.Vehiculos;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("combustibleBean")
@SessionScoped
public class CombustibleBean implements Serializable, CombustibleViewModel {

    private List<Combustible> combustibles;
    private Combustible combustible = new Combustible();
    private Combustible combustibleSeleccionado = new Combustible();

    private CombustibleInteractor interactor;

    public CombustibleBean() {
        this.combustibles = new ArrayList<>();
        this.combustible = new Combustible();
        this.interactor = new CombustibleInteractorImpl(this);
    }

    public void agregar() {
        interactor.agregarCombustible(combustible);
        combustible = new Combustible();
    }

    public void actualizarCombustible() {
        interactor.actualizarCombustible(combustibleSeleccionado);
        combustibleSeleccionado = new Combustible();
    }

    public void eliminarCombustible(Combustible combustible) {
        if (combustible != null && combustible.getId() > 0) {
            interactor.eliminarCombustibles(combustible.getId());
            interactor.consultarCombustibles();
            mostrarMensajeExito("Registro Combustible eliminado correctamente");
        } else {
            mostrarMensajeError("Registro Combustible inválido para eliminar");
        }
    }

    public String leer() {
        interactor.consultarCombustibles();
        return "leerCombustible.xhtml?faces-redirect=true";
    }

    public void seleccionarCombustible(Combustible c) {
        this.combustibleSeleccionado = c;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @Override
    public void mostrarCombustibleDataTable(List<Combustible> lista) {
        this.combustibles = lista;
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
    public List<Combustible> getCombustibles() {
        return combustibles;
    }

    public void setCombustibles(List<Combustible> combustibles) {
        this.combustibles = combustibles;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Combustible getCombustibleSeleccionado() {
        return combustibleSeleccionado;
    }

    public void setCombustibleSeleccionado(Combustible combustibleSeleccionado) {
        this.combustibleSeleccionado = combustibleSeleccionado;
    }
}