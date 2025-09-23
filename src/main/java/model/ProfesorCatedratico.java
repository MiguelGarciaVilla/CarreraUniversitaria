package model;

public  class ProfesorCatedratico extends Profesor {
    int horasPractica;
    int numLaboratorios;

    public ProfesorCatedratico(String identificador, String nombre, String titulo, String añosExperiencia, int horasPractica, int numLaboratorios) {
        super(identificador, nombre, titulo, añosExperiencia);
        this.horasPractica = horasPractica;
        this.numLaboratorios = numLaboratorios;
    }

    public int getHorasPractica() {
        return horasPractica;
    }

    public void setHorasPractica(int horasPractica) {
        this.horasPractica = horasPractica;
    }

    public int getNumLaboratorios() {
        return numLaboratorios;
    }

    public void setNumLaboratorios(int numLaboratorios) {
        this.numLaboratorios = numLaboratorios;
    }
}
