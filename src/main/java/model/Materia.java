package model;

import java.util.ArrayList;
import java.util.Optional;

public class Materia {
    String codigo;
    String nombre;
    int horasSemanales;
    int creditos;
    String semestre;
    Profesor profesor;
    ArrayList<EstudiantePostGrado> listaEstudiantePostGrado;
    ArrayList<EstudiantePreGrado> listaEstudiantePreGrado;

    public Materia(String codigo, String nombre, int horasSemanales, int creditos, String semestre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
        this.semestre = semestre;
        this.profesor = profesor;
        this.listaEstudiantePostGrado = new ArrayList<>();
        this.listaEstudiantePreGrado = new ArrayList<>();
    }

    public ArrayList<EstudiantePostGrado> getListaEstudiantePostGrado() {
        return listaEstudiantePostGrado;
    }

    public void setListaEstudiantePostGrado(ArrayList<EstudiantePostGrado> listaEstudiantePostGrado) {
        this.listaEstudiantePostGrado = listaEstudiantePostGrado;
    }

    public ArrayList<EstudiantePreGrado> getListaEstudiantePreGrado() {
        return listaEstudiantePreGrado;
    }

    public void setListaEstudiantePreGrado(ArrayList<EstudiantePreGrado> listaEstudiantePreGrado) {
        this.listaEstudiantePreGrado = listaEstudiantePreGrado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public boolean registrarEstudiantePreGrado(EstudiantePreGrado estudiantePreGrado) {
        boolean resultado = false;
        if(buscarEstudiantePreGrado(estudiantePreGrado).isEmpty()){
            listaEstudiantePreGrado.add(estudiantePreGrado);
            resultado = true;

        }
        return  resultado;
    }
    public boolean registrarEstudiantePostGrado(EstudiantePostGrado estudiantePostGrado) {
        boolean resultado = false;
        if(buscarEstudiantePostGrado(estudiantePostGrado).isEmpty()){
            listaEstudiantePostGrado.add(estudiantePostGrado);
            resultado = true;
        }
        return  resultado;
    }

    public Optional<EstudiantePreGrado> buscarEstudiantePreGrado(EstudiantePreGrado estudiante){
        return listaEstudiantePreGrado.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }

    public Optional<EstudiantePostGrado> buscarEstudiantePostGrado(EstudiantePostGrado estudiante){
        return listaEstudiantePostGrado.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }





}
