package org.turnera;

public class Medico {
    private int id;
    private String nombre;

    public Medico(String medicotxt) {
    }

    public Medico(int id, String nombre, double costoConsulta) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(double costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private double costoConsulta;
}
