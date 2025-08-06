package Model;

import java.io.Serializable;

public class Rutas implements Serializable {
    private int id;
    private String origen;
    private String destino;
    private double distancia;

    public Rutas() {
        this.id = 0;
        this.origen = "";
        this.destino = "";
        this.distancia = 0.0;
    }



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public double getDistancia() { return distancia; }
    public void setDistancia(double distancia) { this.distancia = distancia; }
}
