package model;

import java.util.ArrayList;
import java.util.Optional;

public class CarreraUniversitaria {
    ArrayList<Materia> listaMaterias;
    ArrayList<Estudiante> listaEstudiantes;
    ArrayList<Profesor> listaProfesores;



    public CarreraUniversitaria() {

        this.listaMaterias = new  ArrayList<>();
        this.listaEstudiantes = new  ArrayList<>();
        this.listaProfesores= new  ArrayList<>();
    }

    public ArrayList<Estudiante> getListaEstudiante() {
        return listaEstudiantes;
    }

    public void setListaEstudiante(ArrayList<Estudiante> listaEstudiante) {
        this.listaEstudiantes = listaEstudiante;
    }

    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }






    public String registarMateria(Materia materia) {
        String resultado = "La mateira ya existe";
        if (buscarMateria(materia).isEmpty()) {
            listaMaterias.add(materia);
            resultado= "Materia registrada con exito";
        }
        return resultado;
    }

    public String consultarMateriasSemestre(String semestre){
        String resultado= "Materias: ";
        for(Materia materia:listaMaterias) {
            if (materia.getSemestre().equalsIgnoreCase(semestre)) {
                resultado+= materia.getNombre()+", ";
            }
        }
        return resultado;
    }

    public String asociarProfesorMateria(Profesor profesor, Materia materia) {
        String resultado = profesor.getNombre()+" fue asociado correctamente a la materia "+materia.getNombre();
        if(materia.getProfesor()!=null) {
            resultado= "Error, esta materia ya tiene un profesor asociado";
        }else{
            materia.setProfesor(profesor);
        }
        return resultado;
    }

    public String inscribirEstudianteMaterias (Estudiante estudiante, ArrayList<Materia>  materias) {
        String resultado= "";
        for(Materia m:materias){
            if(m.noEstaElEstudianteRegistrado(estudiante)){
                m.registrarEstudiante(estudiante);
                estudiante.registrarMateria(m);
                resultado+= "La materia "+m.getNombre()+" se ha registrado correctamente.\n";
            }else{
                resultado+= "La materia "+m.getNombre()+" no ha sido registrada, el estudiante ya esta registrado en esta materia.\n";
            }
        }
        return resultado;
    }
    public String listarEstudiantesDeUnaAsignatura(Materia materia) {
        String resultado = "Estudiantes "+materia.getNombre()+":\n";
        ArrayList<Estudiante> estudiantes = materia.getListaEstudiantes();
        for(Estudiante estudiante:estudiantes){
            resultado+= estudiante.getNombre()+"\n";
        }
        return resultado;
    }

    public String horasSemanalesMateria(String codigo){
        String resultado = "La materia de codigo "+codigo+" no ha sido encontrada";
        for(Materia materia:listaMaterias){
            if (materia.getCodigo().equals(codigo)) {
                resultado="la materia "+materia.getNombre()+" tiene "+ materia.getHorasSemanales()+" horas semanales";
            }
        }
        return  resultado;
    }
    public String creditosDeUnEstudiante(Estudiante estudiante){
        String resultado= "El estudiante "+estudiante.getNombre()+" no esta registrado";
        if(buscarEstudiante(estudiante).isPresent()){
            resultado= "El estudiante "+estudiante.getNombre()+" tiene "+estudiante.creditosTotalesSemestre()+" creditos en el semestre que cursa";
        }
        return resultado;
    }






    public String registrarEstudiante(Estudiante estudiante){
        String mensaje= "El estudiante ya se encuentra resgistrado";
        if(buscarEstudiante(estudiante).isEmpty()){
            listaEstudiantes.add(estudiante);
            mensaje= "Estudiante registrado correctamente";
        }
        return mensaje;
    }















    public Optional<Materia> buscarMateria(Materia materia){
        return listaMaterias.stream().filter(materia1 -> materia1.getCodigo().equals(materia.getCodigo())).findFirst();
    }


    public Optional<Estudiante> buscarEstudiante(Estudiante estudiante){
        return listaEstudiantes.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }


    public Optional<Profesor> buscarProfesor(Profesor profesor){
        return listaProfesores.stream().filter(profesor1 -> profesor1.getIdentificador().equals(profesor.getIdentificador())).findFirst();
    }





}
