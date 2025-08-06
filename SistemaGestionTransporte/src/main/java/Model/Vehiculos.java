package Model;

import java.io.Serializable;

public class Vehiculos implements Serializable {
    private int id;
    private String marca;
    private String modelo;
    private String placa;
    private int anio;

    public Vehiculos() {
        this.id = 0;
        this.marca = "";
        this.modelo = "";
        this.placa = "";
        this.anio=0;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
