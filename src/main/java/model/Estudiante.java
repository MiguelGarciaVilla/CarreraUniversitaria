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

    public Estudiante(String identificador, String nombre, String documento, String programa, String semestre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.documento = documento;
        this.programa = programa;
        this.semestre = semestre;
        this.listaMaterias = new ArrayList<>();
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

    @Override
    public String toString(){
        return "Identificador: "+identificador+", Nombre: "+nombre+", Documento: "+documento+", Programa: "+programa+", Semestre: "+semestre;
    }

    /**
     * Este es un Metodo que permite calcular los creditos totales de una materia en un semestre.
     * @return
     */
    public int creditosTotalesSemestre(){
        int creditosTotales = 0;
        for(Materia materia : listaMaterias){
            creditosTotales+= materia.getCreditos();
        }
        return creditosTotales;
    }

    /**
     * Este es un metodo que permite registrar una materia en la listaMaterias de esta clase Estudiante.
     * @param materia
     */
    public void registrarMateria(Materia materia){
        listaMaterias.add(materia);
    }

}
