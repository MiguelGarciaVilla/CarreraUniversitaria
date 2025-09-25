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
    ArrayList<Estudiante> listaEstudiantes;;

    public Materia(String codigo, String nombre, int horasSemanales, int creditos, String semestre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
        this.creditos = creditos;
        this.semestre = semestre;
        this.profesor = profesor;
        this.listaEstudiantes = new ArrayList<>();

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
    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString(){
        return "Codigo: "+codigo+", Nombre: "+nombre+", Horas Semanales: "+horasSemanales+", Creditos: "+creditos+", Semestre: "+semestre+", Profesor: "+profesor.getNombre()+", Estudiantes: "+listaEstudiantes.toString();
    }

    /**
     * Metodo que determina si un estudiante ya pertenece a una materia o no.
     * @param estudiante
     * @return
     */
    public boolean noEstaElEstudianteRegistrado(Estudiante estudiante){
        boolean resultado = false;
        if(buscarEstudiante(estudiante).isEmpty()){
            return true;
        }
        return  resultado;
    }

    /**
     * Metodo que registra a un estudiante en la lista de estudiantes de esta clase Materia.
     * @param estudiante
     */
    public void registrarEstudiante(Estudiante estudiante){
        listaEstudiantes.add(estudiante);
    }

    /**
     * Metodo que permite buscar a un estudiante en la listaEstudiantes de esta clase Materia.
     * @param estudiante
     * @return
     */
    public Optional<Estudiante> buscarEstudiante(Estudiante estudiante){
        return listaEstudiantes.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }

}
