package model;

import java.util.ArrayList;
import java.util.Optional;

public class CarreraUniversitaria {
    ArrayList<MateriaPractica> listaMateriasPracticas;
    ArrayList<Materia> listaMaterias;
    ArrayList<EstudiantePreGrado> listaEstudiantePreGrado;
    ArrayList<EstudiantePostGrado> listaEstudiantePosGrado;
    ArrayList<ProfesorPlanta> listaProfesoresPlanta;
    ArrayList<ProfesorCatedratico> listaProfesoresCatedraticos;


    public CarreraUniversitaria(ArrayList<MateriaPractica> listaMateriasPracticas, ArrayList<Materia> listaMaterias, ArrayList<EstudiantePreGrado> listaEstudiantePreGrado, ArrayList<EstudiantePostGrado> listaEstudiantePosGrado, ArrayList<ProfesorPlanta> listaProfesoresPlanta, ArrayList<ProfesorCatedratico> listaProfesoresCatedraticos) {
        this.listaMateriasPracticas = listaMateriasPracticas;
        this.listaMaterias = listaMaterias;
        this.listaEstudiantePreGrado = listaEstudiantePreGrado;
        this.listaEstudiantePosGrado = listaEstudiantePosGrado;
        this.listaProfesoresPlanta = listaProfesoresPlanta;
        this.listaProfesoresCatedraticos = listaProfesoresCatedraticos;
    }

    public ArrayList<EstudiantePreGrado> getListaEstudiantePreGrado() {
        return listaEstudiantePreGrado;
    }

    public void setListaEstudiantePreGrado(ArrayList<EstudiantePreGrado> listaEstudiantePreGrado) {
        this.listaEstudiantePreGrado = listaEstudiantePreGrado;
    }

    public ArrayList<EstudiantePostGrado> getListaEstudiantePosGrado() {
        return listaEstudiantePosGrado;
    }

    public void setListaEstudiantePosGrado(ArrayList<EstudiantePostGrado> listaEstudiantePosGrado) {
        this.listaEstudiantePosGrado = listaEstudiantePosGrado;
    }

    public ArrayList<MateriaPractica> getListaMateriasPracticas() {
        return listaMateriasPracticas;
    }

    public void setListaMateriasPracticas(ArrayList<MateriaPractica> listaMateriasPracticas) {
        this.listaMateriasPracticas = listaMateriasPracticas;
    }

    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public ArrayList<ProfesorPlanta> getListaProfesoresPlanta() {
        return listaProfesoresPlanta;
    }

    public void setListaProfesoresPlanta(ArrayList<ProfesorPlanta> listaProfesoresPlanta) {
        this.listaProfesoresPlanta = listaProfesoresPlanta;
    }

    public ArrayList<ProfesorCatedratico> getListaProfesoresCatedraticos() {
        return listaProfesoresCatedraticos;
    }

    public void setListaProfesoresCatedraticos(ArrayList<ProfesorCatedratico> listaProfesoresCatedraticos) {
        this.listaProfesoresCatedraticos = listaProfesoresCatedraticos;
    }
    public int creditosDeUnEstudiante(Estudiante estudiante){
        int creditos= 0;
        creditos+= estudiante.creditosTotalesSemestre();
        return creditos;
    }

    public int calcularHorasSemanalesMateria(String codigo){
        int horasSemanales= 0;
        for(Materia materia:listaMaterias){
            if(materia.getCodigo().equals(codigo)){
                horasSemanales+= materia.getHorasSemanales();
            }
        }
        for(MateriaPractica materia: listaMateriasPracticas){
            if(materia.getCodigo().equals(codigo)){
                horasSemanales+= materia.getHorasSemanales();
            }
        }
        return horasSemanales;
    }



    public String inscribirEstudiantesPreGrado (EstudiantePreGrado estudiante, ArrayList<Materia>  materias) {
        String resultado= "Las materias han sido registradas con exito.";
        for(Materia m:materias){
            m.registrarEstudiantePreGrado(estudiante);
        }
        return resultado;
    }

    public String inscribirEstudiantesPostGrado (EstudiantePostGrado estudiante, ArrayList<Materia>  materias) {
        String resultado= "Las materias han sido registradas con exito.";
        for(Materia m:materias){
            m.registrarEstudiantePostGrado(estudiante);
        }
        return resultado;
    }




    public String registarMateriaTeorica(Materia materia) {
        String resultado = "La mateira ya existe";
        if (buscarMateria(materia).isEmpty()) {
            listaMaterias.add(materia);
            resultado= "Materia registrada con exito";
        }
        return resultado;
    }
    public String registarMateriaPractica(MateriaPractica materia) {
        String resultado = "La mateira ya existe";
        if (buscarMateriaPractica(materia).isEmpty()) {
            listaMaterias.add(materia);
            resultado= "Materia registrada con exito";
        }
        return resultado;
    }

    public ArrayList<Materia> consultarMateriasSemestre(String semestre){
        ArrayList<Materia> resultado= new ArrayList<>();
        for(Materia materia:listaMaterias) {
            if (materia.getSemestre().equalsIgnoreCase(semestre)) {
                resultado.add(materia);
            }
        }
        return resultado;
    }

    public ArrayList<EstudiantePreGrado> listarEstudiantesDeUnaAsignatura(Materia materia) {
        ArrayList<EstudiantePreGrado> resultado = materia.getListaEstudiantePreGrado();
        return resultado;
    }


    public Optional<Materia> buscarMateria(Materia materia){
        return listaMaterias.stream().filter(materia1 -> materia1.getCodigo().equals(materia.getCodigo())).findFirst();
    }
    public Optional<MateriaPractica> buscarMateriaPractica(MateriaPractica materia){
        return listaMateriasPracticas.stream().filter(materia1 -> materia1.getCodigo().equals(materia.getCodigo())).findFirst();
    }

    public Optional<EstudiantePreGrado> buscarEstudiante(EstudiantePreGrado estudiante){
        return listaEstudiantePreGrado.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }

    public Optional<EstudiantePostGrado> buscarEstudiante(EstudiantePostGrado estudiante){
        return listaEstudiantePosGrado.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }

    public Optional<ProfesorCatedratico> buscarProfesor(ProfesorCatedratico profesor){
        return listaProfesoresCatedraticos.stream().filter(profesor1 -> profesor1.getIdentificador().equals(profesor.getIdentificador())).findFirst();
    }

    public Optional<ProfesorPlanta> buscarProfesor(ProfesorPlanta profesor){
        return listaProfesoresPlanta.stream().filter(profesor1 -> profesor1.getIdentificador().equals(profesor.getIdentificador())).findFirst();
    }



}
