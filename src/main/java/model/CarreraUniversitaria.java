package model;

import java.util.ArrayList;
import java.util.Optional;

public class CarreraUniversitaria {
    ArrayList<Materia> listaMaterias;
    ArrayList<Estudiante> listaEstudiantes;
    ArrayList<Profesor> listaProfesores;

    public CarreraUniversitaria() {
        this.listaMaterias = new ArrayList<>();
        this.listaEstudiantes = new ArrayList<>();
        this.listaProfesores = new ArrayList<>();
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

    /**
     * Metodo para consultar las materias de un semestre específico.
     *
     * @param semestre
     * @return
     */
    public String consultarMateriasSemestre(String semestre) {
        String resultado = "No se encontro el semestre ingresado";
        if (buscarSemestre(semestre).isPresent()) {
            resultado= "Materia: ";
            for (Materia materia : listaMaterias) {
                if (materia.getSemestre().equalsIgnoreCase(semestre)) {
                    resultado += materia.getNombre() + ", ";
                }
            }

        }
        return resultado;
    }

    /**
     * Metodo para asociar un profesor a una materia, la logica del metodo es simple teniendo en cuenta que una materia solo puede tener un profesor.
     *
     * @param profesor
     * @param materia
     * @return
     */
    public String asociarProfesorMateria(Profesor profesor, Materia materia) {
        String resultado = "Error, el profesor o materia no esta registrado";
        if (buscarProfesor(profesor).isPresent() && buscarMateria(materia).isPresent()) {

            resultado = profesor.getNombre() + " fue asociado correctamente a la materia " + materia.getNombre();
            if (materia.getProfesor() != null) {
                resultado = "Error, esta materia ya tiene un profesor asociado";
            } else {
                materia.setProfesor(profesor);
            }
        }
        return resultado;
    }

    /**
     * Metodo para inscribir un estudiante en varias materias, este metodo actualiza la lista de materias para el estudiante y la lista de estudiantes para una materia.
     *
     * @param estudiante
     * @param materias
     * @return
     */
    public String inscribirEstudianteMaterias(Estudiante estudiante, ArrayList<Materia> materias) {
        String resultado = "Error, el estudiante o las materias no estan registradas";
        if (buscarEstudiante(estudiante).isPresent() && estanLasMateriasRegistradas(materias)) {
            resultado = "";
            for (Materia m : materias) {
                if (m.noEstaElEstudianteRegistrado(estudiante)) {
                    m.registrarEstudiante(estudiante);
                    estudiante.registrarMateria(m);
                    resultado += "La materia " + m.getNombre() + " se ha registrado correctamente.\n";
                } else {
                    resultado += "La materia " + m.getNombre() + " no ha sido registrada, el estudiante ya esta registrado en esta materia.\n";
                }
            }
        }
        return resultado;
    }

    /**
     * Metodo para combropar que una serie de materias esten registradas en el sistema
     * @param materias
     * @return
     */
    public boolean estanLasMateriasRegistradas(ArrayList<Materia> materias) {
        return materias.stream().allMatch(materia -> buscarMateria(materia).isPresent());
    }

    /**
     * Metodo para listar los estudiantes de una solo materia.
     *
     * @param materia
     * @return
     */
    public ArrayList<Estudiante> listarEstudiantesDeUnaAsignatura(Materia materia) {
        ArrayList<Estudiante> resultado = new ArrayList<>();
        if (buscarMateria(materia).isPresent()) {
            for(Estudiante aux : materia.getListaEstudiantes()){
                resultado.add(aux);
            }
        }
        return resultado;
    }

    /**
     * Metodo para ver las horas semanales de una materia, recibe como parametro el codigo de una materia y retorna sus horas semanales.
     *
     * @param codigo
     * @return
     */
    public String horasSemanalesMateria(String codigo) {
        String resultado = "La materia de codigo " + codigo + " no ha sido encontrada";
        for (Materia materia : listaMaterias) {
            if (materia.getCodigo().equals(codigo)) {
                resultado = "la materia " + materia.getNombre() + " tiene " + materia.getHorasSemanales() + " horas semanales";
            }
        }
        return resultado;
    }

    /**
     * Metodo que retorna los creditos de un estudiante, este metodo llama a otro que esta en la clase Estudiante para retornar los creditos totales sumados de las materias que esten registradas en el estudiante.
     *
     * @param estudiante
     * @return
     */
    public String creditosDeUnEstudiante(Estudiante estudiante) {
        String resultado = "El estudiante " + estudiante.getNombre() + " no esta registrado";
        if (buscarEstudiante(estudiante).isPresent()) {
            resultado = "El estudiante " + estudiante.getNombre() + " tiene " + estudiante.creditosTotalesSemestre() + " creditos en el semestre que cursa";
        }
        return resultado;
    }


//CRUD

    /**
     * Metodo para registrar un estudiante de pregrado o de postgrado.
     *
     * @param estudiante
     * @return
     */
    public String registrarEstudiante(Estudiante estudiante) {
        String mensaje = "El estudiante ya se encuentra resgistrado";
        if (buscarEstudiante(estudiante).isEmpty()) {
            listaEstudiantes.add(estudiante);
            mensaje = "Estudiante registrado correctamente";
        }
        return mensaje;
    }

    /**
     * Metodo para registrar un profesor de planta o catedratico.
     *
     * @param profesor
     * @return
     */
    public String registrarProfesor(Profesor profesor) {
        String mensaje = "El profesor ya se encuentra resgistrado";
        if (buscarProfesor(profesor).isEmpty()) {
            listaProfesores.add(profesor);
            mensaje = "Profesor registrado correctamente";
        }
        return mensaje;
    }

    /**
     * Metodo para registrar una materia practica o teorica.
     *
     * @param materia
     * @return
     */
    public String registrarMateria(Materia materia) {
        String mensaje = "La materia ya se encuentra resgistrada";
        if (buscarMateria(materia).isEmpty()) {
            listaMaterias.add(materia);
            mensaje = "Materia registrada correctamente";
        }
        return mensaje;
    }

    /**
     * Metodo para eliminar un estudiante de pregrado o de postgrado.
     *
     * @param estudiante
     * @return
     */
    public String eliminarEstudiante(Estudiante estudiante) {
        return buscarEstudiante(estudiante)
                .map(e -> {
                    listaEstudiantes.remove(estudiante);
                    return "Estudiante eliminado correctamente";})
                .orElse("Estudiante no esta registrado");
    }

    /**
     * Metodo para eliminar un profesor de planta o catedrático.
     *
     * @param profesor
     * @return
     */
    public String eliminarProfesor(Profesor profesor) {
        return buscarProfesor(profesor)
                .map(e -> {
                    listaProfesores.remove(profesor);
                    return "Profesor eliminado correctamente";
                })
                .orElse("El profesor no esta registrado");
    }

    /**
     * Metodo para eliminar una materia práctica o teórica.
     *
     * @param materia
     * @return
     */
    public String eliminarMateria(Materia materia) {
        return buscarMateria(materia)
                .map(e -> {
                listaMaterias.remove(materia);
                return "Materia eliminada correctamente";
                })
                .orElse("La materia no esta registrada");
    }

    /**
     * Metodo para actualizar un estudiante de pregrado o de postgrado.
     *
     * @param estudiante
     * @param estudianteActualizado
     * @return
     */
    public String actualizarEstudiante(Estudiante estudiante, Estudiante estudianteActualizado) {
        String mensaje = "El estudiante no se encuentra resgistrado";
        if (buscarEstudiante(estudiante).isPresent()) {
            estudiante.setNombre(estudianteActualizado.getNombre());
            estudiante.setDocumento(estudianteActualizado.getDocumento());
            estudiante.setIdentificador(estudianteActualizado.getIdentificador());
            estudiante.setPrograma(estudianteActualizado.getPrograma());
            estudiante.setSemestre(estudianteActualizado.getSemestre());
            estudiante.setListaMaterias(estudianteActualizado.getListaMaterias());
            mensaje = "Estudiante actualizado correctamente";
        }
        return mensaje;
    }

    /**
     * Metodo para actualizar un profesor catedrático o de planta.
     *
     * @param profesor
     * @param profesorActualizado
     * @return
     */
    public String actualizarProfesor(Profesor profesor, Profesor profesorActualizado) {
        String mensaje = "El profesor no se encuentra resgistrado";
        if (buscarProfesor(profesor).isPresent()) {
            profesor.setIdentificador(profesorActualizado.getIdentificador());
            profesor.setAñosExperiencia(profesorActualizado.getAñosExperiencia());
            profesor.setNombre(profesorActualizado.getNombre());
            profesor.setTitulo(profesorActualizado.getTitulo());
            profesor.setListaMaterias(profesorActualizado.getListaMaterias());
            mensaje = "Profesor actualizado correctamente";
        }
        return mensaje;
    }

    /**
     * Metodo para actualizar una materia teórica o práctica.
     *
     * @param materia
     * @param materiaActualizada
     * @return
     */
    public String actualizarMateria(Materia materia, Materia materiaActualizada) {
        String mensaje = "La materia no se encuentra resgistrada";
        if (buscarMateria(materia).isPresent()) {
            materia.setCodigo(materiaActualizada.getCodigo());
            materia.setNombre(materiaActualizada.getNombre());
            materia.setHorasSemanales(materiaActualizada.getHorasSemanales());
            materia.setCreditos(materiaActualizada.getCreditos());
            materia.setSemestre(materiaActualizada.getSemestre());
            materia.setProfesor(materiaActualizada.getProfesor());
            materia.setListaEstudiantes(materiaActualizada.getListaEstudiantes());
            mensaje = "Materia actualizada correctamente";
        }
        return mensaje;
    }

    /**
     * Metodo que permite buscar una materia teórica o práctica en la lista de materias.
     *
     * @param materia
     * @return
     */
    public Optional<Materia> buscarMateria(Materia materia) {
        return listaMaterias.stream().filter(materia1 -> materia1.getCodigo().equals(materia.getCodigo())).findFirst();
    }

    /**
     * Metodo que permite buscar un estudiante de pregrado o de postgrado.
     *
     * @param estudiante
     * @return
     */
    public Optional<Estudiante> buscarEstudiante(Estudiante estudiante) {
        return listaEstudiantes.stream().filter(estudiante1 -> estudiante1.getIdentificador().equals(estudiante.getIdentificador())).findFirst();
    }

    /**
     * Metodo para buscar un profesor dentro de una lista de profesores.
     *
     * @param profesor
     * @return
     */
    public Optional<Profesor> buscarProfesor(Profesor profesor) {
        return listaProfesores.stream().filter(profesor1 -> profesor1.getIdentificador().equals(profesor.getIdentificador())).findFirst();
    }

    /**
     * Metodo para buscar un semestre dentro de una materia.
     * @param semestre
     * @return
     */
    public Optional<String> buscarSemestre(String semestre) {
        return listaMaterias.stream()
                .filter(materia1 -> materia1.getSemestre().equalsIgnoreCase(semestre))
                .findFirst()
                .map(Materia::getSemestre);
    }

}
