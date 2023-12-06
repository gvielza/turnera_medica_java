package org.turnera;

import java.time.LocalDateTime;

public class Turno {
    

    private int id;
    private String fechaHora;
    private boolean esSobreturno;
    private Paciente paciente;
    private Medico medico;

    public Turno(String fechatxt, boolean sobreturno, int id, int id1) {
    }

    public Turno(String fechatxt, boolean sobreturno, Paciente id, Medico id1) {
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEsSobreturno() {
        return esSobreturno;
    }

    public void setEsSobreturno(boolean esSobreturno) {
        this.esSobreturno = esSobreturno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
