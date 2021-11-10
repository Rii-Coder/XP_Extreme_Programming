package Entities;

import Entities.Curso;
import Entities.Maestro;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-10T12:33:37")
@StaticMetamodel(Grupo.class)
public class Grupo_ { 

    public static volatile SingularAttribute<Grupo, Curso> curso;
    public static volatile SingularAttribute<Grupo, Long> id;
    public static volatile SingularAttribute<Grupo, Maestro> maestro;

}