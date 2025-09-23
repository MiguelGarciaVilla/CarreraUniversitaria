package model;

import java.util.ArrayList;
import java.util.Optional;

public class Estudiante {
     String identificador;
     String nombre;
     String documento;
     String programa;
     String semestre;
     ArrayList<Materia> listaMaterias;
     ArrayList<MateriaPractica> listaMateriasPracticas;

    public Estudiante(String identificador, String nombre, String documento, String programa, String semestre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.documento = documento;
        this.programa = programa;
        this.semestre = semestre;
        this.listaMaterias = new ArrayList<>();
        this.listaMateriasPracticas= new ArrayList<>();
    }

    public ArrayList<MateriaPractica> getListaMateriasPracticas() {
        return listaMateriasPracticas;
    }

    public void setListaMateriasPracticas(ArrayList<MateriaPractica> listaMateriasPracticas) {
        this.listaMateriasPracticas = listaMateriasPracticas;
    }

    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public int creditosTotalesSemestre(){
        int creditosTotales = 0;
        for(Materia materia : listaMaterias){
            creditosTotales+= materia.getCreditos();
        }
        for(MateriaPractica materia : listaMateriasPracticas){
            creditosTotales+= materia.getCreditos();
        }
        return creditosTotales;
    }


}
