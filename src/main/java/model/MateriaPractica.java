package model;

import java.util.ArrayList;

public class MateriaPractica extends Materia{
    int horasPractica;
    int numLaboratorios;

    public MateriaPractica(String codigo, String nombre, int horasSemanales, int creditos, String semestre, Profesor profesor, int horasPractica, int numLaboratorios) {
        super(codigo, nombre, horasSemanales, creditos, semestre, profesor);
        this.horasPractica = horasPractica;
        this.numLaboratorios = numLaboratorios;
    }

    public int getHorasPractica() {
        return horasPractica;
    }

    public void setHorasPractica(int horasPractica) {
        this.horasPractica = horasPractica;
    }

    public int getNumLaboratorios() {
        return numLaboratorios;
    }

    public void setNumLaboratorios(int numLaboratorios) {
        this.numLaboratorios = numLaboratorios;
    }

    public String toString(){
        return super.toString()+", Horas Practicas: "+horasPractica+", Laboratorios: "+numLaboratorios;
    }
}
