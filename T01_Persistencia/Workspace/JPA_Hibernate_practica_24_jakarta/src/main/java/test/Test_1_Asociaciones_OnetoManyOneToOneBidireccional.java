package test;

import java.util.Date;
import java.util.List;

import entidades.*;
import JPAControladorDao.*;

public class Test_1_Asociaciones_OnetoManyOneToOneBidireccional {
    public static void main(String[]args) {
        
        Date fecha = new Date();
        
        Grupo g1 = new Grupo(1, "grupo1");
        
        Alumno a1 = new Alumno(1, "Hugo", "Fernández", "López", fecha);
        
        Expediente e1 = new Expediente(1, fecha);
            
        //el orden es importante ¿Pero el que hay que tener en cuenta?
        GrupoFacadeJPAImpl gf = new GrupoFacadeJPAImpl();
        
        AlumnoFacadeJPAImpl af = new AlumnoFacadeJPAImpl();
        
        ExpedienteFacadeJPAImpl ef = new ExpedienteFacadeJPAImpl();
        
        //creo un grupo y 
        
        gf.create(g1);
        ef.create(e1);
        
        //creo el alumno
        a1.setGrupo(g1);
        a1.setExpediente(e1);
        af.create(a1);
        
        //creo el expediente
        e1.setAlumno(a1);
        
        
        //le asigno un alumno
        g1.addAlumno(a1);
        
        
        
    }
}