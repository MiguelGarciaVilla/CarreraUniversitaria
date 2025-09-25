package model;

import java.util.ArrayList;

public class Profesor {
    String identificador;
    String nombre;
    String titulo;
    String añosExperiencia;
    ArrayList<Materia> listaMaterias;

    public Profesor(String identificador, String nombre, String titulo, String añosExperiencia) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.titulo = titulo;
        this.añosExperiencia = añosExperiencia;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(String añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

}
