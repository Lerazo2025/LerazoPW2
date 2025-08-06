package Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Mantenimiento implements Serializable {
    private int id;
    private String placa;
    private String descripcion;
    private Date fecha;
    private double costo;

    public Mantenimiento() {
        this.id = 0;
        this.placa="";
        this.descripcion = "";
        this.fecha = new Date();
        this.costo = 0.0;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}