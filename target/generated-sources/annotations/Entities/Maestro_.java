package Entities;

import Entities.Grupo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-10T18:17:10")
@StaticMetamodel(Maestro.class)
public class Maestro_ { 

    public static volatile SingularAttribute<Maestro, String> correo;
    public static volatile ListAttribute<Maestro, Grupo> grupos;
    public static volatile SingularAttribute<Maestro, Long> id;
    public static volatile SingularAttribute<Maestro, String> nombre;
    public static volatile SingularAttribute<Maestro, String> contraseña;

}