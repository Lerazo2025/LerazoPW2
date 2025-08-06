package Model;

import java.io.Serializable;

public class Conductores implements Serializable {
    private int id;
    private String nombre;
    private String licencia;
    private String telefono;
    private int edad;

    public Conductores() {
        this.id = 0;
        this.nombre = "";
        this.licencia = "";
        this.telefono = "";
        this.edad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}