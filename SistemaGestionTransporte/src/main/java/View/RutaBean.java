package View;

import Controller.RutasInteractor;
import Controller.RutasInteractorImpl;
import Model.Rutas;

import Model.Vehiculos;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import jakarta.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("rutaBean")
@SessionScoped
public class RutaBean implements Serializable, RutasViewModel {

    private List<Rutas> rutas = new ArrayList<>();
    private Rutas rutaseleccionada = new Rutas();
    private Rutas ruta = new Rutas();
    private RutasInteractor interactor = new RutasInteractorImpl(this);

    public RutaBean() {
        // Constructor vacío necesario para @Named y JSF
    }

    public void agregar() {
        interactor.agregarRuta(ruta);
        ruta = new Rutas();
    }

    public void actualizar() {
        interactor.actualizarRuta(rutaseleccionada);
        rutaseleccionada = new Rutas();
    }

    public void eliminarRuta(Rutas ruta) {
        if (ruta != null && ruta.getId() > 0) {
            interactor.eliminarRuta(ruta.getId());
            interactor.consultarRutas();
            mostrarMensajeExito("Ruta eliminada correctamente");
        } else {
            mostrarMensajeError("Ruta invalida para eliminar");
        }
    }

    public String leer() {
        interactor.consultarRutas();
        return "leerRuta.xhtml?faces-redirect=true";
    }

    public void seleccionarRuta(Rutas ruta) {
        this.rutaseleccionada = ruta;
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    // Getters y setters
    public List<Rutas> getRutas() {
        return rutas;
    }

    public void setRutas(List<Rutas> rutas) {
        this.rutas = rutas;
    }

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }

    public Rutas getRutaseleccionada() {
        return rutaseleccionada;
    }

    public void setRutaseleccionada(Rutas rutaseleccionada) {
        this.rutaseleccionada = rutaseleccionada;
    }

    public RutasInteractor getInteractor() {
        return interactor;
    }

    public void setInteractor(RutasInteractor interactor) {
        this.interactor = interactor;
    }

    // Métodos de la interfaz
    @Override
    public void mostrarRutasDataTable(List<Rutas> rutas) {
        this.rutas = rutas;
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
    }
}