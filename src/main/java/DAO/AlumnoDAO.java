/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author R2
 */
public class AlumnoDAO extends BaseDAO<Alumno> {

    @Override
    public void agregar(Alumno entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno alumno = entityManager.find(Alumno.class, id);
        if (alumno != null) {
            entityManager.remove(alumno);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Alumno entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno alumno = entityManager.find(Alumno.class, entidad.getId());
        if (alumno != null) {
            alumno.setNombre(entidad.getNombre());
            alumno.setCarrera(entidad.getCarrera());
            alumno.setEdad(entidad.getEdad());
            alumno.setAñoIngreso(entidad.getAñoIngreso());
            alumno.setNumMaterias(entidad.getNumMaterias());
            alumno.setGrupo(entidad.getGrupo());
            entityManager.merge(alumno);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Alumno buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno alumno = entityManager.find(Alumno.class, id);
        entityManager.getTransaction().commit();
        return alumno;
    }

    @Override
    public ArrayList<Alumno> buscarTodas() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Alumno.class));
        Query query = entityManager.createQuery(criteria);
        List<Alumno> alumno = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(alumno);
    }
    
}
