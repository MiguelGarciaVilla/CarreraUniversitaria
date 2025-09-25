package model;

public class EstudiantePreGrado extends Estudiante {
    private double promedio;

    public EstudiantePreGrado(String identificador, String nombre, String documento, String programa, String semestre, double promedio) {
        super(identificador, nombre, documento, programa, semestre);
        this.promedio = promedio;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString(){
        return super.toString()+", Promedio: "+promedio;
    }
}
