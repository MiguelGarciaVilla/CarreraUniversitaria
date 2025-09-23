package model;

public class EstudiantePostGrado extends Estudiante {
    String temaInvestigacion;

    public EstudiantePostGrado(String identificador, String nombre, String documento, String programa, String semestre, String temaInvestigacion) {
        super(identificador, nombre, documento, programa, semestre);
        this.temaInvestigacion = temaInvestigacion;
    }

    public String getTemaInvestigacion() {
        return temaInvestigacion;
    }
    public void setTemaInvestigacion(String temaInvestigacion) {
        this.temaInvestigacion = temaInvestigacion;
    }

}
