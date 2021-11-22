package Entities;

import Entities.Grupo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-22T13:56:14")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, Integer> numMaterias;
    public static volatile SingularAttribute<Alumno, Grupo> grupo;
    public static volatile SingularAttribute<Alumno, Long> id;
    public static volatile SingularAttribute<Alumno, String> carrera;
    public static volatile SingularAttribute<Alumno, String> nombre;
    public static volatile SingularAttribute<Alumno, Integer> añoIngreso;
    public static volatile SingularAttribute<Alumno, Integer> edad;

}