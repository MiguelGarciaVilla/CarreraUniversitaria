package app;
import model.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        CarreraUniversitaria ingenieriaQuimica= new CarreraUniversitaria();
        ProfesorPlanta juanLuis= new ProfesorPlanta("1092459", "Juan Luis", "Doctor", "5", "Cable inalambrico", Dedicacion.TIEMPOCOMPLETO);
        MateriaPractica matematica = new MateriaPractica("0001", "Matematicas", 4, 3, "Primero", juanLuis, 3, 2);
        Materia lengua = new Materia("0002", "Lengua", 4, 3, "Primero", juanLuis);
        Materia quimicos = new Materia("0003", "Quimicos y Reactivos", 4, 3, "Primero", juanLuis);

        //Prueba metodo registrar materias teoricas y practicas.
        System.out.println(ingenieriaQuimica.registarMateria( matematica ));
        System.out.println(ingenieriaQuimica.registarMateria( matematica ));
        System.out.println(ingenieriaQuimica.registarMateria( lengua));
        System.out.println(ingenieriaQuimica.registarMateria( quimicos )+"\n\n");


        ArrayList<Materia> a= ingenieriaQuimica.getListaMaterias();

        for (Materia materia:a){
            System.out.println(materia.toString());
        }

        //Prueba metodo para consultar materias de un semestre especifico.
        System.out.println("\n\n"+ingenieriaQuimica.consultarMateriasSemestre("primero"));

        //Prueba asociar un profesor a una materia.
        MateriaPractica calculo = new MateriaPractica("0004", "Calculo", 4, 3, "Primero", null, 3, 2);
        ProfesorCatedratico pedroJose= new ProfesorCatedratico("1092434", "Pedro Jose", "Doctor", "5", 6, "Comfenalco");
        System.out.println("\n\n"+ingenieriaQuimica.asociarProfesorMateria(pedroJose, calculo)+"\n\n");

        //Prueba incribir estudiante en varias materias.
        ArrayList<Materia> materias= ingenieriaQuimica.getListaMaterias();
        materias.add(matematica);
        EstudiantePreGrado juan= new EstudiantePreGrado("0001", "Juan Carlos", "109248754", "Ingenieria Quimica", "Primero", 4.2);
        ingenieriaQuimica.registrarEstudiante(juan);
        System.out.println(ingenieriaQuimica.inscribirEstudianteMaterias(juan, materias));

        //Prueba listar estudiantes de una asignatura determinada.
        String estudiantesMatematicas= ingenieriaQuimica.listarEstudiantesDeUnaAsignatura(matematica);
        System.out.println("\n"+estudiantesMatematicas);

        //Prueba ver horas semales de una materia.
        String horasMatematicas= ingenieriaQuimica.horasSemanalesMateria("0001");
        System.out.println("\n"+horasMatematicas);
        String horasNaturales= ingenieriaQuimica.horasSemanalesMateria("0090");
        System.out.println("\n"+horasNaturales);

        //Prueba creditos de un estudiante.
        String creditosJuan= ingenieriaQuimica.creditosDeUnEstudiante(juan);
        System.out.println("\n\n"+creditosJuan);












    }
}
