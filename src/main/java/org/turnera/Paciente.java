package org.turnera;

public class Paciente {
    private int id;
    private String nombre;

    public Paciente(String pacientetxt) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
