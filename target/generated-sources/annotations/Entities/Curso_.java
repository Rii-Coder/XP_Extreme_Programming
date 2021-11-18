package Entities;

import Entities.Grupo;
import Entities.Maestro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-17T23:19:05")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Integer> unidades;
    public static volatile ListAttribute<Curso, Grupo> grupos;
    public static volatile SingularAttribute<Curso, Long> id;
    public static volatile SingularAttribute<Curso, String> nombre;
    public static volatile SingularAttribute<Curso, Maestro> maestro;

}