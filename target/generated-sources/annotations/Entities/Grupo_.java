package Entities;

import Entities.Alumno;
import Entities.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-22T13:56:14")
@StaticMetamodel(Grupo.class)
public class Grupo_ { 

    public static volatile ListAttribute<Grupo, Alumno> alumnos;
    public static volatile SingularAttribute<Grupo, Curso> curso;
    public static volatile SingularAttribute<Grupo, Long> id;
    public static volatile SingularAttribute<Grupo, String> nombre;

}