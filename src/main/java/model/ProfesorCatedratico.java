package model;

public  class ProfesorCatedratico extends Profesor {
    int numHoras;
    String empresaExterna;

    public ProfesorCatedratico(String identificador, String nombre, String titulo, String añosExperiencia, int numHoras, String empresaExterna) {
        super(identificador, nombre, titulo, añosExperiencia);
        this.numHoras = numHoras;
        this.empresaExterna = empresaExterna;
    }
    public int getNumHoras() {
        return numHoras;
    }
    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }
    public String getEmpresaExterna() {
        return empresaExterna;
    }
    public void setEmpresaExterna(String empresaExterna) {
        this.empresaExterna = empresaExterna;
    }

    @Override
    public String toString(){
        return super.toString()+", Horas Contratadas: "+numHoras+", Empresa Externa: "+empresaExterna;
    }
}
