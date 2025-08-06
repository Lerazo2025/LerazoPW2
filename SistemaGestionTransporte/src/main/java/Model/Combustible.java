package Model;

import java.util.Date;

public class Combustible {
    private int id;
    private String placa;
    private Date fecha;
    private double galones;
    private double costo;

    public Combustible() {
        this.id = 0;
        this.placa = "";
        this.fecha = new Date();
        this.galones = 0;
        this.costo = 0;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public double getGalones() { return galones; }
    public void setGalones(double galones) { this.galones = galones; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}