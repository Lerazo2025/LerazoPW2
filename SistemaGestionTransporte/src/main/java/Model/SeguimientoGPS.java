package Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class SeguimientoGPS implements Serializable {
    private int id;
    private String placa;
    private double latitud;
    private double longitud;
    @SerializedName("fechahora")
    private Date fechaHora;

    public SeguimientoGPS() {
        this.id = 0;
        this.placa = "";
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.fechaHora = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}