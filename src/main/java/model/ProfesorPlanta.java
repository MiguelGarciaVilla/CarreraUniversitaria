package model;

public class ProfesorPlanta extends Profesor {
    String proyectosInvestigacion;
    Dedicacion dedicacion;

    public ProfesorPlanta(String identificador, String nombre, String titulo, String añosExperiencia, String proyectosInvestigacion, Dedicacion dedicacion) {
        super(identificador, nombre, titulo, añosExperiencia);
        this.proyectosInvestigacion = proyectosInvestigacion;
        this.dedicacion= dedicacion;
    }
    public String getProyectosInvestigacion() {
        return proyectosInvestigacion;
    }
    public void setProyectosInvestigacion(String proyectosInvestigacion) {
        this.proyectosInvestigacion = proyectosInvestigacion;
    }
    public Dedicacion getDedicacion() {
        return dedicacion;
    }
    public void setDedicacion(Dedicacion dedicacion) {
        this.dedicacion = dedicacion;
    }

    @Override
    public String toString(){
        return super.toString()+", Proyectos Investigacion: "+proyectosInvestigacion+", Dedicacion: "+dedicacion.toString();
    }
}
