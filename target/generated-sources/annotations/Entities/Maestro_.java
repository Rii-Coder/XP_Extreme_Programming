package Entities;

import Entities.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-29T23:22:29")
@StaticMetamodel(Maestro.class)
public class Maestro_ { 

    public static volatile ListAttribute<Maestro, Curso> cursos;
    public static volatile SingularAttribute<Maestro, String> correo;
    public static volatile SingularAttribute<Maestro, Long> id;
    public static volatile SingularAttribute<Maestro, String> nombre;
    public static volatile SingularAttribute<Maestro, String> contraseña;

}